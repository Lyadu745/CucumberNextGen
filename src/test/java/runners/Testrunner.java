package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import manager.FileReaderManager;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/FunctionalTests/Task.feature",
		glue  = {"stepDefinitions"},
		tags = {"~@SmokeTest","~@RegressionTest","@New"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
	//	plugin = {"pretty","json:target/cucumber-reports/Report1.json","junit:target/cucumber-reports/Report2.xml","html:target/cucumber-reports"},
		dryRun = false,
		monochrome = true
		)

public class Testrunner
{
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigreader().getextentreports()));
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
		                                 
}