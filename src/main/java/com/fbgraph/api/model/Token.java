package com.fbgraph.api.model;

import java.util.Date;

public class Token {

	private String accessToken;
	private String tokenType;
	private Date expiryDate;
	
	public Token(String accessToken, String tokenType, Date expiryDate){
		this.accessToken = accessToken;
		this.tokenType = tokenType;
		this.expiryDate = expiryDate;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
	
}
