package com.friendtrest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Zac Leids.
 */
public class Movie_oldTest {
    Movie_old m;
    String name;
    int releaseYear;
    String MPAARating;
    ArrayList<String> cast = new ArrayList<String>();
    ArrayList<String> tags = new ArrayList<String>();

    @Before
    public void setUp() throws Exception {
        name = "Deadpool";
        releaseYear = 2016;
        MPAARating = "R";
        cast.add("Keanu Reeves");
        cast.add("Laurence Fishburne");
        cast.add("Carrie-Anne Moss");
        tags.add("Sci-Fi");
        tags.add("Action");

        m = new Movie_old(name, releaseYear, MPAARating, cast, tags);

    }

    @Test
    public void testGetName(){
        assertThat(m.getName(), equalTo(name));
    }

    @Test
    public void testGetReleaseYear(){
        assertThat(m.getReleaseYear(), equalTo(releaseYear));
    }

    @Test
    public void testSetReleaseYear(){
        int year = 2015;
        m.setReleaseYear(year);
        assertThat(m.getReleaseYear(), equalTo(year));
        m.setReleaseYear(releaseYear);
    }

    @Test
    public void testGetMPAARating(){
        assertThat(m.getMPAARating(), equalTo(MPAARating));
    }

    @Test
    public void testSetMPAARating(){
        String rating = "X";
        m.setMPAARating(rating);
        assertThat(m.getMPAARating(), equalTo(rating));
        m.setMPAARating(MPAARating);
    }

    @Test
    public void testGetCast(){
        assertThat(m.getCast(), equalTo(cast));
    }

    @Test
    public void testSetCast(){
        ArrayList<String> c = new ArrayList<String>();
        c.add("deadpool");
        m.setCast(c);
        assertThat(m.getCast(), equalTo(c));
        m.setCast(cast);
    }

    @Test
    public void testGetTags(){
        assertThat(m.getTags(), equalTo(tags));
    }


}