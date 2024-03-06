package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ninjatutorials.qa.utils.ExtentReporter;
import com.ninjatutorials.qa.utils.Utilities;

public class MyListeners implements ITestListener {

	ExtentReports extentReportObj;

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extentReportObj.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+" started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest extentTest = extentReportObj.createTest(result.getName());
		extentTest.log(Status.PASS,result.getName()+" got successfully executed" );
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("drv").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExtentTest extentTest = extentReportObj.createTest(result.getName());
		String destnfilepath = Utilities.captureScreenshot(driver, result.getName());
		extentTest.addScreenCaptureFromPath(destnfilepath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+" got failed");
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest extentTest = extentReportObj.createTest(result.getName());
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		extentReportObj = ExtentReporter.generateExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReportObj.flush();
		String extentReportPath = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File f = new File(extentReportPath);
		try {
			Desktop.getDesktop().browse(f.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
