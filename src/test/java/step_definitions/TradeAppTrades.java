package step_definitions;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.openqa.selenium.WebElement;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTrades {
	
	TradeAppTradesPage tardeAppPage = new TradeAppTradesPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbUtil = new DButils();
	List<String> addDataTable;
	String stockSymbol;
	String stockEntryPrice;
	
	// Test add trade #ENDS 
	@Given("I am on the Trade app login page")
	public void i_am_on_the_trade_app_login_page() {
	    Driver.getDriver().get(PropertiesReader.getProperty("TradeAppURL"));
	}
	@When("I enter username {string} and password {string}")
	public void i_enter_username_and_password(String username, String password) {
	   tardeAppPage.userNameBox.sendKeys(username);
	   tardeAppPage.passwordBox.sendKeys(password);
	}
	@When("I click on sign in button")
	public void i_click_on_sign_in_button() {
	    tardeAppPage.signInBtn.click();
	}
	
	
	@Then("I should be Trade Home Page")
	public void i_should_be_trade_home_page() {
	    Assert.assertTrue(tardeAppPage.addTradeBtn.isDisplayed());
	}
	@When("I click on add trade button")
	public void i_click_on_add_trade_button() {
	    tardeAppPage.addTradeBtn.click();
	}
	@Then("I should be on add trade page")
	public void i_should_be_on_add_trade_page() {
	    Assert.assertTrue(tardeAppPage.pageHeading.isDisplayed());
	}
	@When("I select {string} and I enter symbol {string} entrydate {string} entryprice {string} exitdate {string} exitprice {string}")
	public void i_select_and_i_enter_symbol_entrydate_entryprice_exitdate_exitprice(String buyToOpen, String symbol, String entryDate, String entryPrice, String exitdate, String exitPrice) {

		stockSymbol=symbol;
		stockEntryPrice=entryPrice;
		utils.selectByVisibleText(tardeAppPage.dropDownOptions, buyToOpen);
		tardeAppPage.symbolField.sendKeys(symbol);
		tardeAppPage.openDate.sendKeys(entryDate);
        tardeAppPage.entryPriceField.sendKeys(entryPrice);
        tardeAppPage.closeDate.sendKeys(exitdate);
        tardeAppPage.exitPriceField.sendKeys(exitPrice);
	}
	@When("I click save button")
	public void i_click_save_button() {
	    tardeAppPage.saveBtn.click();
	}
	@Then("THE Trade is displayed on the Trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
	    Assert.assertTrue(tardeAppPage.addTradeBtn.isDisplayed());
	    
	    for (WebElement symbol: tardeAppPage.stockSymbols) {
	    	if (symbol.getText().equals(stockSymbol)) {
	    		Assert.assertEquals(symbol.getText(), stockSymbol);
	    	}
	    }
	    
	}
	
	@Then("The trade data is deleted on the Database")
	public void the_trade_data_is_deleted_on_the_database() {
	    String sqlQuery = "delete from records where +symbol"+"'"+stockSymbol+"'";
	    dbUtil.deleteRecord(sqlQuery);
	}
	// Test add trade #ENDS 
	
	
	
	
	
	//Test insert database scenarion #STARTS
	@When("I enter the fowllwing Data")
	public void i_enter_the_fowllwing_data(DataTable dataTable) {
	    addDataTable = dataTable.transpose().asList();
	   
	   stockSymbol=addDataTable.get(1); // wants to do validation on this value
		stockEntryPrice=addDataTable.get(3); // wants to do validation on this value
		
		utils.selectByVisibleText(tardeAppPage.dropDownOptions, addDataTable.get(0));
		tardeAppPage.symbolField.sendKeys(addDataTable.get(1));
		tardeAppPage.openDate.sendKeys(addDataTable.get(2));
       tardeAppPage.entryPriceField.sendKeys(addDataTable.get(3));
       tardeAppPage.closeDate.sendKeys(addDataTable.get(4));
       tardeAppPage.exitPriceField.sendKeys(addDataTable.get(5));
	}
	
	@Then("the trade data resides in database correctly")
	public void the_trade_data_resides_in_database_correctly() {
	    
		String buyOrsell = addDataTable.get(0);
		String symbol = addDataTable.get(1);
		String enteryPrice = addDataTable.get(3);
		String exitPrice = addDataTable.get(5);
	    String selectQuery = "SELECT long_short, symbol, entry_price, exit_price "
				+ "FROM records WHERE symbol="+"'"+stockSymbol+"'";
		
		List<String> dataFromDB = dbUtil.selectARecord(selectQuery);
		
		String buyOrSelldb = dataFromDB.get(0);
		String symboldb =  dataFromDB.get(1);
		String enteryPricedb = dataFromDB.get(2);
		String exitPricedb = dataFromDB.get(3);
		
		Assert.assertTrue(buyOrSelldb.equals("1"));
		Assert.assertEquals(symboldb, symbol);
		Assert.assertEquals(enteryPricedb, enteryPrice);
		Assert.assertEquals(exitPricedb, exitPrice);
		
		
		
		
		}
	    //Test insert database scenarion #ENDS
	
	
	
	
	
	
	
	@Given("I executed Insert query with the following data to Database")
	public void i_executed_insert_query_with_the_following_data_to_database(io.cucumber.datatable.DataTable dataTable) {
		
		addDataTable = dataTable.transpose().asList();
		
		stockSymbol = addDataTable.get(3);
		
		String id =  addDataTable.get(0);
		String user_id = addDataTable.get(1);
		String longOrShort = addDataTable.get(2);
		String symbol = addDataTable.get(3);
		String openDate = addDataTable.get(4);
		String entryPrice = addDataTable.get(5);
		String closeDate = addDataTable.get(6);
		String exitPrice = addDataTable.get(7);
		String gain = addDataTable.get(8);
		
		
		String insertQuery = "INSERT INTO records VALUES("+id+", "+user_id+", "+longOrShort+", "+symbol+","
				+ " "+openDate+", "+entryPrice+", "+closeDate+", "+exitPrice+", "+gain+")";
		
		dbUtil.insertRecord(insertQuery);
		
	}
	
	@When("I search the {string} on")
	public void i_search_the_on(String tradeSymbol) {
		
		tardeAppPage.symbolBox.sendKeys(tradeSymbol);
	   
	}
	
	@When("I click  search button")
	public void i_click_search_button() {
	    tardeAppPage.searchBtn.click();
	}
	
	@Then("THE Trade input is displayed on the Trade table")
	public void the_trade_input_is_displayed_on_the_trade_table() {
	    Assert.assertTrue(tardeAppPage.addTradeBtn.isDisplayed());
	    Assert.assertEquals(stockSymbol.replace("'", " ").trim(), tardeAppPage.stockSymbols.get(0).getText().trim());
	    
	}
	
	
	
	
}
