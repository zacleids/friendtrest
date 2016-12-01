package com.friendtrest.rest;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

import com.friendtrest.data.Item;
import com.friendtrest.data.Review;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("/")
public class DataRetrieval {
    private static final DBController dbc = new DBController();
    AmazonDynamoDB client = dbc.getAmazonDynamoDB();

    @GET
    @Path("/query")
    public Response query(@QueryParam("query") String query) {
        return Response.ok("query received '" + query + "'").build();
    }

    @GET
    @Path("/data")
    public Response query() {
        PaginatedScanList<Item> all_items = Scan.getItemsTable(dbc);
        String items_as_json = new Gson().toJson(all_items);

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
        review.setUser_id(user_id);
        Save.saveObject(review, dbc);

        return Response.ok("ok").build();
    }

    @GET
    @Path("/simpleSearch")
    public Response simpleSearch(@QueryParam("name") String name){
        ArrayList<Item> itemsToShow = getItems(name, "", "");
        String json = new Gson().toJson(itemsToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/search")
    public Response search(@QueryParam("name") String name, @QueryParam("year") String year, @QueryParam("tags") String tagString){
        ArrayList<Item> itemsToShow = getItems(name, year, tagString);
        String json = new Gson().toJson(itemsToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    private ArrayList<Item> getItems(String name, String year, String tagString) {
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        ArrayList<String> tags = new ArrayList<String>(Arrays.asList(tagString.split(",")));
        ArrayList<Item> itemsToShow = new ArrayList<Item>();
        for (Item item : items) {
            if((name.equals("") || item.getName().contains(name)) && (year.equals("") || item.getReleaseDate().equals(year)) && (tagString.equals("") || arrayListContains(item.getTags(), tags))){
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

}
