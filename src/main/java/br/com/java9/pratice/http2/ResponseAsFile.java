package br.com.java9.pratice.http2;

import java.net.URI;
import java.nio.file.Paths;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

public class ResponseAsFile {

	public static void main(String[] args) throws Exception {
		
		HttpClient.newHttpClient()	
	.sendAsync(HttpRequest.newBuilder()		
		.uri(new URI("https://turini.github.io/livro-java-9/books.csv"))		
		.GET().build(), 		
		HttpResponse.BodyHandler.asFile(Paths.get("books.csv")))
	.whenComplete((r,t) -> 
		System.out.println("arquivo salvo em: "+ r.body().toAbsolutePath()));
	}
}