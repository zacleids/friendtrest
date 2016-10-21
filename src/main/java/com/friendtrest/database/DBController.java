package com.friendtrest.database;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.s3.model.Region;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Austin on 10/21/2016.
 */
public class DBController {

    private DynamoDB item_db;
    private AmazonDynamoDB client;

    public DBController() {
        try {
            String access;
            String secret;

            if (new File("access.ini").exists()) { //properties file
                Properties prop = new Properties();
                prop.load(new FileInputStream("access.ini"));
                access = prop.getProperty("Access"); //from access.ini
                secret = prop.getProperty("Secret"); //from access.ini
                System.out.println(access);
            } else { // environment variables
                access = System.getenv("Access");
                secret = System.getenv("Secret");
            }

            client = new AmazonDynamoDBClient(new BasicAWSCredentials(access, secret));
            client.setRegion(Region.US_West.toAWSRegion()); // US West
            item_db = new DynamoDB(client);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        item_db.shutdown();
        client.shutdown();
    }

    public DynamoDB getDynamoDB() {
        return item_db;
    }
}
