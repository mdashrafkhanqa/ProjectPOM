package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class AddressPage extends ProjectSpecificWrappers{
	
	public AddressPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Addresses - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public UpdateAddressPage clickUpdate(){
	    clickByXpath("//span[contains(text(),'Update')]");
		return new UpdateAddressPage(driver, test);
	}
	
	public AddressPage verifyCity(){
		String city = getTextByXpath("(//div[@id='center_column']//span)[6]");
		System.out.println("City of the Address verified as: "+city);
		return this;
	}
	
	public AddressPage verifyState(){
		String state = getTextByXpath("(//div[@id='center_column']//span)[7]");
		System.out.println("State of the Address verified as: "+state);
		return this;
	}
	
	public LoginPage clickSignOut(){
		clickByXpath("//a[@class='logout']");
		return new LoginPage(driver, test); 
	}	
	
	

}
