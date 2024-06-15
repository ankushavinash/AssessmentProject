package com.cases;

import com.actions.Actions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.codoid.products.exception.FilloException;
import com.listeners.Listeners;
import com.pageObjects.AssessmentAutoFill10Page;
import com.reports.ExtentReporterNG;
import com.utils.Utils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;


public class AssessmentAutoFill10_TC1 extends Base {


	public WebDriver driver;
	public Actions actions;
	
	private Logger log = LogManager.getLogger(AssessmentAutoFill10_TC1.class.getName());
	private HashMap<String, String> data;
	private ExtentTest logs;


	@BeforeTest
	public void initialize() throws IOException, FilloException {
		
		driver = initializeDriver();
		log.info("Driver is initialized.");
		data = new Utils().getTestData("TC1");
		actions = new Actions(driver);
	}

	@Test
	public void AssessmentAutoFill_10_TC1() throws InterruptedException {

		AssessmentAutoFill10Page lp = new AssessmentAutoFill10Page(driver);

		logs = Listeners.childNode.createNode("Form Filling for user Started");
		logs.log(Status.INFO, "Student name is : " + data.get("StudentName"));

		actions.navigateTo(prop.getProperty("url10"));
		Thread.sleep(2000);

		actions.enterText(lp.getStudentName(), data.get("StudentName"));

		Thread.sleep(2000);
		logs.log(Status.INFO, "Father's name is : " + data.get("FathersName"));
		actions.enterText(lp.getFathersName(), data.get("FathersName"));
		Thread.sleep(2000);

		
/////////////		Assert.assertTrue(ac.getTitle().isDisplayed());

	}


	@AfterTest
	public void teardown() {
		driver.close();
		log.info("Driver is closed");
	}
}
