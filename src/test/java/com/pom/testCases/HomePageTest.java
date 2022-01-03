package com.pom.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import com.pom.pageObjects.*;
import common.*;

public class HomePageTest extends BaseClass {

	BaseClass baseObj = new BaseClass();
	
	String homeURL= readconfig.getHomeUrl();
	
	//Used for checking if login is succesfull and homepage dashboard is displayed
	@Test(priority=1)
	public void viewDashboard() throws Exception
	{
		HomePage homeObj = new HomePage(driver);
		baseObj.loginCommon();
		
		// Verifying Url of the Home Page in the application
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,homeURL);
		logger.info("Url for the Home page in the Application matches");
		
		// Verifying the page Title
		if(driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			logger.info("Page title matches");
		}
		else
		{
			baseObj.captureScreen(driver,"HomePageTest");
			Assert.assertTrue(false);
			logger.error("Page tilte do not match");
		}
        
		homeObj.welcome();
		logger.info("Navigated to the the welcome panel");
		homeObj.logout();
		logger.info("Clicked on logout button from the dropdown menu");
		
	}
	
	//Checking if application logo is visble navigation across different sections is working
	@Test(priority=2)
	public void checkLogo() throws Exception
	{
		HomePage homeObj = new HomePage(driver);
		baseObj.loginCommon();
		logger.info("User logged in successfully");
		
		boolean logo = driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img")).isDisplayed();
		if(logo)
		{
			Assert.assertTrue(true);
			logger.info("Page logo displayed");
		}
		else
		{
			baseObj.captureScreen(driver,"HomePageTest");
			Assert.assertTrue(false);
			logger.error("Page logo is not displayed ");
		}
		
		homeObj.leaveSection();
		logger.info("Navigated to the Leave requests dashboard");
		baseObj.logOut();
	}
	
	//For checking if the Marketplace menu section can be navigated from Home page and other functionality
	@Test(priority=3)
	public void marketMenu() throws Exception
	{
		HomePage homeObj = new HomePage(driver);
		baseObj.loginCommon();
		logger.info("User logged in successfully");
		
		homeObj.pieDistribution();
		homeObj.legendSection();
		
		homeObj.launch();
		homeObj.marketMenu();
		
		homeObj.welcome();
		logger.info("Navigated to the the welcome panel");
		homeObj.logout();
		logger.info("Clicked on logout button from the dropdown menu");
		
	}
	
	//Checking if notification section is working perfectly on the Home Page 
	@Test(priority=4)
	public void checkNotifications() throws Exception
	{
		HomePage homeObj = new HomePage(driver);
		baseObj.loginCommon();
		boolean notification = driver.findElement(By.xpath("//*[@id=\"notification\"]/svg/path")).isEnabled();
		if(notification)
		{
			Assert.assertTrue(true);
			logger.info("Notification bell icon is enabled");
		}
		else
		{
			baseObj.captureScreen(driver,"HomePageTest");
			Assert.assertTrue(false);
			logger.error("Notification bell icon is not enabled");
		}
		
		homeObj.notificationCheck();
		logger.info("Switched to notification bell icon or panel");
		baseObj.logOut();
	}
	
}
