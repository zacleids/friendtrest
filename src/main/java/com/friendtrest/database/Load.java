package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.friendtrest.data.Item;
import com.friendtrest.data.Review;
import com.friendtrest.data.User;

/**
 * Created by Austin on 10/23/2016.
 */
public class Load {

    public static Item loadItem(String uuid, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        return dbm.load(Item.class, uuid);
    }

    public static Review loadReview(String uuid, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        return dbm.load(Review.class, uuid);
    }

    public static User loadUser(String facebook_id, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        return dbm.load(User.class, facebook_id);
    }
}
