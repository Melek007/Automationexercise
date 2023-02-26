package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterAccountInformations {
	WebDriver driver;
	public EnterAccountInformations(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "id_gender1")
	WebElement genderElement;
	@FindBy(id = "password")
	WebElement passwordElement;
	
	public SelectDateOfBirth fillInformations(String password)
	{
		genderElement.click();
		passwordElement.sendKeys(password);
		SelectDateOfBirth selectDateOfBirth=new SelectDateOfBirth(driver);
		return selectDateOfBirth;
	}

}
