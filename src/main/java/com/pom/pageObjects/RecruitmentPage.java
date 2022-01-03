package com.pom.pageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.BaseClass;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class RecruitmentPage extends BaseClass {
	
	
	public RecruitmentPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver,this);//initialize elements
	}

	@FindBy(id="candidateSearch_candidateName")
	WebElement candidatename;

	@FindBy(id="candidateSearch_status")
	WebElement statusbox;

	@FindBy(id="btnSrch")
	WebElement search;

	@FindBy(id="btnRst")
	WebElement reset;

	@FindBy(name="btnAdd")
	WebElement addbutton;

	@FindBy(name="addCandidate[firstName]")
	WebElement firstname;

	@FindBy(name="addCandidate[lastName]")
	WebElement lastname;

	@FindBy(name="addCandidate[email]")
	WebElement email;

	@FindBy(xpath="//*[@id=\"addCandidate_email\"]")
	WebElement email1;

	@FindBy(id="btnSave")
	WebElement save;

	@FindBy(name="btnDelete")
	WebElement delete;

	@FindBy(id="menu_recruitment_viewCandidates")
	WebElement candidates;

	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	WebElement Recruit;

	@FindBy(xpath="//input[@id='ohrmList_chkSelectRecord_5_']")
	WebElement checkbox;

	@FindBy(xpath="//input[@type='checkbox'and contains (@name='chkSelectRow[]')]")
	WebElement checkboxall;

	@FindBy(id="dialogDeleteBtn")
	WebElement confirm;

	@FindBy(id="ohrmList_chkSelectAll")
	WebElement checkall;

	public boolean verifyReset() throws Exception{
        
		String candidate = readconfig.getCandidate();
		Recruit.click();
		candidatename.click();
		candidatename.sendKeys(candidate);
		reset.click();

		return true;

	}

	public void addEmployees() throws Exception {

		String filepath = readconfig.getFilepath();
		
		FileInputStream file=new FileInputStream(filepath);
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int noOfRow=sheet.getLastRowNum();

		for(int row=1;row<=noOfRow;row++) {
			XSSFRow current_row=sheet.getRow(row);
			logger.info("Successfully read data");
			System.out.println(row);
			Recruit.click();
			candidates.click();
			addbutton.click();
			String FirstName = current_row.getCell(0).getStringCellValue();
			logger.info("firstname read successfully");
			String LastName=current_row.getCell(1).getStringCellValue();
			logger.info("lastname read successfully");
			String Email_ID=current_row.getCell(2).getStringCellValue();
			logger.info("email read successfully");
			firstname.click();
			firstname.sendKeys(FirstName);
			lastname.click();
			lastname.sendKeys(LastName);
			email.click();
			email.sendKeys(Email_ID);
			save.click();
		}
	}

	public void takeScreenshot() throws IOException  {

		WebElement logo=driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img"));
		Screenshot logoimage=new AShot().takeScreenshot(driver,logo);
		ImageIO.write(logoimage.getImage(),"PNG",new File(System.getProperty("user.dir")+"\\Screenshots\\screenshotElement"));
		File f= new File(System.getProperty("user.dir")+"\\Screenshots\\screenshotElement");
		if( f.exists())
		{
			Assert.assertTrue(true);
			logger.info("image captured");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("image not captured");
		}
	}

	public void compareScreenshot() throws IOException {

		BufferedImage expectedImage=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\screenshotElement"));
		WebElement logo=driver.findElement(By.xpath("//*[@id=\"branding\"]/a[1]/img"));
		Screenshot logoimage=new AShot().takeScreenshot(driver,logo);
		BufferedImage actualImage=logoimage.getImage();

		ImageDiffer imagediff=new ImageDiffer();
		ImageDiff diff = imagediff.makeDiff(expectedImage, actualImage);

		if(diff.hasDiff()==true)//THIS WILL COMPARE 2 images
		{
			logger.info("Images are not same");
		}
		else
		{
			logger.info("Images are same");
		}

	}

}


