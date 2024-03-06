package com.tutorialsninja.base;

import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.ninjatutorials.qa.utils.Utilits;

public class Base {
	WebDriver drv;
	public Properties prop;
	public Properties dataprop;
	
	public WebDriver selectBrowserAndOpenBrowser(String browserName ) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			drv = new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			drv = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			drv = new FirefoxDriver();
		}
		drv.manage().window().maximize();
		drv.manage().timeouts().implicitlyWait(ofSeconds(Utilits.IMPLICIT_WAITIME));
		drv.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilits.PAGELOAD_WAITIME));
		drv.get(prop.getProperty("url"));
		return drv;
	}
	
	public void loadPropertiesFile() {
		prop = new Properties();
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
			FileInputStream	fis = new FileInputStream(f);
			prop.load(fis);
			
		}catch(Throwable e) {
			e.printStackTrace();
		}
		dataprop = new Properties();
		File dataFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream dfis = null;
		try {
			dfis = new FileInputStream(dataFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			dataprop.load(dfis);	
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public Base() {
		loadPropertiesFile();
	}
	

}
