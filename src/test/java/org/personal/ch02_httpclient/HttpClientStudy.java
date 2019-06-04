package org.personal.ch02_httpclient;

import org.junit.Test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * 下面的类是不能运行的，因为没有实际的那些网站，但是明显是告诉我们不再需要apache 的东西了。
 */
public class HttpClientStudy {

	@Test
	public void testCase01() throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder().uri(URI.create("http://www.163.com")).GET().build();
		var client = HttpClient.newHttpClient();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}

	@Test
	public void testCase02() {
		var request = HttpRequest.newBuilder().uri(URI.create("http://www.163.com")).build();
		var client = HttpClient.newHttpClient();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
				.thenApply(HttpResponse::body)
				.thenAccept(System.out::println);
	}

	@Test
	public void testCase03() throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
				.uri(URI.create("http://www.163.com"))
				.header("Content-Type", "text/plain")
				.POST(HttpRequest.BodyPublishers.ofString("Hi there!"))
				.build();
		var client = HttpClient.newHttpClient();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());      // 200
	}

	@Test
	public void testCase04() throws IOException, InterruptedException {
		var request = HttpRequest.newBuilder()
				.uri(URI.create("https://postman-echo.com/basic-auth"))
				.build();
		var client = HttpClient.newBuilder()
				.authenticator(new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("postman", "password".toCharArray());
					}
				})
				.build();
		var response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());      // 200
	}
}
