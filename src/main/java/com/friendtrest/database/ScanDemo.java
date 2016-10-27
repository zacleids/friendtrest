package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import java.util.Map;

/**
 * Created by Austin on 10/26/2016.
 */
public class ScanDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();
        AmazonDynamoDB client = dbc.getAmazonDynamoDB();

        ScanRequest scanRequest = new ScanRequest().withTableName("Items");

        ScanResult result = client.scan(scanRequest);

        for (Map<String, AttributeValue> item : result.getItems()){
            System.out.println(item);
        }
    }
}
