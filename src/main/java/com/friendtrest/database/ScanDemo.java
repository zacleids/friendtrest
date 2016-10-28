package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.friendtrest.data.Item;

import java.util.Map;

/**
 * Created by Austin on 10/26/2016.
 */
public class ScanDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();

        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);

        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
