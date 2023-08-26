package com.policybazar.qa.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.policybazar.qa.utility.Utility;

public class BaseClass {

	public static WebDriver driver = null;

	public static void openBrowser(String bName) throws IOException {
		if (bName.equalsIgnoreCase("chrome")) {
			Reporter.log("opening chrome browser", true);
			driver = new ChromeDriver();

		} else if (bName.equalsIgnoreCase("firefox")) {
			Reporter.log("opening firefox browser", true);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		Reporter.log("Entering url", true);
		driver.get(Utility.readConfigfile("url"));
		// apply wait here

	}

	public static void closeBrowser() {
		driver.quit();
		// apply wait here
	}

}
