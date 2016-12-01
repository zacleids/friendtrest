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
 * Created by Zac Leids on 11/5/2016.
 */
public class SearchIT {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/search.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    @Test
    public void testFindItemByName() {
        driver.findElement(By.id("name")).sendKeys("Hunger");
        driver.findElement(By.id("submit")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("movie"), "The Hunger Games Released: 2008"));

        // Success
    }

    @Test
    public void testNoItemFound() {
        driver.findElement(By.id("name")).sendKeys("rjdtxfythhh");
        driver.findElement(By.id("submit")).click();
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("items"), "No Items to display"));
    }


}
