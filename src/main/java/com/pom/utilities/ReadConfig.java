package com.pom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties property;

	public ReadConfig() 
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream file = new FileInputStream(src);
			property = new Properties();
			property.load(file);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() 
	{
		String url=property.getProperty("baseURL");
		return url;
	}

	public String getUsername() 
	{
		String username=property.getProperty("username");
		return username;
	}

	public String getPassword() 
	{
		String password=property.getProperty("password");
		return password;
	}

	//invalid credentials or password provided
	public String getWrongPassword() 
	{
		String password=property.getProperty("password1");
		return password;
	}
	
	public String getChromePath() 
	{
		String chromepath=property.getProperty("chromepath");
		return chromepath;
	}

	public String getIEPath() 
	{
		String iepath=property.getProperty("iepath");
		return iepath;
	}

	public String getFirefoxPath() 
	{
		String firefoxpath=property.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getCaption() 
	{
		String caption=property.getProperty("caption");
		return caption;
	}
	
	public String getComment() 
	{
		String comment=property.getProperty("comment");
		return comment;
	}
	
	public String getShareCaptions() 
	{
		String shareCaptions=property.getProperty("shareCaptions");
		return shareCaptions;
	}
	
	public String getEditMessage() 
	{
		String editMessage=property.getProperty("editMessage");
		return editMessage;
	}
	
	public String getDeleteMessage() 
	{
		String deleteMessage=property.getProperty("deleteMessage");
		return deleteMessage;
	}
	
	public String getBuzzURL() 
	{
		String url=property.getProperty("buzzSectionURL");
		return url;
	}
	
	public String getHomeUrl()
	{
		String url=property.getProperty("homeURL");
		return url;
	}
	
	public String Fileread() 
	{
		String path=property.getProperty("filepath");
		return path;
	}
	
	public String getName()
	{
		String employeeName=property.getProperty("employeeName");
		return employeeName;
	}
	
	public String getNationality()
	{
		String nationality=property.getProperty("nationality");
		return nationality;
	}
	public String getCountry()
	{
		String nation=property.getProperty("nation");
		return nation;
	}
	public String boxPath() 
	{
		String boxPath=property.getProperty("boxpath");
		return boxPath;
	}
	public String openBoxPath() 
	{
		String openBoxPath=property.getProperty("openboxpath");
		return openBoxPath;
	}
	public String photoPath() 
	{
		String photoPath=property.getProperty("photopath");
		return photoPath;
	}
	public String listOfAddEmployee()
	{
		String listOfAddEmployee=property.getProperty("excelpath");
		return listOfAddEmployee;
	}
	
	public String getLoginpath()
	{
		String loginspath=property.getProperty("loginspath");
		return loginspath;
	}
	
	public String getFilepath()
	{
		String filepath=property.getProperty("filepath");
		return filepath;
	}
	
	public String getCandidate()
	{
		String candidate=property.getProperty("candidate");
		return candidate;
	}
	
	
}
