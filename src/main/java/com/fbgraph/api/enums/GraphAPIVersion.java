package com.fbgraph.api.enums;

public enum GraphAPIVersion {

	VERSION_2_9("v2.9"),VERSION_2_8("v2.8"),VERSION_2_7("v2.8"),VERSION_2_6("v2.6");
	private String version;
	
	public String getVersion(){
		return this.version;
	}
	
	private GraphAPIVersion(String version){
		this.version = version;
	}
	
}
