package com.policybazar.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.policybazar.qa.base.BaseClass;

public class Utility extends BaseClass {
	
	public static String readConfigfile(String propName) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("Configuration\\config.properties");
		prop.load(file);
		return prop.getProperty(propName);
	}
	public void takeScreenshot(String fileName) throws IOException
	{
		Date currentDate=new Date();
		String date=currentDate.toString().replace(" ", "-").replace(":", "-");
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("Screenshots"+date+fileName+".png");
		FileHandler.copy(source, dest);
	}
	public static String readDataFromExcel(int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("Testdata\\data.xlsx");
		String  value=WorkbookFactory.create(file).getSheet("Sheet1").getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
	}
	public static void impliciteWait(int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public static void scrollIntoview(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView[true]",element );
	}
	public static void expliciteWait(WebDriver driver, int time,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

}
