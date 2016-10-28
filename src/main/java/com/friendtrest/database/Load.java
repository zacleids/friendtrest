package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.friendtrest.data.Item;

/**
 * Created by Austin on 10/23/2016.
 */
public class Load {

    public static Item loadItem(String uuid, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        return dbm.load(Item.class, uuid);
    }
}
