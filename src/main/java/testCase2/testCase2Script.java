package testCase2;




import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class testCase2Script {
	@Test
	public void testcase2() {
		//Test Data
		String url="https://automationexercise.com/";
		String expectedText1="Login to your account";
		String emailAddress= "marc@gmail.com";
		String password="123456";
		String expectedText2="Logged in as Marc";
		//Test execution
		WebDriver driver=null;
		LaunchBrowser launchBrowser=new LaunchBrowser(driver);
		GoToLoginPage goToLoginPage= launchBrowser.launch_Edge();
		goToLoginPage.click_signup_login_btn(url);
		EnterCorrectContactDetails contactDetails= goToLoginPage.verify_login_to_your_account_is_visible(expectedText1);
		contactDetails.enter_correct_email(emailAddress);
		Login login= contactDetails.enter_correct_password(password);
		login.click_Login_Btn();
		Logout logout= login.verify_that_Loggedin_as_username_is_visible(expectedText2);
		logout.click_Logout_Btn();
		logout.verify_and_close();
	}

}
