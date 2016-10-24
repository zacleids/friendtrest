package com.friendtrest.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Leids on 10/4/2016.
 */
public class Movie extends OnScreenMedia {

    private String MPAARating;
    private int runTimeInMinutes;

    public Movie(String name, String description, ArrayList<String> tags, String releaseDate, ArrayList<String> actors, String director, String MPAARating, int runTimeInMinutes){
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setActors(actors);
        this.setDirector(director);
        this.setMPAARating(MPAARating);
        this.setRunTimeInMinutes(runTimeInMinutes);
    }

    public String getMPAARating() {
        return MPAARating;
    }
    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public int getRunTimeInMinutes() { return runTimeInMinutes; }
    public void setRunTimeInMinutes(int runTimeInMinutes) {
        this.runTimeInMinutes = runTimeInMinutes;
    }
}
