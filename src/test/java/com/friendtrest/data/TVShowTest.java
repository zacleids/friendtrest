package com.friendtrest.data;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Zac Leids on 11/7/2016.
 */
public class TVShowTest {
    TVShow tvShow;
    String title;
    String description;
    ArrayList<String> tags = new ArrayList<String>();
    String releaseDate;
    ArrayList<String> cast = new ArrayList<String>();
    String director;
    int numSeasons;
    String url;

    @Before
    public void setUp(){
        title = "The Flash";
        description = "A forensic scientist get supper speed from a particle accelerator explosion and becomes a superhero known as the flash";
        tags.add("Action");
        tags.add("Adventure");
        tags.add("Comedy");
        releaseDate = "2014";
        cast.add("Grant Gustin");
        cast.add("Candice Patton");
        cast.add("Tom Cavanagh");
        director = " Greg Berlanti";
        numSeasons = 3;
        url = "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3NTgwNTA4NF5BMl5BanBnXkFtZTgwMDQ0MDUxMDI@._V1_UY268_CR16,0,182,268_AL_.jpg";

        tvShow = new TVShow(
                title,
                description,
                tags,
                releaseDate,
                cast,
                director,
                numSeasons,
                url
        );
    }

    @Test
    public void testGetName(){
        assertThat(tvShow.getName(), equalTo(title));
    }

    @Test
    public void testGetDescription(){
        assertThat(tvShow.getDescription(), equalTo(description));
    }

    @Test
    public void testNumTags(){
        assertThat(tvShow.getNumTags(), equalTo(tags.size()));
    }

    @Test
    public void testGetReleaseDate(){
        assertThat(tvShow.getReleaseDate(), equalTo(releaseDate));
    }

    @Test
    public void testGetURL(){
        assertThat(tvShow.getUrl(), equalTo(url));
    }

    @Test
    public void testCastExists(){
        assertThat(tvShow.getActors(), equalTo(cast));
    }

    @Test
    public void testGetDirector(){
        assertThat(tvShow.getDirector(), equalTo(director));
    }

    @Test
    public void testGetNumSeasons(){
        assertThat(tvShow.getNumSeasons(), equalTo(numSeasons));
    }

}
