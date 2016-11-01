package com.friendtrest.integration;

import com.friendtrest.data.Review;
import com.friendtrest.database.DBController;
import com.friendtrest.database.Load;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by Austin on 11/8/2016.
 */
public class ReviewIT {

    WebDriver driver = new ChromeDriver();
    DBController dbc = new DBController();

    @Before
    public void setUp() { driver.get("http://localhost:8080/rating.html"); }

    @After
    public void tearDown() { driver.quit(); }

    @Test
    public void testUpdateOnToggle() {
        WebElement popup = driver.findElement(By.className("popup"));
        popup.click();
        WebElement review = driver.findElement(By.className("review"));
        String review_text = review.getAttribute("value");
        review.clear();
        String new_text = "";
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            new_text += " " + rand.nextDouble();
        }

        assertFalse(review_text.equals(new_text));
        review.sendKeys(new_text);
        WebElement toggle = driver.findElement(By.className("toggle"));
        toggle.click();
        Review reviewObj = Load.loadReview("8227c1f7-e52c-4dec-ab1d-e9d2bd9c44c6", dbc);

        assertEquals(reviewObj.getReview_text(), new_text);
    }
}
