package com.friendtrest.database;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class DBControllerIT {

    DBController dbc;
    DynamoDB dynamoDB;
    List<Table> delete;

    @Before
    public void setUp() {
        dbc = new DBController();
        dynamoDB = new DynamoDB(dbc.getAmazonDynamoDB());
        delete = new ArrayList<Table>();
    }

    @After
    public void tearDown() {
        dbc.close();
    }

    @Test
    public void testCreateTable() throws InterruptedException {
        String table_name = "TestCreate";

        createTable("TestCreate", 1L, 1L, "id", "N", null, null);
        TableCollection<ListTablesResult> tables = dynamoDB.listTables();

         
    }

    private void createTable(String tableName, long readCapacityUnits, long writeCapacityUnits,
            String partitionKeyName, String partitionKeyType, String sortKeyName, String sortKeyType)
            throws InterruptedException {

            ArrayList<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
            keySchema.add(new KeySchemaElement()
                    .withAttributeName(partitionKeyName)
                    .withKeyType(KeyType.HASH)); //Partition key

            ArrayList<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
            attributeDefinitions.add(new AttributeDefinition()
                    .withAttributeName(partitionKeyName)
                    .withAttributeType(partitionKeyType));

            if (sortKeyName != null) {
                keySchema.add(new KeySchemaElement()
                        .withAttributeName(sortKeyName)
                        .withKeyType(KeyType.RANGE)); //Sort key
                attributeDefinitions.add(new AttributeDefinition()
                        .withAttributeName(sortKeyName)
                        .withAttributeType(sortKeyType));
            }

            CreateTableRequest request = new CreateTableRequest()
                    .withTableName(tableName)
                    .withKeySchema(keySchema)
                    .withProvisionedThroughput( new ProvisionedThroughput()
                            .withReadCapacityUnits(readCapacityUnits)
                            .withWriteCapacityUnits(writeCapacityUnits));

            request.setAttributeDefinitions(attributeDefinitions);

            Table table = dynamoDB.createTable(request);
            table.waitForActive();
    }
}
