package testCase2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	WebDriver driver;
	public LaunchBrowser(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public GoToLoginPage launch_Edge()
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		GoToLoginPage goToLoginPage= new GoToLoginPage(driver);
		return goToLoginPage;
	}

}
