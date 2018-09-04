package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.FileReaderManager;
import pageObjects.CampaignPage;
import testdatatypes.Customer;

public class CampaignPageSteps {

	TestContext testcontext;
	CampaignPage Camp;
	Customer customer  = FileReaderManager.getInstance().getjsondatareader().getCustomerByname();

	public CampaignPageSteps(TestContext context) {

		testcontext = context;
		Camp = testcontext.getPageObjectmanager().getCampaignPage();

	}

	@When("^Click For Campaign$")
	public void click_For_Campaign() {
		
		Camp.clickcampaign();

	}

	@Then("^Enter Campaign Name$")
	public void enter_Campaign_Name() {
    
	Camp.EnterCampaignName(customer);
	}

	@Then("^Select NewsletterName$")
	public void select_NewsletterName() throws Exception {

       Camp.SelectNewsLetter(customer);	
	}

}
