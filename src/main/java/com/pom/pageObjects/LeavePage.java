package com.pom.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BaseClass;

public class LeavePage extends BaseClass {
	
	WebDriver driver;
	public LeavePage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);//initialize elements
	}
	
	@FindBy(id="menu_leave_viewLeaveModule")
	WebElement leave;

	@FindBy(id="menu_leave_viewLeaveList")
	WebElement leaveList;

	@FindBy(id="menu_leave_Configure")
	WebElement configure;

	@FindBy(id="btnSearch")
	WebElement search;

	@FindBy(id="menu_leave_defineLeavePeriod")
	WebElement leavePeriod;

	@FindBy(id="btnEdit")
	WebElement edit;

	@FindBy(id="btnEdit")
	WebElement save;

	@FindBy(id="menu_leave_viewHolidayList")
	WebElement selectholiday;

	@FindBy(id="holiday_recurring")
	WebElement checkBox;

	@FindBy(id="saveBtn")
	WebElement holidaySave;

	@FindBy(id="holiday_description")
	WebElement name;

	@FindBy(id="btnAdd")
	WebElement add;

	@FindBy(id="btnSave")
	WebElement leaveListSave;
	
	public  boolean verifySearch() throws Exception {

		leaveList.click();
		search.click();
		return true;
    }

	public boolean leaveSection() throws Exception {
		leave.click();
		return true;
	}
	
	public void leavePeriod() throws Exception{

		leavePeriod.click();
    }
	public void Leavelist() throws Exception{

		leaveList.click();
	}

	public void Edit() throws Exception{

		edit.click();
    }
	public void leaveConfigure() throws Exception{

		configure.click();
	}
	public void periodSave() throws Exception{

		save.click();
	}
	public void leavelistSearch() throws Exception{

		search.click();
	}
	public void add() throws Exception{

		add.click();
	}
	public void leaveListSave() throws Exception{

		leaveListSave.click();
	}
	public void checkBox() throws Exception{

		checkBox.click();
	}
	public void name(String employeeName)throws Exception{
		name.click();
		name.sendKeys(employeeName);
	}
	
	public void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('value','"+dateVal+"')",element);//Encapsulation
	}

}
