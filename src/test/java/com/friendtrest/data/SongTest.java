package com.friendtrest.data;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Zac Leids on 11/7/2016.
 */
public class SongTest {
    Song s;
    String name;
    String description;
    ArrayList<String> tags = new ArrayList<String>();
    String releaseDate;
    String url;
    String artist;
    int min;
    int sec;

    @Before
    public void setUp(){
        name = "Still Alive";
        description = "Song sung by GLADoS during the credits of the video game Portal";
        tags.add("portal");
        tags.add("robot");
        tags.add("code");
        releaseDate = "2007";
        url = "https://images.duckduckgo.com/iu/?u=http%3A%2F%2Ffc08.deviantart.net%2Ffs35%2Fi%2F2008%2F301%2F9%2F1%2FPortal___Still_Alive_by_Zeptozephyr.jpg&f=1";
        artist = "Jonathan Coulton";
        min = 2;
        sec = 56;

        s = new Song(
                name,
                description,
                tags,
                releaseDate,
                artist,
                min,
                sec,
                url
        );
    }


    @Test
    public void testGetName(){
        assertThat(s.getName(), equalTo(name));
    }

    @Test
    public void testGetDescription(){
        assertThat(s.getDescription(), equalTo(description));
    }

    @Test
    public void testNumTags(){
        assertThat(s.getNumTags(), equalTo(tags.size()));
    }

    @Test
    public void testGetReleaseDate(){
        assertThat(s.getReleaseDate(), equalTo(releaseDate));
    }

    @Test
    public void testGetURL(){
        assertThat(s.getURL(), equalTo(url));
    }

    @Test
    public void testGetArtist(){
        assertThat(s.getArtist(), equalTo(artist));
    }

    @Test
    public void testGetMin(){
        assertThat(s.getMin(), equalTo(min));
    }

    @Test
    public void testGetSec(){
        assertThat(s.getSeconds(), equalTo(sec));
    }
}
