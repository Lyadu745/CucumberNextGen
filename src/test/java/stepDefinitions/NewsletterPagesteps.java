package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.FileReaderManager;
import pageObjects.NewsletterPage;
import testdatatypes.Customer;

public class NewsletterPagesteps {
	
	TestContext testcontext;
	NewsletterPage Npage;
	Customer customer = FileReaderManager.getInstance().getjsondatareader().getCustomerByname();


	public NewsletterPagesteps(TestContext context)
	{
		testcontext = context;
		Npage = testcontext.getPageObjectmanager().getNewsletterpage();
				
	}
	
	@Then("^CLick for Newsletter$")
	public void click_for_Newsletter() {
		Npage.clickonNews();
		
	}
	@Then("^Enter Newsletterdetails And Save Newsletter$")
	public void enter_Newsletterdetails_And_Save_Newsletter() throws Exception {
	Npage.enterdetails(customer);
	}
	@When("^User click on View Newsletter$")
	public void user_click_on_View_Newsletter() {
		 Npage.clickonviewNewsletter(customer);
	    
	}

}
