package testCase1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBox extends MethodsRep{
	WebDriver driver;
	public CheckBox(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[type='checkbox']")
	List<WebElement> checkBoxElements;
	
	public CompleteDetails scrolldownAndCheckBox()
	{
		scrolldown();
		for(int i=0; i<checkBoxElements.size(); i++)
		{
			if(!checkBoxElements.get(i).isSelected())
				{
				checkBoxElements.get(i).click();
				}
		}
		CompleteDetails completeDetails=new CompleteDetails(driver);
		return completeDetails;
	}

}
