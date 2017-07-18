package com.fbgraph.api.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.fbgraph.api.exceptions.NoSuchUserException;
import com.fbgraph.api.interfaces.UserFbService;

@Path("/user")
@Component
public class UserResource {

	@Inject
	private UserFbService userService;
	
	
	@Path("/fetchfromfb/{userId}")
	@GET
	public Response getUserDataFromFB(@PathParam("userId")String userId) throws NoSuchUserException{
		
		return Response.ok(userService.fetchUserDataFromFB(userId)).build();
	}
	
}
