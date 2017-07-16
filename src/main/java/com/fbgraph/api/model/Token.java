package com.fbgraph.api.model;

import java.util.Date;

public class Token {

	private String access_token;
	private String token_type;
	private Date expires_in;
	
	public Token(String accessToken, String tokenType){
		this.access_token = accessToken;
		this.token_type = tokenType;
		
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public Date getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Date expires_in) {
		this.expires_in = expires_in;
	}
	
	
}
