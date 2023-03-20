package testCase2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testCase2Script {
	@Test
	public void testcase2() {
		//Test Data
		String url="https://automationexercise.com/";
		String expectedText1="Login to your account";
		String emailAddress= "marc@gmail.com";
		String password="123456";
		String expectedText2="Logged in as Marc";
		//Launch browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Navigate to url
		driver.get(url);
		//Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		//Verify 'Login to your account' is visible
		String actualText= driver.findElement(By.xpath("//div[@class='login-form']/h2")).getText();
		Assert.assertEquals(actualText, expectedText1);
		//Enter correct email address and password
		driver.findElement(By.name("email")).sendKeys(emailAddress);
		driver.findElement(By.name("password")).sendKeys(password);
		//Click 'login' button
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
		//Verify that 'Logged in as username' is visible
		String actualText2= driver.findElement(By.xpath("//li[10]/a")).getText();
		Assert.assertEquals(actualText2, expectedText2);
		//Click 'Logout' button
		driver.findElement(By.cssSelector("a[href='/logout']")).click();
		//Verify that "Automation Exercise" is present
		WebElement element= driver.findElement(By.xpath("//a/img"));
		if(element.isEnabled())
		{
			System.out.println("Test OK");
		}
		//Close browser
		driver.close();
	}

}
