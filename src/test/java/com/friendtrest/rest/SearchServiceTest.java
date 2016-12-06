package com.friendtrest.rest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import com.friendtrest.data.Item;
import com.google.gson.Gson;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import java.util.ArrayList;

/**
 * Created by Zac Leids on 11/7/2016.
 */
public class SearchServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(DataRetrieval.class);
    }

    @Test
    public void testResultsForHungerGames(){
        ArrayList<Item> items = getItems("simpleSearch", "name", "Hunger");
        assertThat(items.size(), equalTo(1));
    }

    @Test
    public void testResultsForBadData(){
        ArrayList<Item> items = getItems("simpleSearch", "name", "rjdtxfythhh");
        assertThat(items.size(), equalTo(0));
    }

    @Test
    public void testSimpleSearchForNull(){
        ArrayList<Item> items = getItems("simpleSearch", "name", null);
        assertThat(items.size(), is(not(equalTo(0))));
    }

    @Test
    public void testSearchforArrow(){
        ArrayList<Item> items = getItems("search", "name", "Arrow");
        assertThat(items.size(), equalTo(1));
    }

    @Test
    public void testSearchforBadData(){
        ArrayList<Item> items = getItems("search", "name", "rjdtxfythhh");
        assertThat(items.size(), equalTo(0));
    }

    @Test
    public void testSearchforAllItems(){
        ArrayList<Item> items = getItems("search", "name", "");
        assertThat(items.size(), is(not(equalTo(0))));
    }

    @Test
    public void testSearchWithYear(){
        ArrayList<Item> items = getItems("search", "year", "1999");
        assertThat(items.size(), equalTo(3));
    }

    @Test
    public void testDataEndpoint(){
        WebTarget webTarget = target("data");
        String json = webTarget.request().get(String.class);
        Gson gson = new Gson();
        ArrayList<Item> items = gson.fromJson(json, ArrayList.class);
        assertThat(items.size(), is(not(equalTo(0))));
    }

    @Test
    public void testRetrieveItem(){
        //1694852b-97d8-4553-ab7c-6c58ff3d8c73 -> The Matrix
        String s = "1694852b-97d8-4553-ab7c-6c58ff3d8c73";
        WebTarget webTarget = target("retrieveItem").queryParam("uuid", s);
        String json = webTarget.request().get(String.class);
        Gson gson = new Gson();
        Item i = gson.fromJson(json, Item.class);
        assertThat(i.getName(), equalTo("The Matrix"));
    }

    @Test
    public void testQueryEndpoint(){
        String q = "test";
        WebTarget webTarget = target("query").queryParam("query", q);
        String response = webTarget.request().get(String.class);
        assertThat(response, equalTo("query received '" + q + "'"));
    }

    private ArrayList<Item> getItems(String endPoint, String param, String data) {
        WebTarget webTarget = target(endPoint).queryParam(param, data);
        String json = webTarget.request().get(String.class);
        Gson gson = new Gson();
        return gson.fromJson(json, ArrayList.class);
    }


}
