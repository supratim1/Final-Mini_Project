package com.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import common.*;

public class LoginPage extends BaseClass {

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By usernameTextBox = By.name("txtUsername");
	private By passwordTextBox = By.name("txtPassword");
	private By loginButton = By.id("btnLogin");

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
	
	public void findWelcome() throws Exception
	{
		findElement(By.id("txtUsername"));
	}

}