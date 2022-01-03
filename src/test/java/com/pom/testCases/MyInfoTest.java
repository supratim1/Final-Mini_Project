package com.pom.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.pom.pageObjects.*;
import common.*;
import com.pom.utilities.*;

public class MyInfoTest extends BaseClass {

	BaseClass baseObj = new BaseClass();
	MyInfoPage obj = new MyInfoPage(driver);
	static String filepath = readconfig.Fileread();
	
	@DataProvider(name = "Add_Nationality")
	public static Object[][] addNationality() throws Exception {
		
		ExcelUtils objOne = new ExcelUtils();
		Object[][] testObjArray1 = objOne.getTableArray(filepath,"Sheet1");
		int arrayLength = testObjArray1.length;
		return (testObjArray1);
	}
	
	@DataProvider(name = "Add_EmployeePhoto")
	public static Object[][] addEmployeePhoto() throws Exception {
		
		ExcelUtils objTwo = new ExcelUtils();
		Object[][] testObjArray2 = objTwo.getTableArray(filepath,"Sheet2");
		int arrayLength = testObjArray2.length;
		return (testObjArray2);
	}
	
	@DataProvider(name = "Add_EmployeeResume")
	public static Object[][] addEmployeeFile() throws Exception {
		
		ExcelUtils objThree = new ExcelUtils();
		Object[][] testObjArray3 = objThree.getTableArray(filepath,"Sheet3");
		int arrayLength = testObjArray3.length;
		return (testObjArray3);
	}
	
	//For adding nationality of the employee/user in the application
	@Test(dataProvider = "Add_Nationality", priority=1)
	public void addInfo(String UserName,String Password,String Nationality) throws Exception 
	{
		obj.setUserName(UserName);
		logger.info("Username Entered");
		
		obj.setPassword(Password);
		logger.info("Password Entered");
		
		obj.clickSubmit();
		logger.info("Clicked on Login Button");
		
		//Verifying Login is successful or not
		boolean home = driver.findElement(By.id("welcome")).isDisplayed();
		if(home)
		{
			Assert.assertTrue(true);
			logger.info("Login successful and Home page displayed");
		}
		else
		{
			baseObj.captureScreen(driver,"MyInfoTest");
			Assert.assertTrue(false);
			logger.warn("Login unsuccessful");
		}
		
		obj.setInfo();
		logger.info("Navigated to the Admin info section");
		
		obj.setNationality();
		logger.info("Navigated to Nationalities section");
		
		obj.addNationality();
		logger.info("Clicked on Add Nationality Button");
		
		obj.setNationalityName(Nationality);
		logger.info("Nationality of the employee entered");
		
		obj.saveNationality();
		logger.info("Clicked on save button to save the nationality of the employee");
		
		//used for performing scroll functionality
		WebElement Element1 = findElement(By.linkText(Nationality));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element1);
		
		baseObj.logOut();
		
	}
	
	//For uploading photo/profile picture of the employee
	@Test(dataProvider = "Add_EmployeePhoto", priority=2, retryAnalyzer=com.pom.utilities.RetryFailedCases.class)
	public void AddPhoto(String UserName,String Password,String EMPID,String PhotoPath) throws Exception 
	{
		obj.setUserName(UserName);
		logger.info("Username Entered");
		
		obj.setPassword(Password);
		logger.info("Password Entered");
		
		obj.clickSubmit();
		logger.info("Clicked on Login Button");
		
		obj.pimInfosection();
		obj.EmpList();
		obj.employeeSearchList(EMPID);
		obj.employeePhoto();
		obj.photoProfile();
		
		baseObj.fileUpload(PhotoPath);
		obj.savePic();
		baseObj.logOut();
		
	}
	
	//For uploading,downloading Resume/Text documents of the employee in the portal
	@Test(dataProvider = "Add_EmployeeResume", priority=3, retryAnalyzer=com.pom.utilities.RetryFailedCases.class)
	public void AddFile(String UserName,String Password,String EMPID,String FilePath,String Comment) throws Exception 
	{
		obj.setUserName(UserName);
		logger.info("Username Entered");
		
		obj.setPassword(Password);
		logger.info("Password Entered");
		
		obj.clickSubmit();
		logger.info("Clicked on Login Button");
		
		obj.pimInfosection();
		obj.viewemployeeList(EMPID);
		obj.fileAttach();
		obj.fileField();
		
		baseObj.fileUpload(FilePath);
		obj.fileComment(Comment);
		obj.saveFile();
		baseObj.logOut();
		
	}
	
}
