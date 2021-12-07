package com.collectapi.utilities;

import static io.restassured.RestAssured.given;

import com.restapi.utilities.SpecBuilder;

import io.restassured.specification.RequestSpecification;

//***************************************************************************************************************************************************
//   The class containing the Covid Data API utilities
//****************************************************************************************************************************************************
public class CollectAPIUtils
{
	public static RequestSpecification getCovidAPIRequestHeader(String path,String api_token)
	{
    return given(SpecBuilder.buildReqSpec())			
			.header("Content-Type","application/json")
			.header("authorization", "apiKey " + api_token);
		    
	}
	
	
}
