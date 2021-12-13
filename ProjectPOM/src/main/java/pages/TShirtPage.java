package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class TShirtPage extends ProjectSpecificWrappers{
	
	public TShirtPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My account - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	

}
