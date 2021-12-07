package stepDefinitions;

import com.collectapi.utilities.*;
import com.restapi.utilities.ConfigSupplier;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

//***************************************************************************************************************************************************
// The class containing the request step definitions of Covid Data API
//****************************************************************************************************************************************************
public class CovidCountryDataTestRequest
{
	BaseStepData baseStepData;
	
	public CovidCountryDataTestRequest(BaseStepData baseStepData)
	{
		this.baseStepData = baseStepData;
	}	
	
	@Given("^I set the GET endpoint of COVID REST API$")
	public void setGETPath()
	{
		baseStepData.api_end_point = ConfigSupplier.getInstance().getBaseURI() + CovidAPIPath.valueOf("BASEPATH").getAPIPath();
		baseStepData.api_token = ConfigSupplier.getInstance().getAPIToken();
		baseStepData.request_spec = CollectAPIUtils.getCovidAPIRequestHeader(baseStepData.api_end_point,baseStepData.api_token);
	}
	
	@And("^I provide an invalid endpoint \"([^\"]*)\"$")
	public void setInvalidEndPoint(String invalid_endpoint)
	{
		baseStepData.api_end_point = ConfigSupplier.getInstance().getBaseURI() +   invalid_endpoint;
		baseStepData.request_spec = CollectAPIUtils.getCovidAPIRequestHeader(baseStepData.api_end_point,baseStepData.api_token);
				
		
	}
	@And("^I set the token value as \"([^\"]*)\"$")
	public void setInvalidToken(String invalid_token)
	{
		baseStepData.api_token = invalid_token;
		baseStepData.request_spec = CollectAPIUtils.getCovidAPIRequestHeader(baseStepData.api_end_point,baseStepData.api_token);
				
		
	}
		
	@And("^I set the query parameter for \"([^\"]*)\" as \"([^\"]*)\"$")
	public void setQueryParam(String param_name,String param_value)
	{
		baseStepData.request_spec = baseStepData.request_spec.queryParam(param_name, param_value);
				
		
	}
	@And("^I send Get HTTP request$")
	public void sendGetHTTP()
	{		
		baseStepData.response = baseStepData.request_spec.when().
				                     get(baseStepData.api_end_point);
				
		
	}	
}
