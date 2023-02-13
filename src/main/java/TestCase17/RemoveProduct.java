package TestCase17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProduct {
	WebDriver driver;
	public RemoveProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tr[@id='product-3']/td[6]/a")
	WebElement removeElement;
	
	public VerifyProductIsRemoved remove()
	{
		removeElement.click();
		VerifyProductIsRemoved verifyproductIsRemoved= new VerifyProductIsRemoved(driver);
		return verifyproductIsRemoved;
	}

}
