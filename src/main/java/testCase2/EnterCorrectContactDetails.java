package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterCorrectContactDetails {
	WebDriver driver;
	public EnterCorrectContactDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "email")
	WebElement emailElement;
	@FindBy(name = "password")
	WebElement passwordElement;
	
	public void enter_correct_email(String emailAddress)
	{
		emailElement.sendKeys(emailAddress);
	}
	public Login enter_correct_password(String password)
	{
		passwordElement.sendKeys(password);
		Login login=new Login(driver);
		return login;
	}

}
