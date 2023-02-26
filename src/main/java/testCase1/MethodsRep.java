package testCase1;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodsRep {
	WebDriver driver;
	public MethodsRep(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitMethod(WebElement predectedElement) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(predectedElement));
	}
	
	public void scrolldown()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public void selectOption(WebElement dropdownElement, String visibleText)
	{
		Select options= new Select(dropdownElement);
		options.selectByVisibleText(visibleText);
	}

}
