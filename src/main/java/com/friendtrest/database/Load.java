package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.friendtrest.data.Item;

/**
 * Created by Austin on 10/23/2016.
 */
public class Load {

    public static Item loadItem(DBController dbc, String uuid) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());

        try {
            return dbm.load(Item.class, uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
