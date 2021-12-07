package com.restapi.utilities;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

//***************************************************************************************************************************************************
//  The Specification Builder class to build the common request & response specification for API's
//****************************************************************************************************************************************************

public class SpecBuilder {

	public static RequestSpecification req_spec;
	public static ResponseSpecification resp_spec;

//
// ****************************************************************
//  The Request specification builder method
// ****************************************************************

	public static RequestSpecification buildReqSpec()
	{
		return  new RequestSpecBuilder().setBaseUri(ConfigSupplier.getInstance().getBaseURI())			
				.log(LogDetail.ALL)
				.build();	
	}
//	
// ****************************************************************
//  The Response specification builder method
// ****************************************************************
	public static ResponseSpecification buildResSpec()
	{
		return  new ResponseSpecBuilder().						
				log(LogDetail.ALL).expectContentType(ContentType.JSON)				
				.build();	
	}
//	
// ****************************************************************
//  The method to convert API response to JSONString
// ****************************************************************
	public static String getJSONString(Response response, String key) {
		
		JsonPath path = new JsonPath(response.asString());
		return path.get(key).toString();

	}
//	
// ****************************************************************
//  The method to convert POJO Object to JSONString
// ****************************************************************
	public static String getJSONFromPOJO(Object object)
	{
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(object);			
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}
		return jsonInString;
	}
	
//	
// ****************************************************************
//  The method to specify path param
// ****************************************************************
	public static RequestSpecification setPathParam(String param_name,String param_value)
	{
		return buildReqSpec().pathParam(param_name, param_value);
	}
	
//	
// ****************************************************************
//  The method to specify query param
// ****************************************************************
	public static RequestSpecification setQueryParam(String param_name,String param_value)
	{
		return buildReqSpec().queryParam(param_name, param_value);
	}
	
}
