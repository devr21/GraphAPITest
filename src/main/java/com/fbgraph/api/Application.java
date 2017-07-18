package com.fbgraph.api;

import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.EncodingFilter;

import com.fbgraph.api.resources.IndexResource;
import com.fbgraph.api.resources.UserResource;


public class Application extends ResourceConfig{

	public Application(){
		packages("com.fbgraph.api.resources");
		register(IndexResource.class);
		register(UserResource.class);
		register(EntityFilteringFeature.class);
		EncodingFilter.enableFor(this, GZipEncoder.class);
	}
	
}
