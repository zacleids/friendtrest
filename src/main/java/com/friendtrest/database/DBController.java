package com.friendtrest.database;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.s3.model.Region;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

            try {   //properties file
                Properties prop = new Properties();
                prop.load(new FileInputStream("access.ini"));
                access = prop.getProperty("AccessKeyId"); //from access.ini
                secret = prop.getProperty("AWSSecretKey"); //from access.ini
            } catch (FileNotFoundException e) { //environment variables
                access = System.getenv("AWS_ACCESS_KEY_ID");
                secret = System.getenv("AWS_SECRET_ACCESS_KEY");
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

    public AmazonDynamoDB getAmazonDynamoDB() { return client; }

    public DynamoDB getDynamoDB() {
        return item_db;
    }
}
