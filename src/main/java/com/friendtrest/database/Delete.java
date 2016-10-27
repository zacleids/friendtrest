package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * Created by Austin on 10/27/2016.
 */
public class Delete {

    public static void deleteItem(Object o, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        dbm.delete(o);
    }
}
