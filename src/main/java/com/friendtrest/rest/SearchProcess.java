package com.friendtrest.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by Austin on 10/13/2016.
 */
@Path("/")
public class SearchProcess {

    @GET
    @Path("/query")
    public Response query(@QueryParam("query") String query) {
        return Response.ok("query received '" + query + "'").build();
    }
}
