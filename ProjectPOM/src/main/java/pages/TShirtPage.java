package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class TShirtPage extends ProjectSpecificWrappers{
	
	public TShirtPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("T-shirts - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public OrderPage scrollFadedTshirtClickAddCart() throws InterruptedException{
		Thread.sleep(2000);
		mouseOverByXpath("//div[@id='center_column']//img");
		clickByXpath("(//div[@id='center_column']//span)[9]");
		Thread.sleep(2000);
		String message = getTextByXpath("(//div[@id='layer_cart']//h2)[1]");
		System.out.println("Verified the pop-up message as: "+message);
		Thread.sleep(2000);
		clickByXpath("(//div[@id='layer_cart']//span)[14]");
		return new OrderPage(driver, test);
	}

}
