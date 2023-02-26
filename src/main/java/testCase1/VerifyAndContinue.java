package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyAndContinue extends MethodsRep{
	WebDriver driver;
	public VerifyAndContinue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h2/b")
	WebElement textElement;
	@FindBy(css = "a[data-qa='continue-button']")
	WebElement continueBtnElement;
	
	public void verifyText(String expectedText)
	{
		waitMethod(textElement);
		String actualText= textElement.getText();
		Assert.assertEquals(actualText, expectedText);
	}
	
	public void clickContinue() 
	{
		continueBtnElement.click();
	}
	

}
