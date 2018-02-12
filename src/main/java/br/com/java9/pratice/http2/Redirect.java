package br.com.java9.pratice.http2;

import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class Redirect {

	public static void main(String[] args) throws Exception {
		
		HttpClient.newBuilder()
		  .followRedirects(HttpClient.Redirect.SECURE)
		  .version(HttpClient.Version.HTTP_2)
		  .build()	
		  .send(HttpRequest.newBuilder()				
			.uri(new URI("https://google.com/"))				
			.GET()
			.build(), 	
		  HttpResponse.BodyHandler.asString()).body();
	}
}