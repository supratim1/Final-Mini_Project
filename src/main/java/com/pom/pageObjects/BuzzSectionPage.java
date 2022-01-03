package com.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import common.*;
import org.openqa.selenium.By;

public class BuzzSectionPage extends BaseClass {

	WebDriver driver;

	public BuzzSectionPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By buzzMenu = By.xpath("//a[@id='menu_buzz_viewBuzz']/b");
	private By createPost = By.id("createPost_content");
	private By postButton = By.id("postSubmitBtn");
	private By expandPost = By.id("shareViewMore_23");
	private By likeButton = By.xpath("//a[@id='postLikeno_23']/img");
	private By unlikeButton = By.id("postUnlikeLoading_14");
	private By commentTextBox = By.id("commentBoxnew_txt_popShareId_23");
	private By commentButton = By.id("commentBoxNew_popShareId_23");
	private By shareOption = By.xpath("//a[@id='postShareno_20']/img");
	private By shareCaption = By.id("shareBox_20");
	private By shareButton = By.id("btnShare_20_18");
	private By dropdownWidget = By.id("postOptionWidget");
	private By deletePost = By.id("delete-share");
	private By editPost = By.id("editshareBox_14");
	private By saveButton = By.name("btnSaveDependent");
	private By condfirmDelete = By.id("delete_discard");
	private By discardDelete =  By.id("delete_confirm");

	public void buzzSection() throws Exception
	{
		findElement(buzzMenu).click();
	}
	
	public void writePost(String caption) throws Exception
	{
		findElement(createPost).click();
		findElement(createPost).clear();	
		findElement(createPost).sendKeys(caption);
	}
	
	public void post() throws Exception
	{
		findElement(postButton).click();
	}
	
	public void expandView() throws Exception
	{
		findElement(expandPost).click();
	}
	
	public void likeAction() throws Exception
	{
		findElement(likeButton).click();
	}
	
	public void unlikeAction() throws Exception
	{
		findElement(unlikeButton).click();
	}
	
	public void writeComment(String comment) throws Exception
	{
		findElement(commentTextBox).click();
		findElement(commentTextBox).clear();
		findElement(commentTextBox).sendKeys(comment);
	}
	
	public void commentPress() throws Exception
	{
		findElement(commentButton).click();
	}
	
	public void shareClick() throws Exception
	{
		findElement(shareOption).click();
	}
	
	public void shareAction(String shareCaptions) throws Exception
	{
		findElement(shareCaption).click();
		findElement(shareCaption).clear();
		findElement(shareCaption).sendKeys(shareCaptions);
	}
	
	public void sharePress() throws Exception
	{
		findElement(shareButton).click();
	}
	
	public void dropdownSelect() throws Exception
	{
		findElement(dropdownWidget).click();
	}
	
	public void edit(String editMessage) throws Exception
	{
		findElement(editPost).click();
		findElement(editPost).sendKeys(editMessage);
	}
	
	public void save() throws Exception
	{
		findElement(saveButton).click();
	}
	
	public void delete() throws Exception
	{
		findElement(deletePost).click();
	}
	
	public void deleteConfirm() throws Exception
	{
		findElement(condfirmDelete).click();
	}
	
	public void deleteDiscard() throws Exception
	{
		findElement(discardDelete).click();
	}
	
}
