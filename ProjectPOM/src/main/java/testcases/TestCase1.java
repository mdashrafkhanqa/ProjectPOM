package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import wrappers.ProjectSpecificWrappers;

public class TestCase1 extends ProjectSpecificWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="TestCase1";
		testDescription="Signin, Update city and state, and Signout";
		browserName="chrome";
		dataSheetName="TC001";
		category="Smoke";
		authors="Ashraf";
	}

	@Test(dataProvider="fetchData")
	public void testCase1(String EM,String PW,String city,String value) {
		new HomePage(driver, test)
		.clickSignin()
		.enterEmail(EM)
		.enterPassword(PW)
		.clickSignin()
		.clickMyAddress()
		.clickUpdate()
		.enterCity(city)
		.enterState(value)
		.clickSave()
		.verifyCity()
		.verifyState()
		.clickSignOut();
		
	}
}
