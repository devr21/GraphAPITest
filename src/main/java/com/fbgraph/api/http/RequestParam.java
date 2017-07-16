package com.fbgraph.api.http;

public class RequestParam {

	private String paramName;
	private String paramValue;
	
	RequestParam(){
		
	}
	
	public RequestParam(String paramName, String paramValue){
		this.paramName = paramName;
		this.paramValue = paramValue;

	}
	
	public String getParamValue() {
		return paramValue;
	}
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
}
