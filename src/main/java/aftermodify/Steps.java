package aftermodify;






import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import manager.FileReaderManager;
import manager.PageObjectManager;
import manager.WebdriverManager;
import pageObjects.EmailingLandingPage;
import pageObjects.HomePage;

public class Steps {
	HomePage home;
	EmailingLandingPage Elp;
	WebDriver driver;
	WebElement ele;
	PageObjectManager pageobjectmanager;
	WebdriverManager wb;
	
	//ConfigFileReader configfile;

	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() {
		
//		System.setProperty("webdriver.chrome.driver",FileReaderManager.getInstance().getConfigreader().getDriverPath());
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		wb = new WebdriverManager();
		driver = wb.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigreader().geturl());
		//driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigreader().getimplicitwait(), TimeUnit.SECONDS);
		pageobjectmanager = new PageObjectManager(driver);
		home = pageobjectmanager.getHomePage();
		

	}

	@When("^User enters UserName and password$")
	public void user_enters_UserName_and_password()  {
		//home = new HomePage(driver);
		home.details(null);
	    
	  
	}

	@Then("^User perform click on login$")
	public void user_perform_click_on_login()  {
          
	 	 home.click();
	}
	
	@When("^Project Landing Page Opens$")
	public void project_Landing_Page_Opens()  {
     System.out.println(driver.getCurrentUrl());
		
	}

	@Then("^User click on Newsletter$")
	public void user_click_on_Newsletter(){
	//Elp = new EmailingLandingPage(driver);
	  Elp = pageobjectmanager.getEmailLandingPage();
		Elp.clickNewsletter();
	}
    
	@Then("^User click on Campaigns$")
	public void user_click_on_Campaigns() {
	   Elp.clickCampaigns();
	 	}
	@And("^Click on Segments")
	public void click_on_Segments() throws Throwable {
		Elp.Segments();
	   
	}
	@And("^Click on Reports$")
	public void click_on_Reports()  {
	   Elp.reports();
	}

	@And("^Click on Trigger$")
	public void click_on_Trigger(){
	 Elp.trigger();
	}

	@And("^Click on Planning Module$")
	public void click_on_Planning_Module()  {
	 Elp.pm();
	}

	@And("^Click on Schedule Campaign$")
	public void click_on_Schedule_Campaign()  {
	Elp.sc();
	}

	@And("^Click on Settings$")
	public void click_on_Settings() {
	 Elp.settings();
	}



}
