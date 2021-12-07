package com.collectapi.corona.pojo;

//***************************************************************************************************************************************************
// The class is designed based on the principles of Builder  pattern to construct the object to provide control over the construction process..
// The setter methods returns an instance of current object to make way for calling other methods without object reference.
//*****************************************************************************************************************************************************
// The Request/Response payload is represented as POJO class
// *****************************************************************************************************************************************************
public class CountryCovidData {

	private String country;
	private String totalCases;
	private String newCases;
	private String totalDeaths;
	private String newDeaths;
	private String totalRecovered;
	private String activeCases;
	 
	public String getCountry() {
		return country;
	}
	public CountryCovidData setCountry(String country) {
		this.country = country;
		return this;
	}
	public String getTotalCases() {
		return totalCases;
	}
	public CountryCovidData setTotalCases(String totalCases) {
		this.totalCases = totalCases;
		return this;
	}
	public String getNewCases() {
		return newCases;
	}
	public CountryCovidData setNewCases(String newCases) {
		this.newCases = newCases;
		return this;
	}
	public String getTotalDeaths() {
		return totalDeaths;
	}
	public CountryCovidData setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
		return this;
	}
	public String getNewDeaths() {
		return newDeaths;
	}
	public CountryCovidData setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
		return this;
	}
	public String getTotalRecovered() {
		return totalRecovered;
	}
	public CountryCovidData setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
		return this;
	}
	public String getActiveCases() {
		return activeCases;
	}
	public CountryCovidData setActiveCases(String activeCases) {
		this.activeCases = activeCases;
		return this;
	}	
	
	
}
