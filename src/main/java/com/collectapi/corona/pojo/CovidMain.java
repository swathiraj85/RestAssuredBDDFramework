package com.collectapi.corona.pojo;

import java.util.List;

//  ***************************************************************************************************************************************************
// The class is designed based on the principles of Builder  pattern to construct the object to provide control over the construction process.
// The setter methods returns an instance of current object to make way for calling other methods without object reference.
// *****************************************************************************************************************************************************
// The Request/Response payload is represented as POJO class
//  *****************************************************************************************************************************************************
public class CovidMain 
{
private boolean success;
private List<CountryCovidData> result;
private String code;
private String message;

public boolean isSuccess() {
	return success;
}

public List<CountryCovidData> getResults() {
	return result;
}

public CovidMain setResults(List<CountryCovidData> result) {
	this.result = result;
	return this;
} 

public String getCode() {
	return code;
}

public String getMessage() {
	return message;
}

}
