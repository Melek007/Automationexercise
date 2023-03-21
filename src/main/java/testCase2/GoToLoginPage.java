package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToLoginPage extends MethodsRep{
	WebDriver driver;
	public GoToLoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@href='/login']")
	WebElement signupLoginBtn;
	@FindBy(xpath = "//div[@class='login-form']/h2")
	WebElement actualLoginTextElement;
	
	public void click_signup_login_btn(String url)
	{
		driver.get(url);
		signupLoginBtn.click();
	}
	public EnterCorrectContactDetails verify_login_to_your_account_is_visible(String expectedText1)
	{
		verifyText(actualLoginTextElement, expectedText1);
		EnterCorrectContactDetails contactDetails= new EnterCorrectContactDetails(driver);
		return contactDetails;
	}

}
