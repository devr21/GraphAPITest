package com.fbgraph.api.services;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.fbgraph.api.interfaces.TokenService;
import com.fbgraph.api.model.Token;

@Configuration
@PropertySource(value={"classpath:graphapitest.properties"})
public abstract class BaseTokenService implements TokenService{
	
	@Inject
	private Environment env;
	
	protected String facebookOauthURL;
	protected String clientId;
	protected String clientSecret;
	protected final String REDIRECT_URI = "/service/receivetoken";
	
	@PostConstruct
	public void init(){
		facebookOauthURL = env.getProperty("facebookOauthURL");
		clientId = env.getProperty("clientId");
		clientSecret = env.getProperty("clientSecret");
	}
	
	protected boolean isTokenValid(Token token){
		String accessToken = token.getAccessToken();
		return accessToken.isEmpty() || accessToken == null?false:true;
	}
	
	protected boolean isTokenExpired(Token token){
		return false;
	}
	
}
