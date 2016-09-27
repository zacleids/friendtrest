package com.friendtrest.webclient;

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
 * User story:
 *
 *   As a user I want to be able to login
 *
 */
public class PattersonLoginIT {
    // create webdriver
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/login.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Acceptance test:
     *
     *   Given a username and password textbox
     *   When I enter "BadUser" and "BadPassWord" and click login
     *   Then I see the error message "Bad username/password."
     */
    @Test
    public void testInvalidLogin() {
        driver.findElement(By.id("username")).sendKeys("BadUser");
        driver.findElement(By.id("password")).sendKeys("BadPassWord");
        driver.findElement(By.id("login")).click();

        // timeout after 10 seconds
        (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.textToBe(By.id("greeting"), "Bad username/password."));

    }
}
