package com.pom.testCases;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pom.pageObjects.*;
import com.pom.utilities.ExcelUtils;
import common.*;

public class LoginTest extends BaseClass{

   BaseClass baseObject = new BaseClass();
   
   //For performing Data Driven Testing
   @DataProvider(name="loginFunctionality")
   public String[][] dataDriven() throws Exception{
	  
	   String path= readconfig.getLoginpath();
	   int totalrows =ExcelUtils.getRowCount(path,"Sheet1");
	   int totalcolmns = ExcelUtils.getColumnCount(path,"Sheet1", 1);
	   String loginData[][]=new String[totalrows][totalcolmns];
	   for(int i=1;i<=totalrows;i++) {
		   for(int j=0;j<totalcolmns;j++) {
			   loginData[i-1][j] =ExcelUtils.getCellData(path,"Sheet1", i, j);
		   }
	   }
	   
       return loginData;
   }
   
   //Verifying Login section url
    @Test(priority=1)
	public void checkLoginPageUrl() throws Exception{

    	logger.info("");
		logger.info("Url is opening");
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, baseURL);
		logger.info("Url is correct");
	}

   // Veryfing Login page Title 
    @Test(priority=2)
	public void checkLoginPageTitle() throws Exception {

    	logger.info("2nd test case is running");
		boolean loginTitle = driver.getTitle().equals("OrangeHRM");
		if(loginTitle) {
			Assert.assertTrue(true);
			logger.info("Title is matched");
		}else {
			baseObject.captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.error("Title does not matched");
		}
	}

    //Checking for Login Panel if the buutons are enabled and Textboxes are displayed
    @Test(priority=3)
	public void checkLoginPanel() throws Exception {

        logger.info("Test case 3 running");
		logger.info("Checking username box present or not");
		
		boolean userNameBox = driver.findElement(By.id("txtUsername")).isDisplayed();
		if(userNameBox) {
			Assert.assertTrue(true);
			logger.info("User name box is dislayed");
		}else {
			Assert.assertTrue(false);
			baseObject.captureScreen(driver, "loginTest");
			logger.error("User name box not dislayed");
		}
		logger.info("Checking password box present or not");
		
		boolean passwordBox = driver.findElement(By.id("txtPassword")).isDisplayed();
		if(passwordBox) {
			Assert.assertTrue(true);
			logger.info("Password is present");
		}else {
			Assert.assertTrue(false);
			baseObject.captureScreen(driver, "LoginTest");
			logger.info("Password not present");
		}
	}
    
    //Checking for login functionality taking all cases of valid and invalid credentials 
    // using Data Driven Testing
	@Test(priority=4, dataProvider="loginFunctionality")
	public void loginCredentials(String rows,String cloum,String expected) throws Exception {

        logger.info("Test case 4 is running");
		LoginPage loginObj = new LoginPage(driver);
		loginObj.setUserName(rows);
		loginObj.setPassword(cloum);
		loginObj.clickSubmit();
		
		logger.info("login data given");
		boolean actualElement = driver.findElement(By.id("welcome")).isDisplayed();
		if(expected.equals("Valid")) {
			if(actualElement) {
				baseObject.logOut();
				Assert.assertTrue(true);
				logger.info("login Successfull");
			}else {
				Assert.assertTrue(false);
				logger.error("Login unsuccessfull");
			}
		}else if (expected.equals("Invalid")) {
			if(actualElement) {
				baseObject.logOut();
				Assert.assertTrue(false);
				logger.warn("login Successfull");
			}else {
				Assert.assertTrue(true);
				logger.info("login unsuccessfull");
			}
		}

   }
	
}