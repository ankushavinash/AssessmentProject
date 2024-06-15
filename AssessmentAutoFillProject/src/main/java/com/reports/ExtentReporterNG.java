package com.reports;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	public static ExtentReports extent;


	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir")+"//reports//report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		//add system information/environment info to reports
		extent.setSystemInfo("OS ", "Windows");
		extent.setSystemInfo("Browser ", "Chrome");
		extent.setSystemInfo("Tester", System.getProperty("user.name"));
		try {
			extent.setSystemInfo("Machine", InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to capture hostname.");
		}

		reporter.config().setReportName("Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);


		
		return extent;
	}
}
