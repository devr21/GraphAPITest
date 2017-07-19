package com.fbgraph.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;

import com.fbgraph.api.enums.GraphAPIVersion;
import com.fbgraph.api.exceptions.NoSuchUserException;
import com.fbgraph.api.exceptions.TokenException;
import com.fbgraph.api.http.RequestParam;
import com.fbgraph.api.http.interfaces.HttpService;
import com.fbgraph.api.interfaces.TokenService;
import com.fbgraph.api.interfaces.UserDB;
import com.fbgraph.api.interfaces.UserFbService;
import com.fbgraph.api.model.User;

@Named
public class UserService implements UserFbService{

	@Inject
	private UserDB usersDB;
	
	@Inject
	private HttpService httpService;
	
	@Inject
	private TokenService tokenService;
	
	@Override
	public User fetchUserDataFromFB(String userId) throws NoSuchUserException, TokenException {
		
		User user = usersDB.getUser(userId);
		user.setDataFromFb(httpService.makeGetRequest(tokenService.getGraphAPIURI()+GraphAPIVersion.VERSION_2_9+"/me", getParams(user)));
		
		return user;
	}

	private List<RequestParam> getParams(User user) throws TokenException {
		List<RequestParam> params = new ArrayList<RequestParam>();
		RequestParam param = new RequestParam("fields", "id,name,birthday,cover,email,first_name,education,last_name,picture,photos,friends,relationship_status");
		RequestParam param1 = new RequestParam("access_token", tokenService.getToken(user));
		return params;
	}

}
