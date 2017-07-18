package com.fbgraph.api.model;

import java.util.UUID;

public class User {

	private Token token;
	private UUID userId;
	private String dataFromFb;
	
	public String getDataFromFb() {
		return dataFromFb;
	}

	public void setDataFromFb(String dataFromFb) {
		this.dataFromFb = dataFromFb;
	}

	public User(){
		this.userId = UUID.randomUUID();
	}
	
	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}
	
	
	
}
