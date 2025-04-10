package com.Automation.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsUtility {
	public static ExtentReports report;
	public static ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	public  static ExtentReportsUtility extentObject;
	
	private ExtentReportsUtility() {
		
	}
	public static ExtentReportsUtility getInstance() {
		if (extentObject==null) {
			extentObject = new ExtentReportsUtility();
		}
		return extentObject;
	}
	public void startExtentReport () {
		report = new ExtentReports();
		spark = new ExtentSparkReporter (Constants.SPARKS_HTML_REPORT_PATH);
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("User Name", "Anjana");
		
		spark.config().setDocumentTitle("Test Execution Report");
		spark.config().setReportName("Salesforce TestCases");
		report.attachReporter(spark);
	}
	public void startSingleTestReport(String methodName) {
		testLogger =  report.createTest(methodName);
	}
	public void endReport() {
		report.flush();
	}
	public void logTestInfo(String text) {
		testLogger.log(Status.INFO, text);
	}
	public void LogtestPassed(String text) {
		testLogger.log(Status.INFO, MarkupHelper.createLabel(text, ExtentColor.GREEN));
	}
	public void LogtestFailed(String text) {
		testLogger.log(Status.FAIL, MarkupHelper.createLabel(text, ExtentColor.RED));
	}
	public void LogtestFailedWithException(Throwable e) {
		testLogger.log(Status.FAIL, e);
	}
	public void logTestWithscreenshot(String path){
		testLogger.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
}
