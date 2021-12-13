package utils;


import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	
	public ExtentTest test;
	public static ExtentReports extent;
	public String testCaseName, testDescription, category, authors;
	
	public void reportStep(String desc, String status) {

		long snapNumber = 100000l;
		
		try {
			snapNumber= takeSnap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS, desc+test.
					addScreenCapture("C:/Users/tanga/eclipse-workspace/ProjectPOM/reports/images/"+snapNumber+".jpg"));
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("C:/Users/tanga/eclipse-workspace/ProjectPOM/reports/images/"+snapNumber+".jpg"));
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
		
	}
	
	
	public void reportStepNoSnap( String desc,String status) {
		if(status.toUpperCase().equals("PASS")){
			test.log(LogStatus.PASS,desc);
		}else if(status.toUpperCase().equals("FAIL")){
			test.log(LogStatus.FAIL, desc);
		}else if(status.toUpperCase().equals("INFO")){
			test.log(LogStatus.INFO, desc);
		}
	}
	
	
	public abstract  long takeSnap();
	

	public ExtentReports startResult(){
		extent = new ExtentReports("./reports/result.html", true);
		extent.loadConfig(new File("./src/main/resources/extent-config.xml"));
		return extent;
	}

	public ExtentTest startTestCase(String testCaseName, String testDescription){
		test = extent.startTest(testCaseName, testDescription);
		return test;
	}

	public void endResult(){		
		extent.flush();
	}

	public void endTestcase(){
		extent.endTest(test);
	}

}
