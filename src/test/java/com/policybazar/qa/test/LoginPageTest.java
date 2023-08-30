package com.policybazar.qa.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.policybazar.qa.base.BaseClass;
import com.policybazar.qa.pages.LoginPage;
import com.policybazar.qa.utility.Utility;

public class LoginPageTest extends BaseClass {
	LoginPage lp;
	@BeforeTest
	public void openBrowser() throws IOException
	{
		BaseClass.openBrowser(Utility.readConfigfile("browserName"));
		lp=new LoginPage(driver);
	}
	@BeforeClass
	public void signIn() throws EncryptedDocumentException, IOException
	{
		lp.clickOnsignInButton();
		lp.enterMobileNumber();
		lp.clickOnsignInWithPassword();
		lp.enteringPassword();
		lp.clickOnSignIn();
	}
	@Test(description="This is the test of Verify My Accountis display")
	public void verifyMyAccountIsDisplayed() {

	lp.isMyAccountDisplayed();
	}
	@Test(description="This is test of verfiy PageTittle")
	public void verifyPageTitle()
	{
		String pageTitle=lp.getPageTitle();
		String expectedResult="Insurance - Compare & Buy Insurance Plans – Health, Term, Life, Car";
		Assert.assertEquals(pageTitle, expectedResult,"Actual and expected result not equal");
	}
	@AfterClass
	public void signOut()
	{
		lp.clickOnSignOut();
	}
	@AfterTest
	public static void closeBrowser()
	{
		BaseClass.closeBrowser();
	}
}
