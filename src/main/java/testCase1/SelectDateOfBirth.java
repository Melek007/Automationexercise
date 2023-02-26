package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SelectDateOfBirth extends MethodsRep{
	WebDriver driver;
	public SelectDateOfBirth(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "days")
	WebElement daysElement;
	@FindBy(id = "months")
	WebElement monthsElement;
	@FindBy(id = "years")
	WebElement yearsElement;
	
	public CheckBox selectDayMonthYear(String day, String month, String year)
	{
		selectOption(daysElement, day);
		selectOption(monthsElement, month);
		selectOption(yearsElement, year);
		CheckBox checkBox=new CheckBox(driver);
		return checkBox;
	}

}