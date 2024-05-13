package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class TestGetMethod {
	@Test
	public void testCase01() {
		Response rs = get("https://reqres.in/api/users?page=2");
		System.out.println("Response: " + rs.asPrettyString());
		System.out.println("Status code: " + rs.getStatusCode());
		System.out.println("Response body: " + rs.getBody());
		System.out.println("Response time: " + rs.getTime());
		System.out.println("Response header: " + rs.getHeader("Content-Type"));

		int actualStatusCode = rs.getStatusCode();
		Assert.assertEquals(200, actualStatusCode);
	}

	@Test
	public void testCase02() {
		baseURI = "https://reqres.in/api/users";
		given()
			.queryParam("page", 2)
		.when()
			.get()
		.then()
			.statusCode(201);
	}
}
