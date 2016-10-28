package com.friendtrest.data;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.friendtrest.data.Item;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Zac Leids on 10/5/2016.
 */
public class Book extends Item {

    private String isbn;
    private String author;

    public Book(String name, String description, List<String> tags, String releaseDate, String isbn, String author, String url){
        super(url);
        this.setName(name);
        this.setDescription(description);
        this.setTags(tags);
        this.setReleaseDate(releaseDate);
        this.isbn = isbn;
        this.author = author;
    }

    @DynamoDBAttribute(attributeName = "isbn")
    public String getISBN() {
        return isbn;
    }
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
}
