package step_definitions;

import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQADatePickerPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQADatePickerSteps {

	DemoQADatePickerPage datePickerPage = new DemoQADatePickerPage();
	BrowserUtils utils = new BrowserUtils();

	
	@Given("I am on the date picker page {string}")
	public void i_am_on_the_date_picker_page(String url) {
		Driver.getDriver().get(url);
		Assert.assertTrue(datePickerPage.firstDatePicker.isDisplayed());
	    
	}
	
	@When("I enter {string} to date picker")
	public void i_enter_to_date_picker(String date) throws InterruptedException {
		
		utils.clearValueOnTheField(datePickerPage.firstDatePicker);
		//datePickerPage.firstDatePicker.sendKeys(date);
		datePickerPage.firstDatePicker.click();
		datePickerPage.pickAdate(date);
		
	}
	
	

	@Then("Date entered should be selected")
	public void date_entered_should_be_selected() {
	   System.out.println(datePickerPage.firstDatePicker.getAttribute("value")); 
	}
}
