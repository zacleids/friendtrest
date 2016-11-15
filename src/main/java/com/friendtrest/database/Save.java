package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.friendtrest.data.Item;
import com.friendtrest.data.Review;

/**
 * Created by Austin on 10/23/2016.
 */
public class Save {

    public static <T> void saveObject(T object, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        dbm.save(object);
    }
}
