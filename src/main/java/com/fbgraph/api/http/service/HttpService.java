package com.fbgraph.api.http.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.inject.Named;
import javax.net.ssl.HttpsURLConnection;

import com.fbgraph.api.http.RequestParam;

@Named
public class HttpService implements com.fbgraph.api.http.interfaces.HttpService{

	public void makeGetRequest(String url, List<RequestParam> paramList) {
		
		if(!paramList.isEmpty()){
			url += "?";
			for(RequestParam param:paramList){
				url += param.getParamName() + "=" + param.getParamValue() + "&";
			}
			
			url = url.substring(0, url.lastIndexOf("&")-1);
			System.out.println(url);
		}
		URL oauthURL;
		try {
			oauthURL = new URL(url);
			HttpsURLConnection connection = (HttpsURLConnection) oauthURL.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		
	}

}
