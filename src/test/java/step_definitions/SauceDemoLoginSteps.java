package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoLoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class SauceDemoLoginSteps {
	BrowserUtils util = new BrowserUtils();
	SauceDemoLoginPage page = new SauceDemoLoginPage();

	// Vailid Test #Start
	@Given("I am on the sauceDemo login page")
	public void i_am_on_the_sauce_demo_login_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("sauceURL"));
	}

	@When("I enter valid user name {string} and valid password {string}")
	public void i_enter_valid_user_name_and_valid_password(String username, String password) {
		page.username.sendKeys(username);
		page.password.sendKeys(password);
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		page.loginButton.click();
	}

	@Then("i should be directed to inventory page")
	public void i_should_be_directed_to_inventory_page() {
		Assert.assertTrue(page.inventoryPageProducttext.isDisplayed());
	}

	@Then("There should be {int} items in the page")
	public void there_should_be_items_in_the_page(Integer expectedItemNum) {
       Assert.assertTrue(expectedItemNum == page.inventoryItem.size());
       Assert.assertSame(expectedItemNum, page.inventoryItem.size());
       
       
	}
	// valid test ends
	
	
	//Invalid test Starts
	@When("I enter invalid user name {string} and valid password {string}")
	public void i_enter_invalid_user_name_and_valid_password(String username, String password) {
		page.username.sendKeys(username);
		page.password.sendKeys(password);
	}
	
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
	   Assert.assertTrue(page.username.isDisplayed());
	   
	   
	  
	   
	}
	
	@Then("Error message should display {string}")
	public void error_message_should_display(String errorMessage) {
	    Assert.assertEquals( page.errorText.getText().trim(), errorMessage);
	}
	//Ivnalid test Ends

}
