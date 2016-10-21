package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

/**
 * Created by Austin on 10/21/2016.
 */

public class DBControllerDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();
        DynamoDB item_db = dbc.getDynamoDB();
        System.out.println(item_db.listTables());
        dbc.close();
    }
}
