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
 * Created by austinzielinski on 10/7/16.
 */
public class HomeSearchIT {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/index.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testGetQuery() {
        assertTrue(true);
    }
}
