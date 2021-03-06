package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.friendtrest.data.Item;

/**
 * Created by Austin on 10/27/2016.
 */
public class Delete {

    public static <T> void deleteItem(T object, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        dbm.delete(object);
    }
}
