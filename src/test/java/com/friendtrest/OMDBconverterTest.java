package com.friendtrest;

import com.friendtrest.data.Item;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Zac Leids.
 */
public class OMDBconverterTest {
    private OMDBconverter omdb = new OMDBconverter();

    @Test
    public void testGetMovie() throws IOException {
        Item item = omdb.search("Frozen", "", false);
        assertThat(item.getName(), equalTo("Frozen"));
    }

    @Test
    public void testGetTVShow() throws IOException {
        Item item = omdb.search("The Flash", "", false);
        assertThat(item.getReleaseDate(), equalTo("2014"));
    }

    @Test
    public void testNullTitle() throws IOException {
        Item item = omdb.search(null, "1990", false);
        assertNull(item);
    }

    @Test
    public void testNullYear() throws IOException {
        Item item = omdb.search("Doctor Strange", null, false);
        assertThat(item.getName(), equalTo("Doctor Strange"));
    }

}