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
public class SaveDemo {

    public static void main(String[] args) {
        DBController dbc = new DBController();

        List<String> tags = new ArrayList<String>();
        tags.add("Action");
        tags.add("Fighting");
        tags.add("Romance");
        tags.add("Hunger Games");

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
        /*
        In the ruins of a place once known as North America lies the nation of Panem,
        a shining Capitol surrounded by twelve outlying districts. Long ago the districts
        waged war on the Capitol and were defeated. As part of the surrender terms, each district
        agreed to send one boy and one girl to appear in an annual televised event called, \"The Hunger Games,\"
        a fight to the death on live TV. Sixteen-year-old Katniss Everdeen, who lives alone with her mother and
        younger sister, regards it as a death sentence when she is forced to represent her district in the Games.
        The terrain, rules, and level of audience participation may change but one thing is constant: kill or be killed
         */

        Item book_hunger_games = new Book(
                "The Hunger Games",
                "In the ruins of a place once known as North America lies the nation of Panem, " +
                        "a shining Capitol surrounded by twelve outlying districts. Long ago the districts " +
                        "waged war on the Capitol and were defeated. As part of the surrender terms, each district " +
                        "agreed to send one boy and one girl to appear in an annual televised event called, \"The Hunger Games,\" " +
                        "a fight to the death on live TV. Sixteen-year-old Katniss Everdeen, who lives alone with her mother and " +
                        "younger sister, regards it as a death sentence when she is forced to represent her district in the Games. " +
                        "The terrain, rules, and level of audience participation may change but one thing is constant: kill or be killed.",
                tags,
                "2008",
                "9780439023528",
                "Suzanne Collins",
                "https://pictures.abebooks.com/isbn/9780439023528-us.jpg"
        );
        ArrayList<String> cast = new ArrayList<String>();
        ArrayList<String> t = new ArrayList<String>();
        t.add("Action");
        t.add("Fighting");
        t.add("Romance");
        t.add("Hunger Games");
        cast.add("Jennifer Lawrence");
        cast.add("Liam Hemsworth");
        cast.add("Willow Shields");
        cast.add("Josh Hutcherson");
        Item movie_hunger_games = new Movie(
                "The Hunger Games",
                "In the ruins of a place once known as North America lies the nation of Panem, " +
                        "a shining Capitol surrounded by twelve outlying districts. Long ago the districts " +
                        "waged war on the Capitol and were defeated. As part of the surrender terms, each district " +
                        "agreed to send one boy and one girl to appear in an annual televised event called, \"The Hunger Games,\" " +
                        "a fight to the death on live TV. Sixteen-year-old Katniss Everdeen, who lives alone with her mother and " +
                        "younger sister, regards it as a death sentence when she is forced to represent her district in the Games. " +
                        "The terrain, rules, and level of audience participation may change but one thing is constant: kill or be killed.",
                t,
                "2012",
                cast,
                "Francis Lawrence ",
                "PG-13",
                142,
                "https://pictures.abebooks.com/isbn/9780439023528-us.jpg"
        );

        Item example = movie_hunger_games;
        System.out.println(example.getUUID());
        Save.saveItem(example, dbc);
        Item load = (Item)Load.loadItem(example.getUUID(), dbc);
        if (load == null) {
            System.out.println("NULL");
            System.exit(1);
        }
        System.out.println(load.getName());
        System.out.println(load.getDescription());
        Movie m = (Movie)load;
        System.out.println(m.getRunTimeInMinutes());
        System.out.println(m.getMPAARating());
        //Book b = (Book)load;
        //System.out.println(b.getISBN());
    }
}
