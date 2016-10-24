package com.friendtrest.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Leids on 10/4/2016.
 */
public class TVShow extends OnScreenMedia {

    private int numSeasons;

    public TVShow(String name, String description, ArrayList<String> tags, String releaseDate, ArrayList<String> actors, String director, int numSeasons){
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setActors(actors);
        this.setDirector(director);
        this.setNumSeasons(numSeasons);
    }

    public int getNumSeasons() {
        return numSeasons;
    }
    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }
}
