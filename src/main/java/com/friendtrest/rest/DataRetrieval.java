package com.friendtrest.rest;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

import com.friendtrest.OMDBconverter;
import com.friendtrest.data.Item;
import com.friendtrest.data.Review;
import com.friendtrest.data.User;
import com.friendtrest.database.DBController;

import com.friendtrest.database.Load;
import com.friendtrest.database.Save;
import com.friendtrest.database.Scan;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.*;

@Path("/")
public class DataRetrieval {
    private static final DBController dbc = new DBController();
    private OMDBconverter omdb = new OMDBconverter();
    AmazonDynamoDB client = dbc.getAmazonDynamoDB();

    @GET
    @Path("/query")
    public Response query(@QueryParam("query") String query) {
        return Response.ok("query received '" + query + "'").build();
    }

    @GET
    @Path("/data")
    public Response getData(@QueryParam("facebook_id") String facebook_id) {
        PaginatedScanList<Item> all_items2 = Scan.getItemsTable(dbc);
        List<Item> all_items = new ArrayList<Item>(all_items2.size());
        for (Item item : all_items2)
            all_items.add(item);
        Collections.shuffle(all_items, new Random());
        List<Item> items = all_items.subList(0, 20);
        HashSet<String> item_ids = new HashSet<String>();
        for (Item item : items)
            item_ids.add(item.getUuid());

        User user = Load.loadUser(facebook_id, dbc);
        List<String> friend_ids = user.getFriends();
        HashMap<String, String> friend_pics = new HashMap<String, String>(friend_ids.size());
        for (String friend_id : friend_ids) {
            User friend = Load.loadUser(friend_id, dbc);
            friend_pics.put(friend_id, friend.getPictureURL());
        }

        PaginatedScanList<Review> all_reviews = Scan.getReviewsTable(dbc);
        Object[][] rating_pics = new Object[items.size()][3];

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            rating_pics[i][0] = item;

            List<Double> ratings = new ArrayList<Double>();
            List<String> pic_urls = new ArrayList<String>();
            for (Review review : all_reviews) {
                if (item.getUuid().equals(review.getItem_id())) {
                    ratings.add(review.getRating());
                    pic_urls.add(friend_pics.get(review.getFacebook_id()));
                }
            }

            rating_pics[i][1] = ratings;
            rating_pics[i][2] = pic_urls;
        }

        String items_as_json = new Gson().toJson(rating_pics);

        return Response.ok(items_as_json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/reviewTest")
    public Response getTestReview(@QueryParam("uuid") String uuid) {
        Review review = Load.loadReview(uuid, dbc);
        String json = new Gson().toJson(review);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/reviewTestSubmit")
    public Response submitTestReview(
            @QueryParam("uuid") String uuid,
            @QueryParam("rating") double rating,
            @QueryParam("review_text") String review_text,
            @QueryParam("item_id") String item_id,
            @QueryParam("user_id") String user_id
    ) {
        Review review = new Review();
        review.setUuid(uuid);
        review.setRating(rating);
        review.setReview_text(review_text);
        review.setItem_id(item_id);
        review.setFacebook_id(user_id);
        Save.saveObject(review, dbc);

        return Response.ok("ok").build();
    }

    @GET
    @Path("/apitest")
    public Response apitest(@QueryParam("name") String name, @QueryParam("year") String year){
        ArrayList<Item> itemsToShow = new ArrayList<>();
        try {
            itemsToShow.add(omdb.search(name, ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = new Gson().toJson(itemsToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/simpleSearch")
    public Response simpleSearch(@QueryParam("name") String name){
        if(name == null) name = "";
        ArrayList<Item> itemsToShow = getItems(name, "", "");
        if(itemsToShow.size() == 0){
            try {
                Item i = omdb.search(name, "");
                if( i != null) itemsToShow.add(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String json = new Gson().toJson(itemsToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/search")
    public Response search(@QueryParam("name") String name, @QueryParam("year") String year, @QueryParam("tags") String tagString){
        if(name == null) name = "";
        if(year == null) year = "";
        if(tagString == null) tagString = "";
        ArrayList<Item> itemsToShow = getItems(name, year, tagString);
        if(itemsToShow.size() == 0){
            try {
                Item i = omdb.search(name, year);
                if( i != null) itemsToShow.add(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String json = new Gson().toJson(itemsToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("retrieveItem")
    public Response retrieveItem(@QueryParam("uuid") String uuid){
        Item itemToReturn = null;
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        for (Item item : items) {
            if(item.getUuid().equals(uuid)){
                itemToReturn = item;
                break;
            }
        }
        String json = new Gson().toJson(itemToReturn);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    private ArrayList<Item> getItems(String name, String year, String tagString) {
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        ArrayList<String> tags = new ArrayList<String>(Arrays.asList(tagString.split(",")));
        ArrayList<Item> itemsToShow = new ArrayList<Item>();
        for (Item item : items) {
            if((name.equals("") || containsEqualsIgnoresCase(item.getName(), name)) && (year.equals("") || item.getReleaseDate().equals(year)) && (tagString.equals("") || arrayListContains(item.getTags(), tags))){
                itemsToShow.add(item);
            }
        }
        return itemsToShow;
    }

    private boolean arrayListContains(List<String> main, ArrayList<String> other){
        for(String s : other){
            if(!main.contains(s)){
                return false;
            }
        }
        return true;
    }

    private boolean containsEqualsIgnoresCase(String master, String partial){
        return master.toLowerCase().contains(partial.toLowerCase());
    }

}
