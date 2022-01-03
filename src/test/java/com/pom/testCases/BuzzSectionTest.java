package com.pom.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pom.pageObjects.*;
import common.*;

public class BuzzSectionTest extends BaseClass {

	String caption = readconfig.getCaption();
	String comment = readconfig.getComment();
	String shareCaptions = readconfig.getShareCaptions();
	String editMessage = readconfig.getEditMessage();
	String deleteMessage = readconfig.getDeleteMessage();
	String buzzSectionURL = readconfig.getBuzzURL();

	BaseClass baseObj = new BaseClass();
	BuzzSectionPage buzzObj = new BuzzSectionPage(driver);
	
	//for status updating or posting functionality
	@Test(priority=1)
	public void statusUpdate() throws Exception
	{
		// Verifying the page Title
		if(driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			logger.info("Page title matches");
		}
		else
		{
			baseObj.captureScreen(driver,"BuzzSectionTest");
			Assert.assertTrue(false);
			logger.error("Page tilte do not match");
		}
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");
		
		// Verifying Url of the Buzz Section in the Application
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,buzzSectionURL);
		logger.info("Url for the Buzz Section matches");

		buzzObj.writePost(caption);
		logger.info("Post written by user");

		buzzObj.post();
		logger.info("Clicked on post Button");

		baseObj.logOut();
	}

	//Checking if like functionality is perfectly working or not
	@Test(priority=2)
	public void likePost() throws Exception
	{
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");

		buzzObj.expandView();
		logger.info("Clicked on the post to expand the view of the post");

		boolean likeButton = findElement(By.xpath("//a[@id='postLikeno_23']/img")).isEnabled();
		if(likeButton)
		{
			Assert.assertTrue(true);
			logger.info("Like Button is enabled, proceed further");
		}
		else
		{
			baseObj.captureScreen(driver,"BuzzSectionTest");
			Assert.assertTrue(false);
			logger.warn("Like Button is disabled");
		}
		buzzObj.likeAction();
		logger.info("Clicked on like button");

		baseObj.logOut();
	}

	//Checking if unlike functionality is perfectly working or not
	@Test(priority=3)
	public void unlikePost() throws Exception
	{
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");

		buzzObj.expandView();
		logger.info("Clicked on the post to expand the view of the post");

		buzzObj.unlikeAction();
		logger.info("Clicked on unlike button to unlike the post");

		baseObj.logOut();
	}

	//Checking if commentTextbox is displayed and the "Comment" button functionality is working or not
	@Test(priority=4)
	public void commentPost() throws Exception
	{
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");

		buzzObj.expandView();
		logger.info("Clicked on the post to expand the view of the post");

		boolean commentTextBox = findElement(By.id("commentBoxnew_txt_popShareId_23")).isDisplayed();
		if(commentTextBox)
		{
			Assert.assertTrue(true);
			logger.info("Comment TextBox is displayed, write your comment in the TextBox");
		}
		else
		{
			baseObj.captureScreen(driver,"BuzzSectionTest");
			Assert.assertTrue(false);
			logger.warn("Comment TextBox is not displayed");
		}
		buzzObj.writeComment(comment);
		logger.info("Comment provided by the user in the Comment TextBox");

		buzzObj.commentPress();
		logger.info("Comment button pressed by user");

		baseObj.logOut();//shift to after class..
	}

	//For checking share functionality for a chosen post
	@Test(priority=5)
	public void sharePost() throws Exception
	{
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");

		buzzObj.shareClick();
		logger.info("Clicked on Share option to select the particular post");

		buzzObj.shareAction(shareCaptions);
		logger.info("Caption for the post to be shared provided");

		buzzObj.sharePress();
		logger.info("Share button pressed by user");
		
		baseObj.logOut();
	}

	// for checking if a user can edit a post
	@Test(priority=6)
	public void editPost() throws Exception
	{
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");

		buzzObj.dropdownSelect();
		logger.info("Clicked on the dropdown list to select the post options");

		boolean editOption = findElement(By.id("editshareBox_14")).isSelected();
		if(editOption)
		{
			Assert.assertTrue(true);
			logger.info("Edit option is selected, proceed further");
		}
		else
		{
			baseObj.captureScreen(driver,"BuzzSectionTest");
			Assert.assertTrue(false);
			logger.warn("Edit option is not selected");
		}
		buzzObj.edit(editMessage);
		logger.info("Message added or changes made to the post made by the user");

		buzzObj.save();
		logger.info("Clicked on save button to update the changes to the post");

		baseObj.logOut();
	}

	// for checking if a user can delete a post
	@Test(priority=7)
	public void TC07_deletePost(String deleteMessage) throws Exception
	{ 
		baseObj.loginCommon();
		logger.info("User logged in successfully");

		buzzObj.buzzSection();
		logger.info("Navigated to the Buzz Section from the Dashboard of Home Page");

		buzzObj.dropdownSelect();
		logger.info("Clicked on the dropdown list to select the post options");

		buzzObj.delete();
		logger.info("Clicked on the delete option");
        logger.info("A dialog box/popup appeared to confirm if the user want to delete the post or discard the changes");

        Alert popup = driver.switchTo().alert();
        String alertText = popup.getText();
        System.out.println("Alert text is " + alertText);
        popup.sendKeys(deleteMessage);
        popup.accept();
        logger.info("Post deleted successfully");
        
		baseObj.logOut();
	}

}
