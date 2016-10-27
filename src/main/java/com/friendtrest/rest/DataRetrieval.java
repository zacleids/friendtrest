package com.friendtrest.rest;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.friendtrest.database.DBController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
        AmazonDynamoDB client = dbc.getAmazonDynamoDB();

        ScanRequest scanRequest = new ScanRequest().withTableName("Items");

        ScanResult result = client.scan(scanRequest);
        return Response.ok("response hello").build();
    }
}
