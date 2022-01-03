package com.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import common.*;
import org.openqa.selenium.By;

public class MyInfoPage extends BaseClass {
  
	WebDriver driver;

	public MyInfoPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//For adding nationality of the employee/user in the application
	private By usernameTextBox = By.name("txtUsername");
	private By passwordTextBox = By.name("txtPassword");
	private By loginButton = By.id("btnLogin");
	private By adminInfo = By.linkText("Admin");
	private By nationality = By.linkText("Nationalities");
	private By addButton = By.name("btnAdd");
	private By nationalityName = By.id("nationality_name");
	private By saveButton = By.id("btnSave");
	
	//For uploading photo/profile picture of the employee
	private By pimInfo =By.linkText("PIM");
	private By employeeList = By.linkText("Employee List");
	private By employeeSearch = By.id("empsearch_id");
	private By searchButton = By.id("searchBtn");
	private By employeePic = By.id("empPic");
	private By profilePic = By.xpath("//*[@id='photofile']");
	private By savePhoto = By.id("btnSave");
	
	//For uploading Resume/Text documents of the employee in the portal
	private By viewEmployee = By.id("menu_pim_viewEmployeeList");
	private By addAttachment = By.id("btnAddAttachment");
    private By addField = By.name("ufile");
    private By addComment = By.id("txtAttDesc");
    private By saveAttachment = By.name("btnSaveAttachment");
	
	public void setUserName(String username) throws Exception
	{
		findElement(usernameTextBox).sendKeys(username);
	}
	
	public void setPassword(String password) throws Exception
	{
		findElement(passwordTextBox).sendKeys(password);
	}
	
	public void clickSubmit() throws Exception
	{
		findElement(loginButton).click();
	}
	
	public void setInfo() throws Exception
	{
		findElement(adminInfo).click();
	}
	public void setNationality() throws Exception
	{
		findElement(nationality).click();
	}

	public void addNationality() throws Exception
	{
		findElement(addButton).click();
	}
	
	public void setNationalityName(String nationality) throws Exception
	{
		findElement(nationalityName).sendKeys(nationality);
	}
	
	public void saveNationality() throws Exception
	{
		findElement(saveButton).click();
	}
	public void pimInfosection() throws Exception
	{
		findElement(pimInfo).click();
	}
	public void EmpList() throws Exception
	{
		findElement(employeeList).click();
	}
	public void employeeSearchList(String EMPID) throws Exception
	{
		findElement(employeeSearch).sendKeys(EMPID);
		findElement(searchButton).click();
		findElement(By.linkText(EMPID)).click();
	}
	public void employeePhoto() throws Exception
	{
		findElement(employeeList).click();
	}

	public void photoProfile() throws Exception
	{
		findElement(profilePic).click();
	}
	public void savePic() throws Exception
	{
		findElement(savePhoto).click();
	}
	public void viewemployeeList(String EMPID) throws Exception
	{
		findElement(viewEmployee).click();
		findElement(By.linkText(EMPID)).click();
	}
	public void fileAttach() throws Exception
	{
		findElement(addAttachment).click();
	}
	public void fileField() throws Exception
	{
		findElement(addField).click();
	}
	public void fileComment(String Comment) throws Exception
	{
		findElement(addComment).sendKeys(Comment);
	}
	public void saveFile() throws Exception
	{
		findElement(saveAttachment).click();
	}
	
}
