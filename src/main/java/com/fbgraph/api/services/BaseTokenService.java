package com.fbgraph.api.services;

import com.fbgraph.api.interfaces.TokenService;
import com.fbgraph.api.model.Token;


public abstract class BaseTokenService implements TokenService{

	protected boolean isTokenValid(Token token){
		String accessToken = token.getAccessToken();
		return accessToken.isEmpty() || accessToken == null?false:true;
	}
	
	protected boolean isTokenExpired(Token token){
		return false;
	}
	
}
