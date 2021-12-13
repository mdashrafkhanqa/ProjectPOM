package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class LoginPage extends ProjectSpecificWrappers{
	
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Login - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public LoginPage enterEmail(String EM){
		enterById("email", EM);
		return this;
	}
	
	public LoginPage enterPassword(String PW){
		enterById("passwd", PW);
		return this;
	}
	
	public AccountPage clickSignin(){
		clickById("SubmitLogin");		
		return new AccountPage(driver, test);
	}

}
