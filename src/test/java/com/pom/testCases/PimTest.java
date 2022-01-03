package com.pom.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pom.pageObjects.PimPage;
import common.BaseClass;

public class PimTest extends BaseClass {
	
	BaseClass baseObj=new BaseClass(); 
	PimPage pimObj=new PimPage(driver);

	//For adding the employee in the employee list from the admin side using Data Driven Testing
	@Test(priority=1)
	public void addEmployees() throws Exception{

		baseObj.loginCommon();
		pimObj.addEmployee();
		logger.info("All data saved sucessfully");
		baseObj.logOut();
		
	}
	
	// For deleting the employee from the employee list
	@Test(priority=2)
	public void deleteEmployees() throws Exception{
		
		baseObj.loginCommon();	
		pimObj.pim();
		String actualUrl=driver.getCurrentUrl();
		String pimUrl="http://localhost/orangehrm-4.9/symfony/web/index.php/pim/viewEmployeeList";
		Assert.assertEquals(actualUrl,pimUrl);
		logger.info("URL verified succesfully for Pim page");
		pimObj.deleteCheckBox();
		pimObj.deleteEmployee();
		baseObj.logOut();

	}
	
	//Verifying/checking if search functionality is working or not
	@Test(priority=3)
	public void checkSearchButton() throws Exception{
		
		baseObj.loginCommon();	
		pimObj.verifySearch();
		boolean searchButton=driver.findElement(By.id("searchBtn")).isEnabled();
		if(searchButton)
		{
			Assert.assertTrue(true);
			logger.info("Search button enabled.Search operation is verified successfully ");

		}
		else
		{
			baseObj.captureScreen(driver, "PimTest");
			Assert.assertTrue(false);
			logger.info("Search button not enabled .Search operation is not working");

		}
		baseObj.logOut();
	}
	
	//for setting or uploading a profile picture of the user using sikuli tool
	@Test(priority=4)
	public void addEmployeePhoto()throws Exception{
		
		baseObj.loginCommon();
		pimObj.addPhoto();
		baseObj.logOut();
		logger.info("photo uploaded succesfully");
	}

}