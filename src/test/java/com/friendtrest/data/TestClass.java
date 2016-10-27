package com.friendtrest.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.UUID;

/**
 * Created by Austin on 10/27/2016.
 */
@DynamoDBTable(tableName = "Test")
public class TestClass {

    private String name;
    private String type;
    private String uuid;

    public TestClass() {}

    public TestClass(String type, String name) {
        uuid = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @DynamoDBRangeKey
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @DynamoDBHashKey
    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }
}
