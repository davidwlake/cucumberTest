
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Test;


public class Stepdefs {
	public  WebDriver browser = null;
	public  WebDriverWait wait = null;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\David\\Downloads\\geckodriver.exe");
		browser = new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(browser, 10);
	}

// Background
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {
		browser.get("http://spptdemo3.cms.dealer.com/");
	}

	@When("^I click Login$")
	public void i_click_Login() throws Throwable {
		browser.findElement(By.xpath("//a[@data-role='mycars-user']")).click();
	}

	@When("^I click Sign Up$")
	public void i_click_Sign_Up() throws Throwable {
		browser.findElement(By.xpath("//a[@href='#create']")).click();

	}

	@Then("^I should see an registration page$")
	public void i_should_see_an_registration_page() throws Throwable {
		browser.findElement(By.name("contact.email"));
	}


	@Given("^I enter \"(.*)\" as an Email$")
	public void i_enter_a_vaild_Email_Address(String emailAddress) throws Throwable {
		browser.findElement(By.name("contact.email")).sendKeys(emailAddress);
	}

	@When("^I click Sign Up Now! button$")
	public void i_click_Sign_Up_Now_button() throws Throwable {
		browser.findElement(By.xpath("//input[@value='Sign Up Now!']")).click();
	}

	@Then("^I should see a confirmation page$")
	public void i_should_see_a_confirmation_page() throws Throwable {
	  browser.findElement(By.xpath("//div[@class='popup login-container show-confirm']"));
	}
	
	
	@After
	public void afterScenario() {
		browser.quit();
	} 
}
