package com.fbgraph.api.services;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import com.fbgraph.api.exceptions.AccessTokenExpiredException;
import com.fbgraph.api.exceptions.InvalidTokenException;
import com.fbgraph.api.exceptions.TokenException;
import com.fbgraph.api.http.RequestParam;
import com.fbgraph.api.http.interfaces.HttpService;
import com.fbgraph.api.model.User;


@Named
@Singleton
public class TokenService extends BaseTokenService{

	@Inject
	private HttpService httpService;
	
	public String getToken(User user) throws TokenException {
		
		if(isTokenValid(user.getToken()) || !isTokenExpired(user.getToken()))
			return user.getToken().getAccessToken();
		else if(isTokenExpired()) throw new AccessTokenExpiredException("Token has expired on "+user.getToken().getExpiryDate());
		else throw new InvalidTokenException("Token is Invalid");
	}

	public void getAccessTokenFromFB(String code,User user) {
		
		httpService.makeGetRequest(facebookOauthURL, getParamList(code,user));
	}
	
	private List<RequestParam> getParamList(String code,User user) {
		List<RequestParam> params = new ArrayList<RequestParam>();
		params.add(new RequestParam("code",code));
		params.add(new RequestParam("redirect_uri", REDIRECT_URI+"/"+user.getUserId().toString()));
		params.add(new RequestParam("client_id", clientId));
		params.add(new RequestParam("client_secret", clientSecret));
		return params;
	}

	public void renewToken() {
		// TODO Auto-generated method stub
		
	}

	public boolean isTokenExpired() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
