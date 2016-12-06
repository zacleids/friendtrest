package com.friendtrest.rest;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.friendtrest.Movie_old;
import com.friendtrest.data.Item;
import com.google.gson.Gson;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import java.util.ArrayList;

/**
 * Created by Zac Leids.
 */
public class Leids_MovieSearchServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Leids_MovieSearchService.class);
    }

    @Test
    public void testGetMovies() {
        WebTarget webTarget = target("getMovies").queryParam("name", "deadpool").queryParam("year", 2016).queryParam("genre","");
        String json = webTarget.request().get(String.class);
        Gson gson = new Gson();
        ArrayList<Movie_old> m = gson.fromJson(json, ArrayList.class);
        assertThat(m.size(), equalTo(1));
    }

}