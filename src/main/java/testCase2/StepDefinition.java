package testCase2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	WebDriver driver= null;
	
	@Given ("I Launch browser")
	public void I_Launch_browser()
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@And ("^I Navigate to (.+)$")
	public void I_Navigate_to_url(String url)
	{
		driver.get(url);
	}
	
	@When ("I Click on Signup Login button")
	public void I_Click_on_Signup_Login_button()
	{
		driver.findElement(By.xpath("//a[@href='/login']")).click();
	}
	
	@And ("^I Verify Login to your account (.+) is visible$")
	public void I_Verify_Login_to_your_account_is_visible(String expectedText1)
	{
		String actualText= driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
		Assert.assertEquals(actualText, expectedText1);
	}
	
	@And ("^I Enter correct (.+) and (.+)$")
	public void I_Enter_correct_emailAddress_and_password(String emailAddress, String password)
	{
		driver.findElement(By.name("email")).sendKeys(emailAddress);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@And ("I Click login button")
	public void I_Click_login_button()
	{
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
	}
	
	@And ("^I Verify that Logged in as username (.+) is visible$")
	public void I_Verify_that_Logged_in_as_username_is_visible(String expectedText2)
	{
		String actualText2= driver.findElement(By.xpath("//li[10]/a")).getText();
		Assert.assertEquals(actualText2, expectedText2);
	}
	
	@And ("I Click Logout button")
	public void I_Click_Logout_button()
	{
		driver.findElement(By.cssSelector("a[href='/logout']")).click();
	}
	
	@Then ("I Verify that Automation Exercise is present")
	public void I_Verify_that_Automation_Exercise_is_present()
	{
		WebElement element= driver.findElement(By.xpath("//a/img"));
		if(element.isEnabled())
		{
			System.out.println("Test OK");
		}
	}	
		
	@And ("I Close browser")
	public void I_Close_browser()
	{
		driver.close();
	}
}
