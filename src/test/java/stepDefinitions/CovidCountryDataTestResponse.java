package stepDefinitions;

import com.restapi.utilities.SpecBuilder;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.collectapi.corona.pojo.CountryCovidData;
import com.collectapi.corona.pojo.CovidMain;
import com.collectapi.utilities.*;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import java.util.List;

//***************************************************************************************************************************************************
//The class containing the response step definitions of Covid Data API
//****************************************************************************************************************************************************
public class CovidCountryDataTestResponse
{
	BaseStepData baseStepData;
	
	public CovidCountryDataTestResponse(BaseStepData baseStepData)
	{
		this.baseStepData = baseStepData;
	}	
	
		
	@And("^I verify the status code as \"([^\"]*)\"$")
	public void verifyStatusCode(String code)
	{		
		baseStepData.response.then().statusCode(StatusCode.valueOf(code).getCode());		
		
	}
	@And("^I verify the status message as \"([^\"]*)\"$")
	public void verifyStatusMsg(String message)
	{		
		ExtentCucumberAdapter.addTestStepLog("The status messase on hitting the API with invalid token is " + baseStepData.response.asString());
		Assert.assertTrue(baseStepData.response.asString().trim().equalsIgnoreCase(message), "The message for unathorized access is not as expected");
		
	}
	@Then("^I retrieve the covid history data for \"([^\"]*)\"$")
	public void getCovidResponseData_Country(String country)
	{		
		boolean b_found=false;
		baseStepData.covidMainObj= baseStepData.response.then().spec(SpecBuilder.buildResSpec()).extract().as(CovidMain.class);
		System.out.println("the results is success + " + baseStepData.covidMainObj.isSuccess());
		
		Assert.assertEquals(baseStepData.covidMainObj.isSuccess(), true, "The endpoint" + baseStepData.api_end_point + " is invalid");
		
		baseStepData.covid_countryList = baseStepData.covidMainObj.getResults();		
		System.out.println("|Country  |  TotalCases |  NewCases |  TotalDeaths  | New Deaths |  TotalRecovered  |  ActiveCases");
		ExtentCucumberAdapter.addTestStepLog("|Country  |  TotalCases |  NewCases |  TotalDeaths  | New Deaths |  TotalRecovered  |  ActiveCases");		
		for(CountryCovidData countryCovidData : baseStepData.covid_countryList)
		{		
			if(countryCovidData.getCountry().equalsIgnoreCase(country))
			{
				b_found = true;
				System.out.println("|" + countryCovidData.getCountry()+"  |  " + countryCovidData.getTotalCases() + " |  " + countryCovidData.getNewCases() + "  |  "  + countryCovidData.getTotalDeaths() + " |   " + countryCovidData.getNewDeaths() + " |   " + countryCovidData.getTotalRecovered() + "  |  " + countryCovidData.getActiveCases()) ;					
				ExtentCucumberAdapter.addTestStepLog("|" + countryCovidData.getCountry()+"  |  " + countryCovidData.getTotalCases() + " |  " + countryCovidData.getNewCases() + "  |  "  + countryCovidData.getTotalDeaths() + " |   " + countryCovidData.getNewDeaths() + " |   " + countryCovidData.getTotalRecovered() + "  |  " + countryCovidData.getActiveCases()) ;				
				break;				 					
			}
							
		}
		Assert.assertTrue(b_found, "The country " + country + " is not found in the results");				
	}
	
	@Then("^I retrieve the values for field \"([^\"]*)\"$")
	public void getCovidResponseData_Country_filterByField(String field)
	{		
		String field_value = SpecBuilder.getJSONString(baseStepData.response, "result."+field);
		System.out.println("The value of the field name " + field+ " is " + field_value);	
		ExtentCucumberAdapter.addTestStepLog("The value of the field name " + field+ " is " + field_value);
		
	}
	@Then("^I retrieve the covid history data for all countries$")
	public void getCovidResponseDataAll()
	{				
		baseStepData.covidMainObj= baseStepData.response.then().spec(SpecBuilder.buildResSpec()).extract().as(CovidMain.class);
		System.out.println("the results is success + " + baseStepData.covidMainObj.isSuccess());
		Assert.assertEquals(baseStepData.covidMainObj.isSuccess(), true, "The endpoint" + baseStepData.api_end_point + " is invalid");
		List<CountryCovidData> covid_countryList = baseStepData.covidMainObj.getResults();
		System.out.println("|Country  |  TotalCases |  NewCases |  TotalDeaths  | New Deaths |  TotalRecovered  |  ActiveCases");
		ExtentCucumberAdapter.addTestStepLog("|Country  |  TotalCases |  NewCases |  TotalDeaths  | New Deaths |  TotalRecovered  |  ActiveCases");
		for(CountryCovidData countryCovidData : covid_countryList)
		{					
			System.out.println("|" + countryCovidData.getCountry()+"  |  " + countryCovidData.getTotalCases() + " |  " + countryCovidData.getNewCases() + "  |  "  + countryCovidData.getTotalDeaths() + " |   " + countryCovidData.getNewDeaths() + " |   " + countryCovidData.getTotalRecovered() + "  |  " + countryCovidData.getActiveCases()) ;					
			ExtentCucumberAdapter.addTestStepLog("|" + countryCovidData.getCountry()+"  |  " + countryCovidData.getTotalCases() + " |  " + countryCovidData.getNewCases() + "  |  "  + countryCovidData.getTotalDeaths() + " |   " + countryCovidData.getNewDeaths() + " |   " + countryCovidData.getTotalRecovered() + "  |  " + countryCovidData.getActiveCases()) ;
							
		}		
		
	}
	@Then("^I verify the error message \"([^\"]*)\" is displayed$")
	public void verifyErrorMessageText(String error_message)
	{				
		baseStepData.covidMainObj= baseStepData.response.then().spec(SpecBuilder.buildResSpec()).extract().as(CovidMain.class);
		System.out.println("the results is success + " + baseStepData.covidMainObj.isSuccess());
		ExtentCucumberAdapter.addTestStepLog("The invalid endpoint is " + baseStepData.api_end_point);
		Assert.assertEquals(baseStepData.covidMainObj.isSuccess(), false, "The endpoint" + baseStepData.api_end_point + " is invalid");				
		System.out.println("The message displayed in API is " + baseStepData.covidMainObj.getMessage());		
		ExtentCucumberAdapter.addTestStepLog("The error message on hitting the API is " + baseStepData.covidMainObj.getMessage());
		Assert.assertTrue(baseStepData.covidMainObj.getMessage().contains(error_message), "The error message " + error_message + " is not displayed as expected " );
	}
}
