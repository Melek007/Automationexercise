package TestCase17;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class VerifyProductIsRemoved {
	WebDriver driver;
	public VerifyProductIsRemoved(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p/b")
	WebElement messageElement;
	
	public void waitForElement()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(messageElement));
	}
	
	public void verifyMessage(String expectedMessage)
	{
		String actualMessage= messageElement.getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		driver.close();
	}

}
