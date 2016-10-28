package com.friendtrest.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.friendtrest.data.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zac Leids on 10/5/2016.
 */
public class Album extends Item {

    private String artist;
    private List<String> songs;

    public Album(String name, String description, List<String> tags, String releaseDate, String artist, List<String> songs, String url){
        super(url);
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.artist = artist;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<String> getSongs() {
        return songs;
    }
    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    @DynamoDBIgnore
    public int getNumSongs(){
        return songs.size();
    }
}
