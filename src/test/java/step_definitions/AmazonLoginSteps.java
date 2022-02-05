package step_definitions;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AmazonHomePage;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonLoginSteps {

	AmazonHomePage lp = new AmazonHomePage();
	
	@Given("I am on amazon home page")
	public void i_am_on_amazon_home_page() {
	   Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
	}
	@Given("The sign in button displays")
	public void the_sign_in_button_displays() {
	  
	  Assert.assertTrue(lp.loginButton.isDisplayed());
		
	}
	@When("I click on the sign in button")
	public void i_click_on_the_sign_in_button() {
		lp.loginButton.click();
	}
	
	@Then("I should be directed to login page")
	public void i_should_be_directed_to_login_page() {
	   Assert.assertTrue(lp.continueButton.isDisplayed());
	   
	}
	
	
	// invalid user test # STARTS
	@Given("I am on the loging page")
	public void i_am_on_the_loging_page() {
		Driver.getDriver().get(PropertiesReader.getProperty("amazonURL"));
		lp.loginButton.click();
		Assert.assertTrue(lp.continueButton.isDisplayed());
	}
	
	@When("I enter invalid email {string}")
	public void i_enter_invalid_email(String string) {
	    lp.emailTextField.sendKeys(string);
	}
	
	@When("I click the continue button")
	public void i_click_the_continue_button() {
	    lp.continueButton.click();
	}
	
	@Then("I should get error message says {string}")
	public void i_should_get_error_message_says(String expexted) {
		Assert.assertTrue(lp.errorMessage.isDisplayed());
	    String actualText = lp.errorMessage.getText().trim();
	    Assert.assertEquals(actualText, expexted);
	    
	}
	
	@Then("I should still in the login page")
	public void i_should_still_in_the_login_page() {
	    Assert.assertTrue(lp.emailTextField.isDisplayed());
	}
	// INVALID USER TEST ENDS
}
