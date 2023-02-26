package testCase1;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {
	@Test
	public void registerUser() throws InterruptedException {
		//Test Data
		String url="http://automationexercise.com";
		String firstName="Marc";
		String lastName="Leclerc";
		String mail="marc1989@leclerc1.com"; //Kindly change the email address for every iteration
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
		NavigateToUrlAndSignup navigateToUrlAndSignup=new NavigateToUrlAndSignup(driver);
		
		//KDT script
		navigateToUrlAndSignup.navigate(url);
		EnterAccountInformations enterAccountInformations= navigateToUrlAndSignup.signup(lastName, mail);
		SelectDateOfBirth selectDateOfBirth= enterAccountInformations.fillInformations(password);
		CheckBox checkBox= selectDateOfBirth.selectDayMonthYear(day, month, year);
		CompleteDetails completeDetails= checkBox.scrolldownAndCheckBox();
		completeDetails.fillDetails(firstName, lastName, company, address);
		completeDetails.selectCountry(country);
		ScrolldownAndCreateAccount scrolldownAndCreateAccount= completeDetails.fillOtherDetails(state, city, zipcode, mobileNumber);
		VerifyAndContinue verifyAndContinue= scrolldownAndCreateAccount.createAccount();
		verifyAndContinue.verifyText(expectedText);
		verifyAndContinue.clickContinue();
	}

}
