package TestCase17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
	WebDriver driver;
	public AddProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='productinfo text-center']/p")
	List<WebElement> productsListElements;
	@FindBy(xpath = "//div[@class='productinfo text-center']")
	List<WebElement> itemListElements;
	@FindBy(css = "div.product-overlay a")
	List<WebElement> addToCartListElements;
	
	public GoToCart add(String product)
	{
		for(int i=0; i<productsListElements.size(); i++)
		{
			String productName= productsListElements.get(i).getText();
			if(productName.equalsIgnoreCase(product))
			{
				WebElement itemElement= itemListElements.get(i);
				Actions actions=new Actions(driver);
				actions.moveToElement(itemElement).build().perform();
				driver.findElements(By.cssSelector("div.product-overlay a")).get(i).click();
				break;
			}
		}
		GoToCart goToCart=new GoToCart(driver);
		return goToCart;
	}
}
