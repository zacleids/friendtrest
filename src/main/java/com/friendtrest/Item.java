package com.friendtrest;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Leids on 10/4/2016.
 */
public abstract class Item {
    private String name;
    private String description;
    private ArrayList<String> tags;
    private Date releaseDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void addTag(String tag){
        tags.add(tag);
    }

    public void removeTag(String tag){
        tags.remove(tag);
    }

    public int getNumTags(){
        return tags.size();
    }

}
