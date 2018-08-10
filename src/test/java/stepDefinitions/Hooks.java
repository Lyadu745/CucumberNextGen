package stepDefinitions;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.TestContext;
import cucumber.api.Scenario;
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
	  Reporter.assignAuthor("Lalit Yadu");
   }
   @After(order = 1)
   public void TakeScrshot(Scenario scenario) {
	   if(scenario.isFailed()) {
		   
		   String screenshotname = scenario.getName().replaceAll("", "_");
		   try {
		   
		   File scr = ((TakesScreenshot)testcontext.getWebdrivermanager().getDriver()).getScreenshotAs(OutputType.FILE);
		   File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotname + ".png");
			
		   Files.copy(scr, destinationPath);
		   
		   Reporter.addScreenCaptureFromPath(destinationPath.toString());
		   
		   
		   
		   }catch (IOException e) {
			
		}
	   }
	   
   }
   
   @After(order = 0)
   public void AfterEveryScenario() {
	   wb.closedriver();
	   System.out.println("Browser Closed");
   }

}
