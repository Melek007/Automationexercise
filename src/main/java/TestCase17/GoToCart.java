package TestCase17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoToCart {
	WebDriver driver;
	public GoToCart(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a/u")
	WebElement cartElement;
	
	public RemoveProduct checkCart()
	{
		cartElement.click();
		RemoveProduct removeProduct=new RemoveProduct(driver);
		return removeProduct;
	}

}
