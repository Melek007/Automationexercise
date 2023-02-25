package testCase1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
	public static void main(String[] args) throws InterruptedException {
		//Test Data
		String url="http://automationexercise.com";
		String firstName="Marc";
		String lastName="Leclerc";
		String mail="m@leclerc.com"; //Kindly change the email address for every iteration
		String password="123456";
		String day="14";
		String month="February";
		String year="1989";
		String company="QA_company";
		String address="20 Rue X";
		String country="Canada";
		String state="state1";
		String city="city1";
		String zipcode="75000";
		String mobileNumber="0145678930";
		String expectedText="ACCOUNT CREATED!";
		
		//Launch browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Navigate to url
		driver.get(url);
		
		//Sign-up
		driver.findElement(By.cssSelector("a[href=\"/login\"]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(mail);
		driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
		
		//ENTER ACCOUNT INFORMATION
		driver.findElement(By.id("id_gender1")).click();
		driver.findElement(By.id("password")).sendKeys(password);
		WebElement dayDropdown=driver.findElement(By.id("days"));
		Select optionsDay= new Select(dayDropdown);
		optionsDay.selectByVisibleText(day);
		WebElement monthsDropdown=driver.findElement(By.id("months"));
		Select optionsMonths= new Select(monthsDropdown);
		optionsMonths.selectByVisibleText(month);
		WebElement yearsDropdown=driver.findElement(By.id("years"));
		Select optionsYears= new Select(yearsDropdown);
		optionsYears.selectByVisibleText(year);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		List<WebElement> checkBoxelements=driver.findElements(By.cssSelector("input[type='checkbox']"));
		for(int i=0; i<checkBoxelements.size(); i++)
		{
			if(!checkBoxelements.get(i).isSelected())
				{
				checkBoxelements.get(i).click();
				}
		}
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address);
		WebElement countryDropdown= driver.findElement(By.id("country"));
		Select countryOptions= new Select(countryDropdown);
		countryOptions.selectByVisibleText(country);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipcode")).sendKeys(zipcode);
		driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
		
		//Verify and
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2/b"))));
		String actualText=driver.findElement(By.xpath("//h2/b")).getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText);
		driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
	}

}
