package com.ninjatutorials.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilits {
	
	public static final int IMPLICIT_WAITIME = 10;
	public static  final int PAGELOAD_WAITIME = 10;
	
	public static String generateRandomEmail() {
		Date date = new Date();
		String formattedDate = date.toString().replace(" ", "_").replace(":","_");
		String email = "random"+formattedDate+"@gmail.com";
		return email;
		
	}
	
	public static String[][] getdataFromExcel(String sheetname) {
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(sheetname);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		String [][] arr = new String [rows-1][cols];
		for(int r =1;r<rows;r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0 ; c<cols;c++) {
			DataFormatter df = new DataFormatter();
			XSSFCell cell =	row.getCell(c);
			arr[r-1][c] = df.formatCellValue(cell);
			
			}
		}
		return arr;
		
	}
	

}
