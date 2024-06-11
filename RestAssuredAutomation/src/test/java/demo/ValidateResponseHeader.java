package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class ValidateResponseHeader {
	@Test(enabled=false)
	public void getSingleUser() {
		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("https://reqres.in");
		rspec.basePath("/api/users/2");

		Response response = rspec.get();

		String connection = response.getHeader("Connection");
		System.out.println("Value of connection: " + connection);

		Headers headers = response.getHeaders();
		for (Header header : headers) {
			System.out.println(header.getName() + ": " + header.getValue());

		}
		Assert.assertEquals(connection, "keep-alive", "Header key and value mismatch");
	}
	
	/* ----------------BDD Style------------------------- */
	
	@Test
	public void getSingleUserUsingBddStyle() {
		RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users/2";

        Response response = RestAssured
            .given()
            .when()
                .get()
            .then()
                .statusCode(200)
                .header("Connection", equalTo("keep-alive"))// Import equalTo from Hamcrest Matchers
                .extract().response();

        System.out.println("All Response Headers:");
        response.getHeaders().forEach((header) -> {
            System.out.println(header.getName() + ": " + header.getValue());
        });
	}
	

}
