package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends MethodsRep{
	WebDriver driver;
	public Login(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[data-qa='login-button']")
	WebElement loginBtn;
	@FindBy(xpath = "//li[10]/a")
	WebElement actualTextElement;
	
	public void click_Login_Btn()
	{
		loginBtn.click();
	}
	
	public Logout verify_that_Loggedin_as_username_is_visible(String expectedText)
	{
		verifyText(actualTextElement, expectedText);
		Logout logout= new Logout(driver);
		return logout;
	}
	

}
