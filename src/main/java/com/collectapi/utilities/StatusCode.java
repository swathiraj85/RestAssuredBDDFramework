package com.collectapi.utilities;

//***************************************************************************************************************************************************
//   The enum containing the response status code for api calls
//****************************************************************************************************************************************************
public enum StatusCode {
	     CODE_200(200, "OK"),
	    CODE_400(400, "Missing required field: name"),
	    CODE_401(401, "Unauthorized"),
	    CODE_500(500,"Internal Server Error");
		

	    private int status_code;
	    public String status_msg;

	    StatusCode(int status_code, String status_msg) {
	        this.status_code = status_code;
	        this.status_msg = status_msg;
	    }

	   public int getCode(){
	        return status_code;
	    }

	    public String getMsg(){
	        return status_msg;
	    }
}
