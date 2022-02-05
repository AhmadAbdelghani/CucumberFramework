package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class AmazonHomePage {

	
	public AmazonHomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continueButton;
	
	@FindBy(id = "ap_email")
	public WebElement emailTextField;
	
	@FindBy(xpath = "//span[contains(text(), 'We ca')]")
	public WebElement errorMessage;
	
}
