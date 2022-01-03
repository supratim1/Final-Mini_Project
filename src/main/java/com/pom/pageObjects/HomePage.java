package com.pom.pageObjects;

import org.openqa.selenium.WebDriver;
import common.*;
import org.openqa.selenium.By;

public class HomePage extends BaseClass {

	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By welcomePanel = By.id("welcome");
	private By logoutOption = By.linkText("Logout");
	private By pieChart1 = By.id("pieLabel3");
	private By pieChart2 = By.id("div_graph_display_emp_distribution");
	private By legendPanel = By.id("panel_resizable_1_1");
	private By leaveRequests = By.id("task-list-group-panel-menu_holder");
	private By quickLaunch = By.id("dashboard-quick-launch-panel-menu_holder");
	private By logo = By.xpath("//*[@id=\"branding\"]/a[1]/img");
    private By marketplace = By.id("MP_link");
    private By helpSection = By.xpath("//*[@id=\"branding\"]/a[3]/span/svg");
    private By notificationIcon = By.xpath("//*[@id=\"notification\"]/svg/path");
    
    public void welcome() throws Exception
	{
		findElement(welcomePanel).click();
	}
    public void logout() throws Exception
	{
		findElement(logoutOption).click();
	}
    public void pieChart() throws Exception
	{
		findElement(pieChart1).click();
	}
    public void pieDistribution() throws Exception
	{
		findElement(pieChart2).click();
	}
    public void legendSection() throws Exception
	{
		findElement(legendPanel).click();
	}
    public void leaveSection() throws Exception
	{
		findElement(leaveRequests).click();
	}
    public void launch() throws Exception
	{
		findElement(quickLaunch).click();
	}
    public void logoDashboard() throws Exception
	{
		findElement(logo).click();
	}
    public void marketMenu() throws Exception
   	{
   		findElement(marketplace).click();
   	}
    public void helpMenu() throws Exception
   	{
   		findElement(helpSection).click();
   	}
    public void notificationCheck() throws Exception
   	{
   		findElement(notificationIcon).click();
   	}
    
}

