package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.friendtrest.data.Item;

/**
 * Created by Austin on 10/23/2016.
 */
public class Create {

    public static boolean createRow(DBController dbc, Item item) {
        System.out.println("here");
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());

        try {
            dbm.save(item);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
