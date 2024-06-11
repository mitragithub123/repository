package demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBearerToken {
	/* ---------https://gorest.co.in/----------------- */
	@Test
	public void bearerToken() {
		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("https://gorest.co.in");
		rspec.basePath("/public/v2/users");

		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "mitra bhanu");
		jsonData.put("gender", "male");
		jsonData.put("email", "aryaaish.2011@gmail.com");
		jsonData.put("status", "Active");

		String requestBody = jsonData.toJSONString();

		String authToken = "Bearer 8a5143b59016b71416de37f942f30a50385c1a13cff75e9312330c6daa5dac1a";

		rspec.header("Authorization", authToken).contentType(ContentType.JSON).body(requestBody);

		Response response = rspec.post();

		System.out.println("Status line: " + response.statusLine());
		System.out.println("Status line: " + response.body().asPrettyString());
		Assert.assertEquals(response.statusCode(), 201, "Invalid status code returned");
	}
}
