package TestCase3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginIncorrect {
	@Test
	public void loginWrongData() {
		//Test Data
		String url="https://automationexercise.com/";
		String wrongEmail="m@m.com";
		String wrongPassword="cc";
		String expectedLoginMessage="Login to your account";
		String expectedErrorMessage="Your email or password is incorrect!";
		
		//Home page
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		
		//Scenario
		driver.findElement(By.xpath("//a[@href='/login']")).click();
		String actualLoginMessage = driver.findElement(By.xpath("//h2[.='Login to your account']")).getText();
		Assert.assertEquals(actualLoginMessage, expectedLoginMessage);
		driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(wrongEmail);
		driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(wrongPassword);
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
		String actualErrorMessage= driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']")).getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
		driver.close();
	}

}
