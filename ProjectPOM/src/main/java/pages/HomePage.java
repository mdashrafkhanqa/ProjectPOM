package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class HomePage extends ProjectSpecificWrappers{
	
	public HomePage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public LoginPage clickSignin(){
	    clickByXpath("//a[@class='login']");
		return new LoginPage(driver, test);
	}

}
