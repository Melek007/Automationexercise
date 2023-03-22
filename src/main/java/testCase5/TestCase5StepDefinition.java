package testCase5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5StepDefinition {
	WebDriver driver= null;
	
	@Given("I Launch browser")
	public void I_Launch_browser()
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@And("^I Navigate to (.+)$")
	public void I_Navigate_to_url(String url)
	{
		driver.get(url);
	}
	
	@When("Click Contact Us")
	public void Click_Contact_Us()
	{
		driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
	}
	
	@And("^Enter contact details (.+), (.+), (.+) and (.+)$")
	public void Enter_contact_details_name_email_subject_and_message(String name, String email, String subject, String message)
	{
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.name("message")).sendKeys(message);
	}
	
	@And("^I Upload (.+)$")
	public void I_Upload_file(String file)
	{
		driver.findElement(By.name("upload_file")).sendKeys(file);
	}
	
	@And("I Submit")
	public void I_Submit()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
	}
	
	@Then("^I verify (.+)$")
	public void I_verify_successMessage(String successMessage)
	{
		String actualText= driver.findElement(By.cssSelector(".status.alert.alert-success")).getText();
		Assert.assertEquals(actualText, successMessage);
	}

}
