package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.friendtrest.data.Item;

/**
 * Created by Austin on 10/23/2016.
 */
public class Save {

    public static void saveItem(Item item, DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        dbm.save(item);
    }
}
