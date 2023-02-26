package testCase1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompleteDetails extends MethodsRep{
	WebDriver driver;
	public CompleteDetails(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="first_name")
	WebElement firstNameElement;
	@FindBy(id ="last_name")
	WebElement lastNameElement;
	@FindBy(id ="company")
	WebElement companyElement;
	@FindBy(id ="address1")
	WebElement address1Element;
	@FindBy(id ="country")
	WebElement countryElement;
	@FindBy(id = "state")
	WebElement stateElement;
	@FindBy(id = "city")
	WebElement cityElement;
	@FindBy(id = "mobile_number")
	WebElement mobileNumberElement;
	@FindBy(id = "zipcode")
	WebElement zipcodeElement;
	
	public void fillDetails(String firstName, String lastName, String company, String address)
	{
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		companyElement.sendKeys(company);
		address1Element.sendKeys(address);
	}
	
	public void selectCountry(String country)
	{
		selectOption(countryElement, country);
	}
	
	public ScrolldownAndCreateAccount fillOtherDetails(String state, String city, String zipcode, String mobileNumber)
	{
		stateElement.sendKeys(state);
		cityElement.sendKeys(city);
		zipcodeElement.sendKeys(zipcode);
		mobileNumberElement.sendKeys(mobileNumber);
		ScrolldownAndCreateAccount scrolldownAndCreateAccount=new ScrolldownAndCreateAccount(driver);
		return scrolldownAndCreateAccount;
	}
}
