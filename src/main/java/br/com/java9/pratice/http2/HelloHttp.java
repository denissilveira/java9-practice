package br.com.java9.pratice.http2;

import static jdk.incubator.http.HttpClient.newHttpClient;
import static jdk.incubator.http.HttpRequest.newBuilder;
import static jdk.incubator.http.HttpResponse.BodyHandler.asString;

import java.net.URI;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class HelloHttp {

    // acrescentar  --add-modules jdk.incubator.httpclient  como argumento da VM
    
	public static void main(String[] args) throws Exception {
		
		URI uri = new URI("https://turini.github.io/livro-java-9/");

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest request = 
			HttpRequest.newBuilder().uri(uri).GET().build();

		HttpResponse<String> response = 
			httpClient.send(request, HttpResponse.BodyHandler.asString());

		System.out.println("http version: " + response.version());
		System.out.println("status code: " + response.statusCode());
		System.out.println("content: " + response.body());

		// encadeado e com static imports
		HttpResponse<String> responses = newHttpClient().send(
		newBuilder()
		  .uri(new URI("https://turini.github.io/livro-java-9/"))
		  .GET().build()
		, asString());
	}
}