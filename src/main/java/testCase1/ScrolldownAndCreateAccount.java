package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrolldownAndCreateAccount extends MethodsRep {
	WebDriver driver;
	public ScrolldownAndCreateAccount(WebDriver driver)
	
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "button[data-qa='create-account']")
	WebElement createAccountBtnElement;
	
	public VerifyAndContinue createAccount()
	{
		scrolldown();
		createAccountBtnElement.click();
		VerifyAndContinue verifyAndContinue= new VerifyAndContinue(driver);
		return verifyAndContinue;
	}

}
