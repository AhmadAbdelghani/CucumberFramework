package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQADatePickerPage {

	BrowserUtils utils = new BrowserUtils();

	public DemoQADatePickerPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "datePickerMonthYearInput")
	public WebElement firstDatePicker;

	@FindBy(xpath = "//select[@class='react-datepicker__year-select']")
	public WebElement yearDropDown;

	@FindBy(xpath = "//select[@class='react-datepicker__month-select']")
	public WebElement monthDropDown;

	@FindBy(css = ".react-datepicker__day")
	public List<WebElement> days;

	public void pickAdate(String date) {

		String[] dates = date.split("/");
		String year = dates[2];
		int month = Integer.parseInt(dates[0]);
		month = month - 1;
		int day = Integer.parseInt(dates[1]);

		utils.selectByVisibleText(yearDropDown, year);
		utils.selectByIndex(monthDropDown, month);

		for (WebElement elm : days) {
			if (elm.getText().equals(day + "")) {
				elm.click();
				break;
			}
		}
	}

}
