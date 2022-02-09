package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class SauceDemoLoginPage {

	public SauceDemoLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	
	@FindBy(id="user-name")
	public WebElement username;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="login-button")
	public WebElement loginButton;
	
	@FindBy(css=".title")
	public WebElement inventoryPageProducttext;
	
	@FindBy(css=".inventory_item")
	public List<WebElement> inventoryItem;
	
	
	@FindBy(tagName = "h3")
	public WebElement errorText;
	
}
