package com.friendtrest.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Leids on 10/5/2016.
 */
public class Song extends Item {

    private String artist;
    private int min;
    private int seconds;

    public Song(String name, String description, ArrayList<String> tags, String releaseDate, String artist, int min, int seconds, String url){
        super(url);
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setArtist(artist);
        this.setMin(min);
        this.setSeconds(seconds);
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }

    public int getSeconds() { return seconds; }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
