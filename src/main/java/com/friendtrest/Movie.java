package com.friendtrest;

import java.util.ArrayList;

public class Movie {
    private String name;
    private int releaseYear;
    private String MPAARating;
    private ArrayList<String> cast = new ArrayList<String>();
    private ArrayList<String> tags = new ArrayList<String>();

    public Movie(String name, int releaseYear, String MPAARating, ArrayList<String> cast, ArrayList<String> tags){
        this.name = name;
        this.releaseYear = releaseYear;
        this.MPAARating = MPAARating;
        this.cast = cast;
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
