package com.friendtrest.database;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.friendtrest.data.TestClass;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Austin on 10/27/2016.
 */
public class SaveIT {

    AmazonDynamoDB client;
    DBController dbc;
    DynamoDBMapper dbm;

    List<TestClass> delete;

    @Before
    public void setUp() {
        dbc = new DBController();
        client = dbc.getAmazonDynamoDB();
        dbm = new DynamoDBMapper(client);
        delete = new ArrayList<TestClass>();
    }

    @After
    public void tearDown() {
        for (TestClass tc : delete) {
            dbm.delete(tc);
        }
    }

    @Test
    public void testNewRecord() {   //inserts a new record
        TestClass test = new TestClass("Movie", "A Movie");
        delete.add(test);   //will be deleted after tests
        ScanRequest scanRequest = new ScanRequest().withTableName("Test");
        int size1 = client.scan(scanRequest).getItems().size(); //size of table

        dbm.save(test);
        scanRequest = new ScanRequest().withTableName("Test");
        int size2 = client.scan(scanRequest).getItems().size(); //size of table
        TestClass test2 = dbm.load(TestClass.class, test.getUuid(), test.getType());

        assertEquals(size2, size1+1);   //table size has increased by 1
        assertEquals(test.getUuid(), test2.getUuid());  //retrieved Object with same uuid from DB
    }

    @Test
    public void testUpdateRecord() {    //should not duplicate, will update DB info if primary and secondary key unchanged
        TestClass test = new TestClass("Movie", "Another Movie");
        delete.add(test);

        dbm.save(test);
        ScanRequest scanRequest = new ScanRequest().withTableName("Test");
        int size1 = client.scan(scanRequest).getItems().size(); //size of table
        test.setName("Another Move 2"); //change item attribute (not primary or secondary key)
        dbm.save(test);
        scanRequest = new ScanRequest().withTableName("Test");
        int size2 = client.scan(scanRequest).getItems().size(); //size of table
        TestClass test2 = dbm.load(TestClass.class, test.getUuid(), test.getType());

        assertEquals(size1, size2); //table size unchanged
        assertEquals(test.getUuid(), test2.getUuid());
    }
}
