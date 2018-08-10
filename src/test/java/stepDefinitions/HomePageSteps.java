package stepDefinitions;



import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.FileReaderManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testdatatypes.Customer;

public class HomePageSteps {
	
	TestContext testcontext;
	LoginPage loginn;
	HomePage home;
	
	
	public HomePageSteps(TestContext context)
	{
		testcontext = context;
		loginn = testcontext.getPageObjectmanager().getLoginPage();
		home = testcontext.getPageObjectmanager().getHomePage();
		
	}
	
	@Given("^User is on Login Page$")
	public void user_is_on_Login_Page() {
	
	loginn.loginpage();
	}
	
	@When("^User Enters Bad Credentials$")
	public void user_Enters_Bad_Credentials()  {
		
	    home.details();
	    home.click();
	}
	
	@When("^User enters \\\"(.*)\\\" and password$")
	public void user_enters_UserName_and_password(String username)  {
		//home = new HomePage(driver);
		System.out.println(username);
		Customer customer = FileReaderManager.getInstance().getjsondatareader().getCustomerByname(username);
		home.details(customer);
	  }
	
	@Then("^User perform click on login$")
	public void user_perform_click_on_login()  {
          
	 	 home.click();
	}
	
}