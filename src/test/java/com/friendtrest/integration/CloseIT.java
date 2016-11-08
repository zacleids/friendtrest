package com.friendtrest.integration;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Austin on 9/28/2016.
 */

/**
 * MADE OBSOLETE TEMPORARILY BY DESIGN CHANGES
 */
public class CloseIT {
    /*
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() { driver.get("http://localhost:8080/rating.html"); }

    @After
    public void tearDown() { driver.quit(); }
*/
    /**
     *  Acceptance Test:
     *
     *      Given I am on the rating page
     *      When I open a rating popup and press "submit" having not entered content
     *      Then the rating popup should close without updating.
     */
/*
    @Test
    public void testCloseNoContent() {
        driver.findElement(By.id("popup")).click();
        driver.findElement(By.id("save")).click();
 
        assertEquals("CLOSED", driver.findElement(By.id("result")).getText());
    }
    */
}