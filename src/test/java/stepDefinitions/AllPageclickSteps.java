
/**
 * @author Lalit
 *
 */


package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import pageObjects.EmailingLandingPage;


public class AllPageclickSteps {
	
	TestContext testcontext;
	EmailingLandingPage Elp;
	
	
	
	public AllPageclickSteps(TestContext context)
	{
		testcontext = context;
		Elp = testcontext.getPageObjectmanager().getEmailLandingPage();
		
	}
	
	
//	@When("^Project Landing Page Opens$")
//	public void project_Landing_Page_Opens()  {
//     System.out.println(driver.getCurrentUrl());
//		
//	}

	@Then("^User click on Newsletter$")
	public void user_click_on_Newsletter(){
	//Elp = new EmailingLandingPage(driver);
	 // Elp = pageobjectmanager.getEmailLandingPage();
		Elp.clickNewsletter();
		System.out.println("Newsletter Clicked");
	}
    
	@Then("^User click on Campaigns$")
	public void user_click_on_Campaigns() {
	   Elp.clickCampaigns();
	 	}
	@And("^Click on Segments$")
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
