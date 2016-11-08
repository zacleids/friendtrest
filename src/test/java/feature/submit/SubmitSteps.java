package feature.submit;

import org.glassfish.jersey.test.JerseyTest;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Austin on 9/28/2016.
 */
public class SubmitSteps {
	/*
	WebDriver driver = new ChromeDriver();
	
	@Before
	public void setUp() {
		driver.get("http://localhost:8080/rating.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@When("^I start with the content of (\\w+)$")
	public void i_start_with_the_content_of(String content) throws Throwable {
		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor)driver).executeScript("content = '" + content + "'");
		}
		
		WebElement rate_button = driver.findElement(By.id("rate_button"));
		rate_button.click();
		
		WebElement element = driver.findElement(By.id("review"));
		element.sendKeys(" more content");
		
		rate_button.click();
	}
	
	@Then("^the content after should be (\\w+)$")
	public void the_content_after_should_be(String content) throws Throwable {
		WebElement element = driver.findElement(By.id("review"));
		assertEquals(content, (String)((JavascriptExecutor)driver).executeScript("return content;"));
	}
	*/
}
