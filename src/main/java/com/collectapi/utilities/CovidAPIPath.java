package com.collectapi.utilities;


//***************************************************************************************************************************************************
// The enum containing the Covid Data API endpoints
//****************************************************************************************************************************************************
public enum CovidAPIPath {
BASEPATH("/corona/countriesData");
	
private String path_value;

	private CovidAPIPath(String path)
	{
		this.path_value = path;
	}
	public String getAPIPath()
	{
		return path_value;
	}
}
