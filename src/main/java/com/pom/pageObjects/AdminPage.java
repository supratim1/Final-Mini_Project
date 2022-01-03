package com.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.BaseClass;
import org.openqa.selenium.By;

public class AdminPage extends BaseClass {

   public AdminPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this); // to initialize elements
	}
   
	private By adminSection = By.id("menu_admin_viewAdminModule");
	private By manegmetSection = By.id("menu_admin_UserManagement");
	private By systemSection = By.id("menu_admin_viewSystemUsers");;

	@FindBy(id="menu_admin_viewAdminModule")
	WebElement admin;

	@FindBy(id="menu_admin_nationality")
	WebElement nationality;

	@FindBy(id="btnAdd")
	WebElement add;

	@FindBy(id="btnSave")
	WebElement save;

	@FindBy(id="nationality_name")
	WebElement nationalityname ;

	@FindBy(id="btnDelete")
	WebElement delete;

	@FindBy(id="menu_admin_Organization")
	WebElement organization;

	@FindBy(id="menu_admin_viewLocations")
	WebElement location;

	@FindBy(id="searchLocation_country")
	WebElement country ;
	@FindBy (id="ohrmList_chkSelectRecord_6")
	WebElement selectCountry;

	public  boolean verifyDelete() throws Exception {

		nationality.click();
		delete.click();
		return true;
	}
	public void admin() throws Exception{

		admin.click();
	}

	public void organization() throws Exception{

		organization.click();
	}

	public void location() throws Exception{

		location.click();
	}

	public void country() throws Exception{

		country.click();
	}

	public void nationalities() throws Exception{

		nationality.click();
	}
	public void delete() throws Exception{

		delete.click();
	}
	public void add(String Nationality) throws Exception{

		add.click();
		nationalityname.click();
		nationalityname.sendKeys(Nationality);
	}
	public void save() throws Exception{

		save.click();
	}
	public void selectCountry()throws Exception{
		selectCountry.click();
	}

    public void clickAdmin()throws Exception{
		findElement(adminSection).click();
	}
	public void clickUserManagement()throws Exception{
		findElement(manegmetSection).click();
	}
	public void clickUsers()throws Exception{
		findElement(systemSection).click();
	}

}
