package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonSearchPage;

public class AmazonSearchSteps {
	
	AmazonSearchPage searchPage = new AmazonSearchPage();
	
	// Amazon search Starts
	@When("I search item {string}")
	public void i_search_item(String item) {
	    searchPage.searchBox.sendKeys(item);
	}
	@When("I click search button")
	public void i_click_search_button() {
	    searchPage.searchBtn.click();
	}
	@Then("search item {string} should be displayed in the search bar")
	public void search_item_should_be_displayed_in_the_search_bar(String item) {
	String trimmedText =  searchPage.searchedItemText.getText().replace('"', ' ').trim();
	  Assert.assertEquals(trimmedText, item);
	}
	//Amazon Search Ends

}
