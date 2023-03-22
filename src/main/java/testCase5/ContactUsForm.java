package testCase5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsForm {
	public static void main(String[] args) {
		//Test Data
		String url="https://automationexercise.com/";
		String name="Louis";
		String email="louis@automation.com";
		String subject="Test";
		String message="TestCase number 5 is Ok";
		String file="C:\\Users\\melek\\Downloads\\Upload_Test.docx";
		String expectedText="Success! Your details have been submitted successfully.";
		
		//Launch browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Navigate to url
		driver.get(url);
		
		//Click Contact Us
		driver.findElement(By.xpath("//a[@href='/contact_us']")).click();
		
		//Enter contact details
		driver.findElement(By.name("name")).sendKeys(name);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("subject")).sendKeys(subject);
		driver.findElement(By.name("message")).sendKeys(message);
		
		//Upload file
		driver.findElement(By.name("upload_file")).sendKeys(file);
		
		//Submit
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.name("submit")).click();
		driver.switchTo().alert().accept();
		
		//Verify
		String actualText= driver.findElement(By.cssSelector(".status.alert.alert-success")).getText();
		Assert.assertEquals(actualText, expectedText);
	}

}
