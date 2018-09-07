package stepDefinitions;

import java.awt.AWTException;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.FileReaderManager;
import pageObjects.CampaignPage;
import testdatatypes.Customer;

public class CampaignPageSteps {

	TestContext testcontext;
	CampaignPage Camp;
	Customer customer = FileReaderManager.getInstance().getjsondatareader().getCustomerByname();

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

	@And("^Select NewsletterName$")
	public void select_NewsletterName() throws Exception {

		Camp.SelectNewsLetter(customer);
	}

	@Then("^Click on Live Time$")
	public void click_on_Live_Time() throws Throwable {
		Camp.ClickonLiveTime();
	}

	@And("^Select Segmentt Name$")
	public void select_Segmentt_Name() throws Exception  {
		Camp.selSegment(customer);
	}

	@And("^Click on fetch count$")
	public void click_on_fetch_count() {
		Camp.fetchcount();
	}
	@And("^Select Domain$")
	public void select_Domain()  {
		Camp.SelDomain(customer);
	    
	}

	@And("^Select Domain Name$")
	public void select_Domain_Name() throws Exception  {
	    Camp.selDomainname(customer);
	}

	@And("^Select Campaign type$")
	public void select_Campaign_type() {
	    Camp.selcamptype(customer);
	}

	@And("^Enter Max Volume Cap$")
	public void enter_Max_Volume_Cap()throws Exception {
	    Camp.entermaxcap(customer);
	}
	@And("^Schedule Rtos$")
	public void schedule_Rtos() throws AWTException {
		Camp.ScheduleRTOs(customer);
	}
	


}
