package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	@Test(enabled=false)
	public void getSingleUser() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		RequestSpecification rspec = RestAssured.given();
		Response response = rspec.get();
		
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200, "Incorrect status code received");
		
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status line received");
	}

	/*------------------- or--------------------------------- */
	@Test(enabled=false)
	public void getSingleUserUsingValidatableResponse() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";
		
		RequestSpecification rspec = RestAssured.given();
		Response response = rspec.get();
		
		ValidatableResponse validRes=response.then();
		validRes.statusCode(200);
		validRes.statusLine("HTTP/1.1 200 OK");
	}
	
	/* ----------------BDD Style------------------------- */
	@Test
	public void getSingleUserUsingBddStyle() {
		RestAssured
			.given()
			.when()
				.get("https://reqres.in/api/users/2")
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK");
		
	}
	
	
	
	
	
	
	
	

}
