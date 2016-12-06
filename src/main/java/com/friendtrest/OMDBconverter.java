package com.friendtrest;

import com.friendtrest.data.Item;
import com.friendtrest.data.Movie;
import com.friendtrest.data.OMDbObject;
import com.friendtrest.data.TVShow;
import com.friendtrest.database.DBController;
import com.friendtrest.database.Save;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.io.InputStreamReader;

/**
 * Created by Zac Leids.
 */
public class OMDBconverter {
    private static final DBController dbc = new DBController();

    public Item search(String title, String year, boolean save) throws IOException {
        if (title == null) title = "";
        if (year == null) year = "";
        URL url = new URL("http://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&y=" + year + "&plot=full&r=json");
        InputStreamReader reader = new InputStreamReader(url.openStream());
        OMDbObject omdbObject = new Gson().fromJson(reader, OMDbObject.class);
        if(!omdbObject.Response){
            return null;
        }
        Item i;
        if(omdbObject.Type.equals("series")){
            i = new TVShow(omdbObject);
        } else {
            i = new Movie(omdbObject);
        }
        if(save){
            Save.saveObject(i, dbc);
        }

        System.out.println("Item from OMDb api:" + i.getName());
        return i;
    }

}
