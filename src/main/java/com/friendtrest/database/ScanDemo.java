package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

/**
 * Created by austinzielinski on 10/26/16.
 */
public class ScanDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();
        AmazonDynamoDB client = dbc.getAmazonDynamoDB();

        ScanRequest sr = new ScanRequest().withTableName("Items");
        ScanResult result = client.scan(sr);
    }
}
