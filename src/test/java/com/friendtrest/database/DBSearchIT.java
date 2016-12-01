package com.friendtrest.database;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedScanList;
import com.friendtrest.data.Item;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Zac Leids on 11/6/2016.
 */
public class DBSearchIT {
    DBController dbc = new DBController();

    @Test
    public void testGetRecords(){
        String name = "Hunger";
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        ArrayList<Item> itemsToShow = new ArrayList<Item>();
        for (Item item : items) {
            //System.out.println(item.getName());
            if(item.getName().contains(name)){
                itemsToShow.add(item);
            }
        }
        assertTrue(itemsToShow.size() == 1);
    }

    @Test
    public void testZeroRecords(){
        String name = "rjdtxfythhh";
        PaginatedScanList<Item> items = Scan.getItemsTable(dbc);
        ArrayList<Item> itemsToShow = new ArrayList<Item>();
        for (Item item : items) {
            //System.out.println(item.getName());
            if(item.getName().contains(name)){
                itemsToShow.add(item);
            }
        }
        assertTrue(itemsToShow.size() == 0);
    }
}
