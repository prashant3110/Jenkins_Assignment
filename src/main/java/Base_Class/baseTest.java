package Base_Class;

import java.io.File;


import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.core.config.Configurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utils.propertyReader;

public class baseTest extends propertyReader {
	
	public static RequestSpecification httprequest;
	
	@BeforeMethod
	public void basic_Details()							
	{
		RestAssured.baseURI = getProperty("Base_URL");		// base URL getting from config.properties
		httprequest = RestAssured.given();
	}
	

	//Extent Reports
	
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	
	@BeforeMethod
	public void startTest(Method name) {
		String testname = name.getName();
		extentTest = extent.startTest(testname);
	}

	@AfterMethod
	public void endTest() {
		extent.endTest(extentTest);
	}

	@BeforeSuite
	public void setReports() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
	}

	@AfterMethod
	public void atestCaseResult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {

			extentTest.log(LogStatus.FAIL, "Test Case Failed ");
		} else {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test case passed successfully");

			}
		}
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}
	
	
	static {

		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j2.xml";

		Configurator.initialize(null, log4jConfigFile);
	}

				// Here we make the object of logger to access its functions
	public static Logger log = LogManager.getLogger(baseTest.class);

	

}
