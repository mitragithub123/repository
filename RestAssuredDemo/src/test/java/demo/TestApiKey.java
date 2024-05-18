package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestApiKey {
	@Test
	public void apiKey() {
		// https://api.openweathermap.org/data/2.5/weather?q=London&appid={API key}

		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("https://api.openweathermap.org");
		rspec.basePath("/data/2.5/weather");
		rspec.queryParam("q", "delhi").queryParam("appid", "84a988beca958289859db0c59d18e4de");
		
		Response response = rspec.get();
		System.out.println("Status line: " + response.statusLine());
		System.out.println("Status line: " + response.body().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200, "Invalid status code returned");

	}
}
