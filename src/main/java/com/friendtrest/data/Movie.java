package com.friendtrest.data;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zac Leids.
 */
public class Movie extends OnScreenMedia {

    private int runTimeInMinutes;

    private String MPAARating;

    public Movie(String name, String description, ArrayList<String> tags, String releaseDate, ArrayList<String> actors, String director, String MPAARating, int runTimeInMinutes, String url){
        super(url);
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setActors(actors);
        this.setDirector(director);
        this.MPAARating = MPAARating;
        this.runTimeInMinutes = runTimeInMinutes;
    }

    public Movie(OMDbObject movie){
        super(movie.Poster);
        this.setName(movie.Title);
        this.setDescription(movie.Plot);
        this.setTags(Arrays.asList(movie.Genre.split(",")));
        this.setReleaseDate(movie.Year);
        this.setActors(new ArrayList<String>(Arrays.asList(movie.Actors.split(","))));
        this.setDirector(movie.Director);
        this.MPAARating = movie.Rated;
        this.runTimeInMinutes = Integer.parseInt(movie.Runtime.split(" ")[0]);
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
