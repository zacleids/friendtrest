package com.friendtrest;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Zac Leids on 10/5/2016.
 */
public class Book extends Item{
    private String isbn;
    private String author;

    public Book(String name, String description, ArrayList<String> tags, Date releaseDate, String isbn, String author){
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.setIsbn(isbn);
        this.setAuthor(author);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
