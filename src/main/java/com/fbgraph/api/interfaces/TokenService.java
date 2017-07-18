package com.fbgraph.api.interfaces;

import com.fbgraph.api.exceptions.TokenException;
import com.fbgraph.api.model.User;

public interface TokenService{

	String getToken(User user) throws TokenException;
	User getAccessTokenFromFB(String code,User user);
	void renewToken();
	public String getGraphAPIURI();
	
}
