package stepDefinitions;

import java.util.List;

import com.collectapi.corona.pojo.CountryCovidData;
import com.collectapi.corona.pojo.CovidMain;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//***************************************************************************************************************************************************
// The common fields that needs to be shared across multiple step definitions are specified in this class and utilized in the dependent classes using
//  dependency injection
//****************************************************************************************************************************************************

public class BaseStepData {

	protected RequestSpecification request_spec;
	protected ResponseSpecification response_spec;
	protected Response response;
	protected ValidatableResponse json;
	protected String api_end_point;
	protected String api_token;
	protected CovidMain  covidMainObj;
	protected List<CountryCovidData> covid_countryList;
	
}
