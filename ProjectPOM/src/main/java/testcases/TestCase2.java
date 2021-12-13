package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.ProjectSpecificWrappers;

public class TestCase2 extends ProjectSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TestCase2";
		testDescription="Signin, Add cart, Checkout and Signout";
		browserName="chrome";
		dataSheetName="TC002";
		category="Smoke";
		authors="Ashraf";
	}

	@Test(dataProvider="fetchData")
	public void testCase1(String EM,String PW) {
		new HomePage(driver, test)
		.clickSignin()
		.enterEmail(EM)
		.enterPassword(PW)
		.clickSignin()
		.mouseOverWomenClickTshirt()
		;
		
	}

}
