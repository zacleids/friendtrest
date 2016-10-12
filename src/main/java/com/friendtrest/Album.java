package com.friendtrest;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Leids on 10/5/2016.
 */
public class Album extends Item{
    private String artist;
    private ArrayList<String> songs;

    public Album(String name, String description, ArrayList<String> tags, Date releaseDate, String artist, ArrayList<String> songs){
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setArtist(artist);
        this.setSongs(songs);
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public ArrayList<String> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<String> songs) {
        this.songs = songs;
    }

    public int getNumSongs(){
        return songs.size();
    }
}
