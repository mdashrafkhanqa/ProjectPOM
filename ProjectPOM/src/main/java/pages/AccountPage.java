package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class AccountPage extends ProjectSpecificWrappers{
	
	public AccountPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My account - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public AddressPage clickMyAddress(){
	    clickByXpath("//span[contains(text(),'My addresses')]");
		return new AddressPage(driver, test);
	}
	
	public TShirtPage mouseOverWomenClickTshirt(){
	    mouseOverByXpath("//a[@title='Women']");
	    clickByXpath("(//a[@title='T-shirts'])[1]");
		return new TShirtPage(driver, test);
	}

}
