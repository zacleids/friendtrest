package com.friendtrest.data;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Zac Leids on 11/7/2016.
 */
public class AlbumTest {
    Album a;
    String name;
    String description;
    List<String> tags = new ArrayList<String>();
    String releaseDate;
    String url;
    String artist;
    List<String> songs = new ArrayList<String>();

    @Before
    public void setUp(){
        name = "Yellow Submarine Songtrack";
        description = "Beatles collection album";
        tags.add("beatles");
        tags.add("submarine");
        tags.add("yellow");
        releaseDate = "1999";
        url = "http://d817ypd61vbww.cloudfront.net/sites/default/files/tile/image/original_457.jpg";
        artist = "The Beatles";
        songs.add("Yellow Submarine");
        songs.add("Lucy in the Sky with Diamonds");
        songs.add("Love You To");
        songs.add("All You Need Is Love");
        songs.add("It's All Too Much");

        a = new Album(
                name,
                description,
                tags,
                releaseDate,
                artist,
                songs,
                url
        );
    }

    @Test
    public void testGetName(){
        assertThat(a.getName(), equalTo(name));
    }

    @Test
    public void testGetDescription(){
        assertThat(a.getDescription(), equalTo(description));
    }

    @Test
    public void testNumTags(){
        assertThat(a.getNumTags(), equalTo(tags.size()));
    }

    @Test
    public void testGetReleaseDate(){
        assertThat(a.getReleaseDate(), equalTo(releaseDate));
    }

    @Test
    public void testGetURL(){
        assertThat(a.getUrl(), equalTo(url));
    }

    @Test
    public void testGetArtist(){
        assertThat(a.getArtist(), equalTo(artist));
    }

    @Test
    public void testGetSongs(){
        assertThat(a.getSongs(), equalTo(songs));
    }

    @Test
    public void testNumSongs(){
        assertThat(a.getNumSongs(), equalTo(songs.size()));
    }

    @Test
    public void testSetArtist(){
        String tempArtist = "temp";
        a.setArtist(tempArtist);
        assertThat(a.getArtist(), equalTo(tempArtist));
        a.setArtist(artist);
    }

    @Test
    public void testSetSongs(){
        List<String> tempSongs = new ArrayList<String>();
        tempSongs.add("not a song");
        a.setSongs(tempSongs);
        assertThat(a.getSongs(), equalTo(tempSongs));
        a.setSongs(songs);
    }
}
