package com.friendtrest.rest;


import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.friendtrest.data.Item;
import com.friendtrest.database.DBController;

import com.friendtrest.database.Scan;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Austin on 10/26/2016.
 */
@Path("/")
public class DataRetrieval {
    private static final DBController dbc = new DBController();
    AmazonDynamoDB client = dbc.getAmazonDynamoDB();

    @GET
    @Path("/data")
    public Response query() {
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        String json = new Gson().toJson(items);

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/simpleSearch")
    public Response simpleSearch(@QueryParam("name") String name){
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        ArrayList<Item> itemsToShow = new ArrayList<Item>();
        for (Item item : items) {
            //System.out.println(item.getName());
            if(item.getName().contains(name)){
                itemsToShow.add(item);
            }
        }
        String json = new Gson().toJson(itemsToShow);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/search")
    public Response search(){

        return Response.ok("temp").build();
    }
}
