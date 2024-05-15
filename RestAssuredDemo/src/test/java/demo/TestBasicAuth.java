package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBasicAuth {

	/* ---------http://postman-echo.com/basic-auth----------------- */
	@Test(enabled = false)
	public void basicAuth() {
		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("http://postman-echo.com");
		rspec.basePath("/basic-auth");

		// Response response = rspec.auth().basic("postman",
		// "password").get();//Credentials will be passed to server if it asks
		Response response = rspec.auth().preemptive().basic("postman", "password").get();// Credentials will be passed
																							// to server before it asks
		System.out.println("Status line: " + response.statusLine());
		System.out.println("Status line: " + response.body().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200, "Invalid status code returned");
	}

	/* ---------https://httpbin.org----------------- */
	@Test
	public void digestiveAuth() {
		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("https://httpbin.org");
		rspec.basePath("/digest-auth/undefined/siku/siku");

		Response response = rspec.auth().digest("siku", "siku").get();
		System.out.println("Status line: " + response.statusLine());
		System.out.println("Status line: " + response.body().asPrettyString());
		Assert.assertEquals(response.statusCode(), 200, "Invalid status code returned");
	}

}
