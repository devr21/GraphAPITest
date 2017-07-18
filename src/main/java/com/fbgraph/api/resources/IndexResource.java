package com.fbgraph.api.resources;


import java.util.HashMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;

import com.fbgraph.api.interfaces.TokenService;
import com.fbgraph.api.interfaces.UserDB;
import com.fbgraph.api.model.Token;
import com.fbgraph.api.model.User;


@Component
@Path("/")	
public class IndexResource{

	
	@Inject
	private TokenService tokenService; 
	
	@Inject
	private UserDB userService;
	
	@Path("/homie")
	@GET
	public Response getIndex(){
		return Response.ok("Hey Homie How you doin? ;)").build();
	}
	
	@GET
    @Produces("text/html")
    public Response index() {
        return Response.ok(new Viewable("/index")).build();
    }
	
	@GET
	@Path("/fb_login")
    @Produces("text/html")
    public Response fbLogin() {
        return Response.ok(new Viewable("/fb_login")).build();
    }
	
	@GET
	@Path("/result")
    @Produces("text/html")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Response result(Token token,@QueryParam("code") String code,
    		@QueryParam("error") String error,@QueryParam("error_code") int errorCode,
    		@QueryParam("error_description") String errorDescription,@QueryParam("error_reason") String errorReason) {
	
		if(error == null)	{
			User user = new User();
			user = tokenService.getAccessTokenFromFB(code,user);
			HashMap<String, User> model = new HashMap<String, User>();
			model.put("user",user);
			return Response.ok(new Viewable("/success",model)).build();
		}
		else{
			return Response.ok(new Viewable("/denied")).build();
		}
    }
	
}
