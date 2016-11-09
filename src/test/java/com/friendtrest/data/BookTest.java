package com.friendtrest.data;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by Zac Leids on 11/7/2016.
 */
public class BookTest {
    Book b;
    String name;
    String description;
    List<String> tags = new ArrayList<String>();
    String releaseDate;
    String url;
    String isbn;
    String author;

    @Before
    public void setUp(){
        name = "The Hunger Games";
        description = "post-apocalyptic game for survival";
        tags.add("hunger games");
        tags.add("post-apocalyptic");
        releaseDate = "2008";
        url = "https://pictures.abebooks.com/isbn/9780439023528-us.jpg";
        isbn = "9780439023528";
        author = "Suzanne Collins";

        b = new Book(
                name,
                description,
                tags,
                releaseDate,
                isbn,
                author,
                url
        );
    }

    @Test
    public void testGetName(){
        assertThat(b.getName(), equalTo(name));
    }

    @Test
    public void testGetDescription(){
        assertThat(b.getDescription(), equalTo(description));
    }

    @Test
    public void testNumTags(){
        assertThat(b.getNumTags(), equalTo(tags.size()));
    }

    @Test
    public void testGetReleaseDate(){
        assertThat(b.getReleaseDate(), equalTo(releaseDate));
    }

    @Test
    public void testGetURL(){
        assertThat(b.getURL(), equalTo(url));
    }

    @Test
    public void testGetISBN(){
        assertThat(b.getISBN(), equalTo(isbn));
    }

    @Test
    public void testGetAuthor(){
        assertThat(b.getAuthor(), equalTo(author));
    }

    @Test
    public void testSetISBN(){
        String tempISBN = "-0";
        b.setISBN(tempISBN);
        assertThat(b.getISBN(), equalTo(tempISBN));
        b.setISBN(isbn);
    }

    @Test
    public void testSetAuthou(){
        String tempAuthor = "me";
        b.setAuthor(tempAuthor);
        assertThat(b.getAuthor(), equalTo(tempAuthor));
        b.setAuthor(author);
    }
}
