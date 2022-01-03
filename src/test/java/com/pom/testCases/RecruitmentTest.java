package com.pom.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pom.pageObjects.RecruitmentPage;
import common.BaseClass;

public class RecruitmentTest extends BaseClass {

	BaseClass obj=new BaseClass();
	RecruitmentPage recruitObj=new RecruitmentPage(driver);

	//Verifying reset functionality in the job application section
	@Test(priority=1)
	public void resetAction() throws Exception{

		obj.loginCommon();

		recruitObj.verifyReset();
		boolean resetButton=driver.findElement(By.id("btnRst")).isEnabled();
		if(resetButton)
		{
			Assert.assertTrue(true);
			logger.info("reset button enabled");
		}
		else
		{
			obj.captureScreen(driver, "RecruitmentTest");
			Assert.assertTrue(false);
			logger.info("Reset button not enabled");
		}

		logger.info("Reset operation is verified successfully ");
		obj.logOut();
		
	}

	//For recruiting employees and checking for the employment status
	@Test(priority=2)
	public void employeeAdd() throws Exception{

		obj.loginCommon();
		recruitObj.addEmployees();
		logger.info("Data added successfully");
		obj.logOut();
	}

	//Screenshot functionality using "Ashot" Api concept
	@Test(priority=3)
	public void screenshot() throws Exception{
		obj.loginCommon();
		recruitObj.takeScreenshot();
		logger.info("image captured successfully");
		obj.logOut();
	}

	// screenshot Compare functionality using "Ashot" Api concept
	@Test(priority=4)
	public void screenshotCompare() throws Exception{
		obj.loginCommon();
		recruitObj.compareScreenshot();;
		logger.info("image compared successfully");
		obj.logOut();
	}

}