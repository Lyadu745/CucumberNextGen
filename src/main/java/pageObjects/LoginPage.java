package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;


import manager.FileReaderManager;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void loginpage()
	{
		driver.get(FileReaderManager.getInstance().getConfigreader().geturl());
		
	}
	
	  
	}



