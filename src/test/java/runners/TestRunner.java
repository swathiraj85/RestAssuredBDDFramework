package runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features= {"src/test/resources"},
		tags= {"@get_covid_api"},
		glue= {"stepDefinitions"},
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-report.json"}

		)
public class TestRunner extends AbstractTestNGCucumberTests
{
//	
//  ***************************************************************************************************************************************************
//    The cucumber test scenarios are enabled to run in parallel mode by overriding the scenarios method
//  *****************************************************************************************************************************************************
	@Override
	@DataProvider(parallel=false)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
//	
//  ***************************************************************************************************************************************************
//    The extent report configuration is setup 
//  *****************************************************************************************************************************************************
	@BeforeClass
	public static void reportConfiguration()
	{
		System.setProperty("extent.reporter.html.start", "true");
		System.setProperty("extent.reporter.html.config", "src/test/resources/config/extent-config.xml");
		System.setProperty("extent.reporter.html.out", "ExtentReports/SWBExtentReport.html");
	}
	
	@AfterClass
	public static void writeExtentReport()
	{
		
	}
}
