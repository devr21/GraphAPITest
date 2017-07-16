package com.fbgraph.api.http.interfaces;

import java.util.List;
import com.fbgraph.api.http.RequestParam;

public interface HttpService {

	String makeGetRequest(String url,List<RequestParam> paramList);
	
}
