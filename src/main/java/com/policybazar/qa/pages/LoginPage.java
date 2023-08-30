package com.policybazar.qa.pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.policybazar.qa.utility.Utility;

public class LoginPage {
	WebDriver driver;
	@FindBy(xpath="//a[text()='Sign in']")
	private  WebElement signInButton;
	@FindBy(xpath="(//input[@type='number'])[2]")
	private WebElement mobileNumber;
	@FindBy(xpath="(//span[text()='Sign in with Password'])[2]")
	private WebElement signInWithPassword;
	@FindBy(xpath="//input[@id='central-login-password']")
	private WebElement password;
	@FindBy(xpath="//span[@id='login-in-with-password-span']")
	private WebElement signIn;
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//span[text()='Sign out']")
	private WebElement signOut;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void clickOnsignInButton()
	{
		Reporter.log("clicking on Sign In button", true);
		signInButton.click();
	}
	public void enterMobileNumber() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Entering mobile number", true);
		mobileNumber.sendKeys(Utility.readDataFromExcel(1, 0));	
	}
	public void clickOnsignInWithPassword()
	{
		Reporter.log("clicking on signIn with password", true);
		signInWithPassword.click();
	}
	public void enteringPassword() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Entering password", true);
		password.sendKeys(Utility.readDataFromExcel(1, 1));
	}
		public void clickOnSignIn()
	{
		Reporter.log("clicking on signIn", true);
		signIn.click();
	}
	
	public boolean isMyAccountDisplayed()
	{
		Reporter.log("getting the result of is my account display", true);
		Utility.impliciteWait(2);
		return myAccount.isDisplayed();
	}
	public String getPageTitle()
	{
		Reporter.log("getting the page title", true);
		Utility.impliciteWait(2);
		return driver.getTitle();
	}
	public void clickOnSignOut()
	{
		Reporter.log("clicking on signOut", true);
		//Utility.impliciteWait(2);
		Utility.expliciteWait(driver, 10, myAccount);
		Actions act=new Actions(driver);
		act.moveToElement(myAccount).moveToElement(signOut).click().build().perform();
	}

}
