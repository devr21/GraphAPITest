package com.fbgraph.api.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;
import org.springframework.stereotype.Component;

@Component
@Path("/")	
public class IndexResource{

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
    public Response result() {
        return Response.ok(new Viewable("/result")).build();
    }
	
}
