package com.fbgraph.api.resources;

import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;

import com.fbgraph.api.interfaces.TokenService;
import com.fbgraph.api.interfaces.UserService;
import com.fbgraph.api.model.Token;
import com.fbgraph.api.model.User;


@Component
@Path("/")	
public class IndexResource{

	
	@Inject
	private TokenService tokenService; 
	
	@Inject
	private UserService userService;
	
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
    public Response result(@QueryParam("code") String code,
    		@QueryParam("error") String error,@QueryParam("error_code") int errorCode,
    		@QueryParam("error_description") String errorDescription,@QueryParam("error_reason") String errorReason) {
		
		if(error == null)	{
			User user = new User();
			tokenService.getAccessTokenFromFB(code,user);
			return Response.ok(user.getToken().getAccessToken()).build();
		}
		else{
			return Response.ok(new Viewable("/denied")).build();
		}
    }
	
	@POST
	@Path("/receivetoken/{userid}/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/html")
	public Response receiveToken(Token token,@PathParam("userid") String userId){
		userService.setToken(UUID.fromString(userId),token);
		return Response.ok(new Viewable("/home")).build();
	}
	
}
