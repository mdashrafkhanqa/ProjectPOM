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
		if (city.equals("San Diego,")) {
			System.out.println("City verified same as actual and expected");
		}
		else {
			System.out.println("Failed to verify the city");
		}
		return this;
	}
	
	public AddressPage verifyState(){
		String state = getTextByXpath("(//div[@id='center_column']//span)[7]");
		System.out.println("State of the Address verified as: "+state);
		if (state.equals("California")) {
			System.out.println("State verified same as actual and expected");
		}
		else {
			System.out.println("Failed to verify the state");
		}
		return this;
	}
	
	public LoginPage clickSignOut(){
		clickByXpath("//a[@class='logout']");
		closeBrowser();
		return new LoginPage(driver, test); 
	}	
	
	

}
