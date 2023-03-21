package testCase2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MethodsRep {
	WebDriver driver;
	public MethodsRep(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void verifyText(WebElement textElement, String expectedText)
	{
		String actualText= textElement.getText();
		Assert.assertEquals(actualText, expectedText);
	}

}
