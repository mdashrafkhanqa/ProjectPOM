package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectSpecificWrappers;

public class OrderPage extends ProjectSpecificWrappers{
	
	public OrderPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Order - My Store")){
			reportStep("This is not Login Page", "Fail");
		}
	}
	
	public OrderPage verifyProductAndCheckout(){
		String product = getTextByXpath("(//a[contains(text(),'Faded Short Sleeve T-shirts')])[2]");
		System.out.println("Product in Shopping Cart verified as: "+product);
		clickByXpath("(//a[@title='Proceed to checkout'])[2]");
		return this;
	}
	
	public OrderPage proceedCheckout(){
		clickByXpath("//button[@name='processAddress']");
		return this;
	}
	
	public OrderPage checkTermsAndCheckout() throws InterruptedException{
		clickByXpath("//input[@id='cgv']");
		Thread.sleep(2000);
		clickByXpath("//button[@name='processCarrier']");
		return this;
	}
	
	public OrderPage clickSignout(){
		clickByXpath("//a[@class='logout']");
		return this;
	}

}
