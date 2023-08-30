package com.policybazar.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccount {
	WebDriver driver;

	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myAccount;
	@FindBy(xpath="//span[text()=' My profile ']")
	private WebElement myProfile;
	
	
	
	public MyAccount(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnMyProfile()
	{
		Reporter.log("clicking on my profile", true);
		Actions act=new Actions(driver);
		act.click(myAccount).moveToElement(myProfile).click().build().perform();  

	}
	

	
}
