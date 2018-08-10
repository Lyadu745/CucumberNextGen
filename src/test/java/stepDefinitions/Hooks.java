package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import manager.WebdriverManager;

public class Hooks {

	TestContext testcontext;
	WebdriverManager wb;
	
	
   public Hooks(TestContext context)
   {
	   testcontext = context;
	      wb = testcontext.getWebdrivermanager();
   }
   
   @Before
   public void BeforeEveryScenario() {
	   System.out.println("Scenario started Executing");
   }
   @After
   public void AfterEveryScenario() {
	   wb.closedriver();
	   System.out.println("Browser Closed");
   }

}
