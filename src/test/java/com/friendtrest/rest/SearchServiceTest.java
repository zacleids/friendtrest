package com.friendtrest.rest;

import static org.hamcrest.CoreMatchers.equalTo;
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
        WebTarget webTarget = target("simpleSearch").queryParam("name", "Hunger");;
        String json = webTarget.request().get(String.class);
        Gson gson = new Gson();
        ArrayList<Item> items = gson.fromJson(json, ArrayList.class);
        assertThat(items.size(), equalTo(2));
    }

    @Test
    public void testResultsForBadData(){
        WebTarget webTarget = target("simpleSearch").queryParam("name", "rjdtxfythhh");;
        String json = webTarget.request().get(String.class);
        Gson gson = new Gson();
        ArrayList<Item> items = gson.fromJson(json, ArrayList.class);
        assertThat(items.size(), equalTo(0));
    }


}
