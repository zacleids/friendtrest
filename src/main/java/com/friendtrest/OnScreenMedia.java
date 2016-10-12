package com.friendtrest;

import java.util.ArrayList;

/**
 * Created by Zac Leids on 10/4/2016.
 */
public class OnScreenMedia extends Item {
    private ArrayList<String> actors;
    private String director;

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
