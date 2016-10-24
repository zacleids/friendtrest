package com.friendtrest.database;

import com.friendtrest.data.Book;
import com.friendtrest.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Austin on 10/23/2016.
 */
public class CreateDemo {

    public static void main(String[] args) {
        System.out.println("here");
        DBController dbc = new DBController();

        List<String> tags = new ArrayList<String>();
        tags.add("French");
        tags.add("Existentialism");
        tags.add("classic");
        Item book_example = new Book(
                "L'Etranger",
                "L'Etranger has the force and fascination of myth. The outwardly simple narrative of an office clerk " +
                        "who kills an Arab, 'a cause du soleil', and finds himself condemned to death for moral " +
                        "insensibility becomes, in Camus's hands, a powerful image of modern man's impatience before " +
                        "Christian philosophy and conventional social and sexual values.",
                tags,
                "1942",
                "9782070306022",
                "Albert Camus"
        );

        System.out.println(book_example.getUUID());
        Create.createRow(dbc, book_example);
        Item book_load = Load.loadItem(dbc, book_example.getUUID());
        if (book_load == null) {
            System.out.println("NULL");
            System.exit(1);
        }
        System.out.println(book_load.getName());
        System.out.println(book_load.getDescription());
    }
}
