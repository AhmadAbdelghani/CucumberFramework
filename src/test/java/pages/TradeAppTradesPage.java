package pages;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import utilities.Driver;

public class TradeAppTradesPage {
   
	public TradeAppTradesPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (id = "username")
	public WebElement userNameBox;
	
	@FindBy (id = "password")
	public WebElement passwordBox;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement signInBtn;
	
	@FindBy (tagName = "h2")
	public WebElement pageHeader;

	@FindBy (xpath = "//div[text()='Bad credentials']")
	public WebElement badCredentialText;
	
	@FindBy (linkText  = "Add trade")
	public  WebElement addTradeBtn;
	
	
	@FindBy (xpath = "//p[@class='h4 mb-4']")
	public WebElement pageHeading;
	
	
	@FindBy (id = "longTrade")
	public WebElement dropDownOptions;
	
	@FindBy (xpath = "//div/input[@name='symbol']")
	public WebElement symbolField;
	
	@FindBy (xpath = "//input[@name='openDate']")
	public WebElement openDate;
	
	@FindBy (css  = "input[name='entry']")
	public WebElement entryPriceField;
	
	@FindBy (css = "input[name='closeDate']")
	public WebElement closeDate;
	
	@FindBy (css  = "input[name='exit']")
	public WebElement exitPriceField;
	
	@FindBy (xpath  = "(//button[@type='submit'])[3]")
	public WebElement saveBtn;
	
	@FindBy (linkText = "Back to Transactions")
	public WebElement backToTransactionsBtn;
	
	@FindBy(xpath  = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
	public List<WebElement> stockSymbols;
	
	@FindBy(xpath  = "//table[@class='table table-bordered table-striped']/tbody/tr/td[4]")
	public List<WebElement> stockEntryPrices;
	
	@FindBy (xpath = "//input[@name='symbol']")
	public  WebElement symbolBox;
	
	@FindBy (xpath = "(//button[@type='submit'])[1]")
	public  WebElement searchBtn;
	
	
	
	
}
