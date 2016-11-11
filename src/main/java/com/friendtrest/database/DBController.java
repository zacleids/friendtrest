package com.friendtrest.database;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.PropertiesFileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.s3.model.Region;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Loads AWS DynamoDB credentials from access.ini (local filesystem)
 * or AWS Environment Variables (Elastic Beanstalk)
 */

public class DBController {

    private static final String CREDENTIALS_FILE_PATH = "access.ini";

    private AmazonDynamoDBClient client;
    private DynamoDB dynamoDB;

    public DBController() {
        client = new AmazonDynamoDBClient(getCredentialsProvider());
        client.setRegion(Region.US_West.toAWSRegion()); // US West
        dynamoDB = new DynamoDB(client);
    }

    public void close() {
        dynamoDB.shutdown();
        client.shutdown();
    }

    public AmazonDynamoDB getAmazonDynamoDB() { return client; }

    private static AWSCredentialsProvider getCredentialsProvider() {
        if (new File(CREDENTIALS_FILE_PATH).exists()) {
            // reads properties accessKey, secretKey
            return new PropertiesFileCredentialsProvider(CREDENTIALS_FILE_PATH);
        } else {
            // first looks at env vars AWS_ACCESS_KEY_ID, AWS_SECRET_ACCESS_KEY
            // then sys props aws.accessKeyId, aws.secretKey
            // then file ~/.aws/credentials
            // see http://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html
            return new DefaultAWSCredentialsProviderChain();
        }
    }

    public DynamoDB getDynamoDB() {
        return dynamoDB;
    }
}
