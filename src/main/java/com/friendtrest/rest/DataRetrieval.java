package com.friendtrest.rest;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.friendtrest.data.Item;
import com.friendtrest.database.DBController;

import com.friendtrest.database.Scan;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Austin on 10/26/2016.
 */
@Path("/")
public class DataRetrieval {

    @GET
    @Path("/data")
    public Response query() {
        DBController dbc = new DBController();

        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        String json = new Gson().toJson(items);

        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
