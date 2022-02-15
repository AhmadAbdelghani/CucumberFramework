package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTrades {
	
	TradeAppTradesPage lp = new TradeAppTradesPage();
	BrowserUtils utils = new BrowserUtils();
	String stockSymbol;
	String stockEntryPrice;
	

	@Given("I am on the Trade app login page")
	public void i_am_on_the_trade_app_login_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("TradeAppURL"));
	}
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
	   lp.userNameBox.sendKeys(username);
	   lp.passwordBox.sendKeys(password);
	}
	@When("I click on sign in button")
	public void i_click_on_sign_in_button() {
	    lp.signInBtn.click();
	}
	
	
	@Then("I should be Trade Home Page")
	public void i_should_be_trade_home_page() {
	    Assert.assertTrue(lp.addTradeBtn.isDisplayed());
	}
	@When("I click on add trade button")
	public void i_click_on_add_trade_button() {
	    lp.addTradeBtn.click();
	}
	@Then("I should be on add trade page")
	public void i_should_be_on_add_trade_page() {
	    Assert.assertTrue(lp.pageHeading.isDisplayed());
	}
	@When("I select {string} and I enter symbol {string} entrydate {string} entryprice {string} exitdate {string} exitprice {string}")
	public void i_select_and_i_enter_symbol_entrydate_entryprice_exitdate_exitprice(String buyToOpen, String symbol, String entryDate, String entryPrice, String exitdate, String exitPrice) {

		stockSymbol=symbol;
		stockEntryPrice=entryPrice;
		utils.selectByVisibleText(lp.dropDownOptions, buyToOpen);
		lp.symbolField.sendKeys(symbol);
		lp.openDate.sendKeys(entryDate);
        lp.entryPriceField.sendKeys(entryPrice);
        lp.closeDate.sendKeys(exitdate);
        lp.exitPriceField.sendKeys(exitPrice);
	}
	@When("I click save button")
	public void i_click_save_button() {
	    lp.saveBtn.click();
	}
	@Then("THE Trade is displayed on the Trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
	    Assert.assertTrue(lp.addTradeBtn.isDisplayed());
	    
	    for (WebElement symbol: lp.stockSymbols) {
	    	if (symbol.getText().equals(stockSymbol)) {
	    		Assert.assertEquals(symbol.getText(), stockSymbol);
	    	}
	    }
	    
	}
}
