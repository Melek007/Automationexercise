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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepsDefinition {
	WebDriver driver= null;
	
	@Given ("^User launches browser and navigates to home page (.+)$")
	public void User_launches_browser_and_navigates_to_home_page(String url)
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
	}
	
	@When("^User signs up with (.+) and (.+)$")
	public void User_signs_up_with_firstName_and_mail(String firstName, String mail)
	{
		driver.findElement(By.cssSelector("a[href=\"/login\"]")).click();
		driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(mail);
		driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
	}
	
	@And ("^User enters account informations (.+) (.+) (.+) (.+)$")
	public void User_enters_account_informations_password_day_month_year(String password, String day, String month, String year)
	{
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
	}
	
	@And ("User scrolls down and selects checkbox")
	public void User_scrolls_down_and_selects_checkbox()
	{
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
	}
	
	@And ("^User fills (.+) (.+) (.+) (.+)$")
	public void User_fills_firstName_lastName_company_address(String firstName, String lastName, String company, String address)
	{
		driver.findElement(By.id("first_name")).sendKeys(firstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("company")).sendKeys(company);
		driver.findElement(By.id("address1")).sendKeys(address);
	}
	
	@And ("^User selects (.+)$")
	public void User_selects_country(String country)
	{
		WebElement countryDropdown= driver.findElement(By.id("country"));
		Select countryOptions= new Select(countryDropdown);
		countryOptions.selectByVisibleText(country);
	}
	
	@And ("^User completes details (.+) (.+) (.+) (.+)$")
	public void User_completes_details_state_city_zipcode_mobileNumber(String state, String city, String zipcode, String mobileNumber)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("zipcode")).sendKeys(zipcode);
		driver.findElement(By.id("mobile_number")).sendKeys(mobileNumber);
	}
	
	@And ("User scrolls down and click cearte account button")
	public void User_scrolls_down_and_click_cearteaccount__button()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
	}
	
	@Then ("^User verify message (.+)$")
	public void User_verify_message_expectedText(String expectedText)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2/b"))));
		String actualText=driver.findElement(By.xpath("//h2/b")).getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, expectedText);
	}
	
	@And("User clicks continue button")
	public void User_clicks_continue_button()
	{
		driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
	}
}
