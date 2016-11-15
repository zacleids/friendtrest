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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Cody Patterson 11/7/16.
 */
public class FacebookLoginIT {

    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        //driver.get("http://sample-env.mxm64u72tc.us-west-1.elasticbeanstalk.com/login.html");
        driver.get("https://cst438-code-e.c9users.io/friendtrest/src/main/webapp/login.html");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFacebookLoginButton() {
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.tagName("fb:login-button")));

        // click facebook login button
        driver.findElement(By.tagName("fb:login-button")).click();

        // Await Facebook login pop up window
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to Facebook login pop up window
        String home = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("Facebook")) break;
        }
        // Title should be Facebook, url should be a Facebook url
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        String email = "";
        String password = "";

        try {
            if (new File("./fblogin.ini").exists()) {
                Properties prop = new Properties();

                prop.load(new FileInputStream("./fblogin.ini"));
                email = prop.getProperty("email");
                password = prop.getProperty("password");
            } else {
                email = System.getenv("FBLOGIN_TEST_EMAIL");
                password = System.getenv("FBLOGIN_TEST_PASSWORD");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys(email);
        element = driver.findElement(By.name("pass"));
        element.sendKeys(password);
        element.submit();

        driver.switchTo().window(home);

        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.tagName("nav")));

        // check if the username at the top is what it should be
        String url = driver.getCurrentUrl();
        assertThat(url, equalTo("https://cst438-code-e.c9users.io/friendtrest/src/main/webapp/index.html"));
    }

    @Test
    public void testFacebookAPIPull() {
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.tagName("fb:login-button")));

        // click facebook login button
        driver.findElement(By.tagName("fb:login-button")).click();

        // Await Facebook login pop up window
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.numberOfWindowsToBe(2));

        // Switch to Facebook login pop up window
        String home = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("Facebook")) break;
        }
        // Title should be Facebook, url should be a Facebook url
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        String email = "";
        String password = "";

        try {
            if (new File("./fblogin.ini").exists()) {
                Properties prop = new Properties();

                prop.load(new FileInputStream("./fblogin.ini"));
                email = prop.getProperty("email");
                password = prop.getProperty("password");
            } else {
                email = System.getenv("FBLOGIN_TEST_EMAIL");
                password = System.getenv("FBLOGIN_TEST_PASSWORD");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        WebElement element = driver.findElement(By.name("email"));
        element.sendKeys(email);
        element = driver.findElement(By.name("pass"));
        element.sendKeys(password);
        element.submit();

        // WebElement element2 = driver.findElement(By.name("__CONFIRM__"));
        // element2.click();

        driver.switchTo().window(home);

        // now that we're logged in and on index page...
        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("index-account-dropdown")));

        // click the account dropdown menu
        driver.findElement(By.id("index-account-dropdown")).click();

        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.presenceOfElementLocated(
                By.id("index-edit-account")));

        // click "Manage Account" from the dropdown menu
        driver.findElement(By.id("index-edit-account")).click();



        WebElement element3 = driver.findElement(By.id("input-email"));

        (new WebDriverWait(driver, 10)).until(
            ExpectedConditions.attributeContains(element3, "value", "facebook-login_isrxotf_tester@tfbnw.net"));

        //check to see the email field is the email it should be
        assertThat(driver.findElement(By.id("input-email")).getAttribute("value"), equalTo("facebook-login_isrxotf_tester@tfbnw.net"));
    }
}
