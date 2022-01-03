package com.pom.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import com.pom.pageObjects.*;
import common.BaseClass;

public class AdminTest extends BaseClass {
	
	BaseClass baseObj = new BaseClass();
	AdminPage adminObj=new AdminPage(driver);
	
	String nationality = readconfig.getNationality();
	String nation = readconfig.getCountry();

	//For deleting the nationality field information of the employee
	@Test(priority=1)
	public void deleteNationality() throws Exception {
		
		baseObj.loginCommon();
		adminObj.admin();
		adminObj.nationalities();
		adminObj.selectCountry();
		boolean nationality = driver.findElement(By.id("ohrmList_chkSelectRecord_6")).isSelected();
		if(nationality)
		{
            Assert.assertTrue(true);
			logger.info("Checkbox is Selected, proceed further");
		}
		else
		{
			baseObj.captureScreen(driver,"AdminTest");
			Assert.assertTrue(false);
			logger.warn("Checkbox is not Selected");
		}
		adminObj.delete();
		logger.info("del click");

		Alert popup =driver.switchTo().alert();
		String alertText =driver.switchTo().alert().getText();
		System.out.println("Alert text is " + alertText);    
		popup.accept();
		baseObj.logOut();
	}

	// For adding information of the Employeee
	@Test(priority=2)
	public void addNationality() throws Exception {
		
		baseObj.loginCommon();
		adminObj.admin();
		adminObj.nationalities();
		adminObj.add(nationality);
		adminObj.save();
		logger.info("sucessfully saved");

	}

	// For selecting location preferance of the employee
	@Test(priority=3)
	public void selectLocation() throws Exception {
		baseObj.loginCommon();

		Actions action = new Actions(driver);
		WebElement Admin=findElement(By.id("menu_admin_viewAdminModule"));
		WebElement Organization=findElement(By.id("menu_admin_Organization"));
		WebElement Location=findElement(By.xpath("//a[@id='menu_admin_viewLocations']"));
		
		//Use of mouse hovering functionality using Action Class
		action.moveToElement(Admin).moveToElement(Organization).moveToElement(Location).click().build().perform();
		logger.info("Navigated to location section successfully");

		//Dropdown select functionality
		WebElement country =findElement(By.id("searchLocation_country"));
		Select dropdown=new Select(country);
		dropdown.selectByVisibleText(nation);
		baseObj.logOut();
	}

	//For checking the user status of the employee from the list using Web Table Handling
	@Test(priority=4)
	public void checkUserStatus()throws Exception{
		int rowcount = driver.findElements(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
		int statuscount=0;
		for(int i=1;i<=rowcount;i++) {
			String status = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +"]/td[5]")).getText();

			if(status.equals("Enabled")) {
				statuscount =statuscount +1;
			}
		}
		System.out.println("No.of Employees Enabled:" +statuscount);
	}


}
