package com.friendtrest.data;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by Zac Leids on 10/13/2016.
 */
public class MovieTest {
    Movie m;
    String title;
    String description;
    ArrayList<String> tags = new ArrayList<String>();
    String releaseDate;
    ArrayList<String> cast = new ArrayList<String>();
    String director;
    String ratting;
    int runTime;
    String url;

    OMDbObject o = new OMDbObject();

    @Before
    public void setUp(){
        title = "Deadpool";
        description = "Crazy person with powers";
        tags.add("Action");
        tags.add("Adventure");
        tags.add("Comedy");
        releaseDate = "2016";
        cast.add("Ryan Reynolds");
        cast.add("Ed Skrein");
        cast.add("Karan Soni");
        director = "Tim Miller";
        ratting = "R";
        runTime = 128;
        url = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjQyODg5Njc4N15BMl5BanBnXkFtZTgwMzExMjE3NzE@._V1_UY268_CR1,0,182,268_AL_.jpg";

        m = new Movie(
                title,
                description,
                tags,
                releaseDate,
                cast,
                director,
                ratting,
                runTime,
                url
        );


        o.Title = title;
        o.Year = releaseDate;
        o.Rated = ratting;
        o.Runtime = Integer.toString(runTime);
        o.Genre = "Action, Adventure, Comedy";
        o.Director = director;
        o.Actors = "Ryan Reynolds, Ed Skrein, Karan Soni";
        o.Plot = description;
        o.Poster = url;


    }


    @Test
    public void testGetName(){
        assertThat(m.getName(), equalTo(title));
    }

    @Test
    public void testGetDescription(){
        assertThat(m.getDescription(), equalTo(description));
    }

    @Test
    public void testNumTags(){
        assertThat(m.getNumTags(), equalTo(tags.size()));
    }

    @Test
    public void testGetReleaseDate(){
        assertThat(m.getReleaseDate(), equalTo(releaseDate));
    }

    @Test
    public void testGetURL(){
        assertThat(m.getURL(), equalTo(url));
    }

    @Test
    public void testCastExists(){
        assertThat(m.getActors(), equalTo(cast));
    }

    @Test
    public void testGetDirector(){
        assertThat(m.getDirector(), equalTo(director));
    }

    @Test
    public void testGetRatting(){
        assertThat(m.getMPAARating(), equalTo(ratting));
    }

    @Test
    public void testGetRunTime(){
        assertThat(m.getRunTimeInMinutes(), equalTo(runTime));
    }

    @Test
    public void testGetTags(){
        assertThat(m.getTags(), equalTo(tags));
    }

    @Test
    public void testGetUUID(){
        assertThat(m.getUUID(), notNullValue());
    }

    @Test
    public void testAddTag(){
        int n = m.getNumTags();
        m.addTag("Test");
        assertThat(n+1, equalTo(m.getNumTags()));
    }

    @Test
    public void testRemoveTag(){
        int n = m.getNumTags();
        m.removeTag("Adventure");
        assertThat(n-1, equalTo(m.getNumTags()));
    }

    @Test
    public void testOMDbConversionToMovie(){
        Movie test = new Movie(o);
        assertThat(m.getName(), equalTo(test.getName()));
    }


}