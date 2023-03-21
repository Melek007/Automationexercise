package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	WebDriver driver;
	public Logout(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "a[href='/logout']")
	WebElement logoutBtn;
	@FindBy(xpath = "//a/img")
	WebElement imgElement;
	
	public void click_Logout_Btn()
	{
		logoutBtn.click();
	}
	
	public void verify_and_close()
	{
		if(imgElement.isEnabled())
		{
			System.out.println("Test OK");
		}
	driver.close();
	}
	

}
