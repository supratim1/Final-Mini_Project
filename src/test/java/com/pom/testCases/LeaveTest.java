package com.pom.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.pageObjects.*;
import common.BaseClass;

public class LeaveTest extends BaseClass {

    BaseClass baseObj=new BaseClass(); 
	LeavePage leaveObj=new LeavePage(driver);
	String employeeName = readconfig.getName();

	// Checking for search functionality
	@Test(priority=1)
	public void verifySearchfunction() throws Exception{

		baseObj.loginCommon();

		leaveObj.leaveSection();
		logger.info("navigated to leave section verifyed successfully");
		boolean searchButton=findElement(By.id("btnSearch")).isEnabled();
		
		if(searchButton)
		{
			Assert.assertTrue(true);
			logger.info("Search button Enabled");
		}
		else
		{
			baseObj.captureScreen(driver, "LeaveTest");
			Assert.assertTrue(false);
			logger.info("Search button not Enabled");
		}
		leaveObj.verifySearch();
        logger.info("Search operation is verified successfully ");

		baseObj.logOut();
	}

	//Checking if the date-time picker functionality is working or not
	@Test(priority=2)
	public void dateTimePicker() throws Exception {
		baseObj.loginCommon();

		leaveObj.leaveSection();
		leaveObj.Leavelist();

		WebElement date=findElement(By.id("calFromDate"));
		WebElement date2=findElement(By.id("calToDate"));
		String dateVal="2022-01-01";
		String dateValue="2023-12-31";

		leaveObj.selectDateByJS(driver,date,dateVal);
		leaveObj.selectDateByJS(driver,date2,dateValue);
		leaveObj.leavelistSearch();
		baseObj.logOut();

	}

	//Checking if the user can select suitable dates while applying for leave functionality
	@Test(priority=3)
	public void monthDateVerify() throws Exception {
		baseObj.loginCommon();

		leaveObj.leaveSection();
		Actions action = new Actions(driver);
		WebElement Configure=findElement(By.id("menu_leave_Configure"));
		WebElement leavePeriod=findElement(By.id("menu_leave_defineLeavePeriod"));
		action.moveToElement(Configure).moveToElement(leavePeriod).click().build().perform();

		leaveObj.Edit();
		WebElement month_dropdown=findElement(By.id("leaveperiod_cmbStartMonth"));
		WebElement date_dropdown=findElement(By.id("leaveperiod_cmbStartDate"));
		Select monthdropdown=new Select(month_dropdown);//
		Select datedropdown=new Select(date_dropdown);//
		monthdropdown.selectByIndex(3);
		datedropdown.selectByIndex(6);
		leaveObj.periodSave();
		baseObj.logOut();
	}

	// For Leave approve functionality
	@Test(priority=4)
	public void holidaySetfunction() throws Exception {
		
		baseObj.loginCommon();
        leaveObj.leaveSection();

		Actions action = new Actions(driver);
		WebElement Configure=findElement(By.id("menu_leave_Configure"));
		WebElement Holiday=findElement(By.id("menu_leave_viewHolidayList"));
		
		action.moveToElement(Configure).moveToElement(Holiday).click().build().perform();
		logger.info("Navigated to Holiday Section successfully");
		leaveObj.add();
		leaveObj.name(employeeName);
		WebElement date=findElement(By.id("holiday_date"));
		String dateVal="2022-10-22";
		leaveObj.selectDateByJS(driver,date,dateVal);
		leaveObj.checkBox();
		leaveObj.leaveListSave();
		baseObj.logOut();
	}

}