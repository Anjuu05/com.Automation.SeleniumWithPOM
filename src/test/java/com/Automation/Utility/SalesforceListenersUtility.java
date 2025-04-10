package com.Automation.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeClass;

import com.Automation.Base.BaseTest;
import com.Automation.Tests.UserMenuDropDownTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestListener;

public class SalesforceListenersUtility extends BaseTest implements ITestListener,ISuiteListener{
	
	private Logger mylog = LogManager.getLogger(SalesforceListenersUtility.class);
	private ExtentReportsUtility extentReportUtility = ExtentReportsUtility.getInstance();
		 
	@Override
	public void onStart(ISuite suite) {
		mylog.info(suite.getName()+"Started..................");
		extentReportUtility.startExtentReport();
	}
	
	@Override
	public void onFinish(ISuite suite) {
		mylog.info(suite.getName()+"Ended..................");
		extentReportUtility.endReport();
	}
	@Override
	public void onStart(ITestContext context) {
		mylog.info(context.getName()+"Started..................");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		mylog.info(context.getName()+"Ended..................");
	}

	
	@Override
	public void onTestStart(ITestResult result) {
		mylog.info(result.getMethod().getMethodName()+" started............");
		extentReportUtility.startSingleTestReport(result.getMethod().getMethodName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		mylog.info(result.getMethod().getMethodName()+" ended with success!");
		extentReportUtility.LogtestPassed(result.getMethod().getMethodName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		mylog.error(result.getMethod().getMethodName()+" ended with failure!");
		extentReportUtility.LogtestFailedWithException(result.getThrowable());

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		mylog.warn(result.getMethod().getMethodName()+"@Test got skipped");
		extentReportUtility.LogtestFailed(result.getMethod().getMethodName()+" skipped!");
	}
	
}
