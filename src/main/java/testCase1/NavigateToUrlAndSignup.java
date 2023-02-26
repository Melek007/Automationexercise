package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigateToUrlAndSignup {
	WebDriver driver;
	public NavigateToUrlAndSignup(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='/login']")
	WebElement signupLoginElement;
	@FindBy(css = "input[placeholder='Name']")
	WebElement nameElement;
	@FindBy(css = "input[data-qa='signup-email']")
	WebElement emailElement;
	@FindBy(css = "button[data-qa='signup-button']")
	WebElement signuBtnElement;
	
	public void navigate(String url)
	{
		driver.get(url);
	}
	
	public EnterAccountInformations signup(String name, String mail)
	{
		signupLoginElement.click();
		nameElement.sendKeys(name);
		emailElement.sendKeys(mail);
		signuBtnElement.click();
		EnterAccountInformations enterAccountInformations= new EnterAccountInformations(driver);
		return enterAccountInformations;
	}
	
	

}
