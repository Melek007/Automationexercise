package TestCase17;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveProductsFromCart {
	
	@Test
	public void removeProductFromCart() {
		
		//Test Data
		String url="https://automationexercise.com/";
		String product="Sleeveless Dress";
		String expectedMessage="Cart is empty!";
		
		//Initialize
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		AddProduct addProduct=new AddProduct(driver);
		
		//KDT script
		GoToCart goToCart= addProduct.add(product);
		RemoveProduct removeProduct= goToCart.checkCart();
		VerifyProductIsRemoved verifyproductIsRemoved= removeProduct.remove();
		verifyproductIsRemoved.waitForElement();
		verifyproductIsRemoved.verifyMessage(expectedMessage);
				
	}

}
