package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
<<<<<<< 27db29f8e2b2d0579e13dafa1cbed63fbc72837a
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

/**
 * Created by austinzielinski on 10/26/16.
=======
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import java.util.List;
import java.util.Map;

/**
 * Created by Austin on 10/26/2016.
>>>>>>> changed item functionality to work better with the database and inheritance
 */
public class ScanDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();
        AmazonDynamoDB client = dbc.getAmazonDynamoDB();

        ScanRequest scanRequest = new ScanRequest().withTableName("Items");

        ScanResult result = client.scan(scanRequest);

        for (Map<String, AttributeValue> item : result.getItems()){
            System.out.println(item.get("name"));
        }
    }
}
