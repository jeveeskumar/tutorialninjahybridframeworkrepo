package com.ninjatutorials.qa.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	public static String captureScreenshot(WebDriver driver, String testName) {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destnFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		try {
			FileHandler.copy(file, new File(destnFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destnFilePath;
	}

}
