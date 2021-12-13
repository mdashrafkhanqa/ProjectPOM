package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class UpdateAddressPage extends ProjectSpecificWrappers{
	
	public UpdateAddressPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Address - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public UpdateAddressPage enterCity(String city){
		enterByXpath("//input[@id='city']", ""+city+"");
		return this; 
	}
	
	public UpdateAddressPage enterState(String value){
		selectVisibileTextByXPath("//select[@id='id_state']", value);
		return this; 
	}
	
	public AddressPage clickSave() {
		clickByXpath("//button[@id='submitAddress']");
		return new AddressPage(driver, test);
	}

}
