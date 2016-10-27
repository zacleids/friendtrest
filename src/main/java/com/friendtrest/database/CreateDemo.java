package com.friendtrest.database;

import com.friendtrest.data.Album;
import com.friendtrest.data.Book;
import com.friendtrest.data.Item;
import com.friendtrest.data.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Austin on 10/23/2016.
 */
public class CreateDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();

        List<String> tags = new ArrayList<String>();
        tags.add("Jazz");
        tags.add("Cool");

        Item book_example = new Book(
                "Ender's Game",
                "In order to develop a secure defense against a hostile alien race's next attack, government agencies " +
                        "breed child geniuses and train them as soldiers. A brilliant young boy, Andrew \"Ender\" " +
                        "Wiggin lives with his kind but distant parents, his sadistic brother Peter, and the person he " +
                        "loves more than anyone else, his sister Valentine. Peter and Valentine were candidates for the " +
                        "soldier-training program but didn't make the cut--young Ender is the Wiggin drafted to the " +
                        "orbiting Battle School for rigorous military training.",
                tags,
                "1985",
                "9780812550702",
                "Orson Scott Card",
                "https://images-na.ssl-images-amazon.com/images/I/51L10EnuJbL._SX295_BO1,204,203,200_.jpg"
        );

        List<String> songs = new ArrayList<String>();
        Item album_example = new Album(
            "Time Out",
            "Boasting the first jazz instrumental to sell a million copies, the Paul Desmond-penned \"Take Five,\" " +
                    "Time Out captures the celebrated jazz quartet at the height of both its popularity and its " +
                    "powers. Recorded in 1959, the album combines superb performances by pianist Brubeck, alto " +
                    "saxophonist Desmond, drummer Joe Morrello and bassist Gene Wright. Along with \"Take Five,\" " +
                    "the album features another one of the group's signature compositions, \"Blue Rondo a la Turk.\" " +
                    "Though influenced by the West Coast-cool school, Brubeck's greatest interest and contribution to " +
                    "jazz was the use of irregular meters in composition, which he did with great flair. Much of the " +
                    "band's appeal is due to Desmond, whose airy tone and fluid attack often carried the band's already " +
                    "strong performances to another level. Together, he and Brubeck proved one of the most potent " +
                    "pairings of the era. ",
            tags,
            "1959",
            "The Dave Brubeck Quartet",
            songs,
            "https://upload.wikimedia.org/wikipedia/en/e/e5/Time_out_album_cover.jpg"
        );

        Item example = album_example;
        System.out.println(example.getUUID());
        Create.createRow(dbc, example);
        Item load = Load.loadItem(dbc, example.getUUID());
        if (load == null) {
            System.out.println("NULL");
            System.exit(1);
        }
        System.out.println(load.getName());
        System.out.println(load.getDescription());
    }
}
