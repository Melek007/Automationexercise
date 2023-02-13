package TestCase3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDef {
	WebDriver driver=null;
	
	@Given("^user connect to home page (.+)$")
	public void user_connect_to_home_page(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}
	
	@When("^user click on login button (.+)$")
	public void user_click_on_login_button(String expectedLoginMessage)
	{
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		String actualLoginMessage = driver.findElement(By.xpath("//h2[.='Login to your account']")).getText();
		Assert.assertEquals(actualLoginMessage, expectedLoginMessage);
	}
	
	@And("^user enter incorrect email (.+)$")
	public void user_enter_incorrect_email(String wrongEmail)
	{
		driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(wrongEmail);
	}
	
	@And("^user enter incorrect password (.+)$")
	public void user_enter_incorrect_password(String wrongPassword)
	{
		driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(wrongPassword);
	}
	
	@And("user click on login button")
	public void user_click_on_login_button()
	{
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
	}
	
	@Then("^Verify error message (.+)$")
	public void Verify_error_message(String expectedErrorMessage)
	{
		String actualErrorMessage= driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		driver.close();
	}

}
