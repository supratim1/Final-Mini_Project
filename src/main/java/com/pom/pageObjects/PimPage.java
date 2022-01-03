package com.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import common.BaseClass;

public class PimPage extends BaseClass {
	
	public PimPage(WebDriver driver) {

		this.driver=driver;

	}
	
	//for entering section
	 By pim = By.id("menu_pim_viewPimModule");

	//for addEmployee function
	 By addEmployee = By.id("menu_pim_addEmployee");
	 By firstName=By.id("firstName");
	 By lastName=By.id("lastName");
	 By employeeId=By.id("employeeId");
	 By checkBox=By.id("chkLogin");
	 By userName=By.id("user_name");
	 By userPassword=By.id("user_password");
	 By rePassword=By.id("re_password");
	 By saveEmployee = By.id("btnSave");

	//for delete function
	 By deleteEmployee=By.id("btnDelete");
     By deleteCheckBox=By.id("ohrmList_chkSelectRecord_13");
	 By dialogDelete=By.id("dialogDeleteBtn");

	//for varifySearch button
     By searchEmployee=By.name("_search");

	//for photoUpload function
     By updatePhoto=By.id("btnSave");
	 By chooseEmployee=By.xpath("//a[@href='/orangehrm-4.9/symfony/web/index.php/pim/viewEmployee/empNumber/1']");

	public void addEmployee() throws Exception
	{
		String listOfAddEmployee=readconfig.listOfAddEmployee();
		
		FileInputStream file=new FileInputStream(listOfAddEmployee);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRow=sheet.getLastRowNum();
		System.out.println(noOfRow);
		for(int row=1;row<=noOfRow;row++) 
		{
			findElement(pim).click();
			findElement(addEmployee).click();

			XSSFRow current_row=sheet.getRow(row);

			findElement(firstName).click();
			String Firstname=current_row.getCell(0).getStringCellValue();
			String Lastname=current_row.getCell(1).getStringCellValue();
			String Employeeid=current_row.getCell(2).getStringCellValue();
			String Username=current_row.getCell(3).getStringCellValue();
			String Password=current_row.getCell(4).getStringCellValue();
			String Repassword=current_row.getCell(5).getStringCellValue();

			findElement(firstName).click();
			findElement(firstName).sendKeys(Firstname);
			logger.info("Firstname entered");

			findElement(lastName).click();
			findElement(lastName).sendKeys(Lastname);
			logger.info("Lastname entered");

			findElement(employeeId).click();
			findElement(employeeId).sendKeys(Employeeid);
			logger.info("Employee ID provided");

			findElement(checkBox).click();

			findElement(userName).click();
			findElement(userName).sendKeys(Username);
			logger.info("Username provided");

			findElement(userPassword).click();
			findElement(userPassword).sendKeys(Password);
			logger.info("password entered");

			findElement(rePassword).click();
			findElement(rePassword).sendKeys(Repassword);

			findElement(saveEmployee).click();
			logger.info("Employee saved Succesfully");
		}
	}

	public void pim() throws Exception{

		findElement(pim).click();
	}
	public void deleteCheckBox() throws Exception{

		findElement(deleteCheckBox).click();
	}
	public void deleteEmployee() throws Exception{

		findElement(deleteEmployee).click();
		logger.warn("Delete dialogue box appears to choose and data deleted successfully");
		findElement(dialogDelete).click();

	}

    public  boolean verifySearch()throws Exception {
		
    	findElement(pim).click();
		findElement(searchEmployee).click();
		return true;
    }

	public void addPhoto() throws Exception{
		
		Screen screen=new Screen();

		findElement(pim).click();
		findElement( chooseEmployee).click();
		logger.info("select the name of the employee");

		findElement(By.id("empPic")).click();
		findElement(By.id("photofile")).click();

		String boxPath=readconfig.boxPath();
		String openBoxPath=readconfig.openBoxPath();
		String  photoPath=readconfig.photoPath();
		
	    Pattern imageOne=new Pattern(boxPath);
		Pattern imageTwo=new Pattern(openBoxPath);

	    screen.type(imageOne,photoPath);
		screen.click(imageTwo);
		findElement(updatePhoto).click();

	}
	
}