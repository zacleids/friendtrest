package com.friendtrest.webclient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * User story:
 *
 *   As a user I want to be able to search for movies
 */
public class Leids_MovieSearchIT {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/Leids_MovieSearch.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }


    /**
     * Acceptance test:
     *  Given the name text box
     *  When i enter "deadpool"
     *  Then I see the movie and year "Deadpool Released 2016"
     */
    @Test
    public void testFindMovieByName() {
        driver.findElement(By.id("name")).sendKeys("deadpool");
        driver.findElement(By.id("submit")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("movie"), "Deadpool Released 2016"));

        // Success
    }
}
