package TestCase17;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDef {
	WebDriver driver=null;
	
	@Given("^user connects to home page (.+)$")
	public void user_connects_to_home_page(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}
	
	@When("^user adds product (.+)$")
	public void user_adds_product(String product)
	{
		List<WebElement> productsList= driver.findElements(By.xpath("//div[@class='productinfo text-center']/p"));
		for(int i=0; i<productsList.size(); i++)
		{
			String productName= productsList.get(i).getText();
			if(productName.equalsIgnoreCase(product))
			{
				WebElement itemElement= driver.findElements(By.xpath("//div[@class='productinfo text-center']")).get(i);
				Actions actions=new Actions(driver);
				actions.moveToElement(itemElement).build().perform();
				driver.findElements(By.cssSelector("div.product-overlay a")).get(i).click();
				break;
			}
		}
	}
	
	@And("user checks the cart")
	public void user_checks_the_cart()
	{
		driver.findElement(By.xpath("//a/u")).click();
	}
	
	@And ("user removes product")
	public void user_removes_product()
	{
		driver.findElement(By.xpath("//tr[@id='product-3']/td[6]/a")).click();
	}
	
	@Then("^verify that product is removed from the cart (.+)$")
	public void verify_that_product_is_removed_from_the_cart(String expectedMessage)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p/b"))));
		String actualMessage= driver.findElement(By.xpath("//p/b")).getText();
		Assert.assertEquals(actualMessage, expectedMessage);
		driver.close();
	}

}
