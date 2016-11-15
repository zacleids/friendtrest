package com.friendtrest.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Zac Leids on 10/4/2016.
 */
public class TVShow extends OnScreenMedia {

    private int numSeasons;

    public TVShow() { }

    public TVShow(String name, String description, ArrayList<String> tags, String releaseDate, ArrayList<String> actors, String director, int numSeasons, String url){
        super(url);
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setActors(actors);
        this.setDirector(director);
        this.setNumSeasons(numSeasons);
    }

    public TVShow(OMDbObject show){
        super(show.Poster);
        this.setName(show.Title);
        this.setDescription(show.Plot);
        this.setTags(Arrays.asList(show.Genre.split(",")));
        this.setReleaseDate(show.Year.substring(0,4));
        this.setActors(new ArrayList<String>(Arrays.asList(show.Actors.split(","))));
        this.setDirector(show.Director);
        this.setNumSeasons(show.totalSeasons);
    }

    public int getNumSeasons() {
        return numSeasons;
    }
    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }
}
