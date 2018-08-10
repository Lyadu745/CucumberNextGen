package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/FunctionalTests",
		glue  = {"stepDefinitions"},
		tags = {"@SmokeTest","~@RegressionTest"},
	//	plugin = {"pretty","json:target/cucumber-reports/Report1.json","junit:target/cucumber-reports/Report2.xml","html:target/cucumber-reports"},
		dryRun = false,
		monochrome = true
		)

public class Testrunner
{
		                                 
}