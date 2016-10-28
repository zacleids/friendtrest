package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.friendtrest.data.Item;

import java.util.List;
import java.util.Map;

/**
 * Created by Austin on 10/27/2016.
 */
public class Scan {

    public static List<Map<String, AttributeValue>> getTable(String table, DBController dbc) {
        AmazonDynamoDB client = dbc.getAmazonDynamoDB();
        ScanRequest scanRequest = new ScanRequest().withTableName(table);   //grab whole table
        return client.scan(scanRequest).getItems();     //converts to List
    }

    public static PaginatedScanList<Item> getItemsTable(DBController dbc) {
        DynamoDBMapper dbm = new DynamoDBMapper(dbc.getAmazonDynamoDB());
        return dbm.scan(Item.class, new DynamoDBScanExpression());
    }

}
