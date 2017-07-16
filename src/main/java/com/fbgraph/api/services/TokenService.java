package com.fbgraph.api.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.fbgraph.api.exceptions.AccessTokenExpiredException;
import com.fbgraph.api.exceptions.InvalidTokenException;
import com.fbgraph.api.exceptions.TokenException;
import com.fbgraph.api.http.RequestParam;
import com.fbgraph.api.http.interfaces.HttpService;
import com.fbgraph.api.model.Token;
import com.fbgraph.api.model.User;


@Named
@Singleton
@Configuration
@PropertySource(value={"classpath:graphapitest.properties"})
public class TokenService extends BaseTokenService{

	@Inject
	private Environment env;
	@Inject
	private HttpService httpService;
	protected String facebookOauthURL;
	protected String clientId;
	protected String clientSecret;
	protected final String REDIRECT_URI = "https://daevgraphapitest.herokuapp.com/service/result?scope=user_friends,email,user_birthday,user_education_history,user_photos,user_relationships,user_about_me";
	
	@PostConstruct
	public void init(){
		facebookOauthURL = env.getProperty("facebookOauthURL");
		clientId = env.getProperty("clientId");
		clientSecret = env.getProperty("clientSecret");
	}
	
	public String getToken(User user) throws TokenException {
		
		if(isTokenValid(user.getToken()) || !isTokenExpired(user.getToken()))
			return user.getToken().getAccess_token();
		else if(isTokenExpired()) throw new AccessTokenExpiredException("Token has expired on "+user.getToken().getExpires_in());
		else throw new InvalidTokenException("Token is Invalid");
	}

	public User getAccessTokenFromFB(String code,User user) {
		
		String response = httpService.makeGetRequest(facebookOauthURL, getParamList(code,user));
		
		Token token = mapJsonResponse(response);
		user.setToken(token);
		return user;
	}
	
	private Token mapJsonResponse(String response) {
		Token token = null;
		if(response != null || !response.isEmpty()){
			JSONObject object = new JSONObject(response);
			token = new Token(object.getString("access_token").toString(),object.getString("token_type").toString());
		}
		System.out.println("TOKEN TOKEN TOKEN TOKEN: "+token);
		return token;
	}

	private List<RequestParam> getParamList(String code,User user) {
		List<RequestParam> params = new ArrayList<RequestParam>();
		params.add(new RequestParam("code",code));
		params.add(new RequestParam("redirect_uri", REDIRECT_URI));
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
