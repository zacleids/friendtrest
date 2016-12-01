package com.friendtrest.rest;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;

import com.friendtrest.data.Item;
import com.friendtrest.data.Review;
import com.friendtrest.database.DBController;
import com.friendtrest.User;

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
public class UserService {
	private static final DBController dbc = new DBController();
	AmazonDynamoDB client = dbc.getAmazonDynamoDB();

	@GET
	@Path("/createUser")
	public Response createUser(@QueryParam("name") String username,
		@QueryParam("email") String email,
		@QueryParam("profilepic") String profilepic,
        @QueryParam("facebookID") String facebookID,
		@QueryParam("friends") String friends) {

		// turn friends into a list
		String[] friendsArray = friends.split(",");
		ArrayList<String> friendsList = new ArrayList<String>(Arrays.asList(friendsArray));

        // create the user with the information passed from javascript side
		User user = new User(username, email, profilepic, facebookID, friendsList);

        // this saves the object in the databse
		Save.saveObject(user, dbc);

		return Response.ok("User Account Created for " + user.getName()).build();
	}

	@GET
	@Path("/getUser")
	public void getUser() {
		PaginatedScanList<Item> all_items = Scan.getItemsTable(dbc);
		String items_as_json = new Gson().toJson(all_items);

		//return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
}
