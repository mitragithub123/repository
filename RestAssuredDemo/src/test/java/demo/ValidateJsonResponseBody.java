package demo;

import org.testng.Assert;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	@Test(enabled=false)
	public void getSingleUser() {
		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("https://reqres.in");
		rspec.basePath("/api/users/2");

		Response response = rspec.get();
		ResponseBody resBody = response.getBody();
//		String resString = resBody.asPrettyString();
//		System.out.println("Response Body: " + resString);

		//Assert.assertEquals(resString.contains("Janet"), true, "Check for Janet fails");

		JsonPath jsonPathView = resBody.jsonPath();
		String firstName = jsonPathView.get("data[1].first_name");
		Assert.assertEquals(firstName, "Lindsay");

	}
	
	
	@Test
    public void validateJsonResponseBodyBddStyle() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users?page=2";
        
        RestAssured
        	.given()
	        .when()
	            .get()
	        .then()
	            .statusCode(200)
	            .body("page", equalTo(2))
	            .body("per_page", equalTo(6))
	            .body("total", equalTo(12))
	            .body("total_pages", equalTo(2))
	            .body("data.size()", equalTo(6)) // Validate size of 'data' array
	            .body("data[0].id", equalTo(7))
	            .body("data[0].email", equalTo("michael.lawson@reqres.in"))
	            .body("data[0].first_name", equalTo("Michael"))
	            .body("data[0].last_name", equalTo("Lawson"))
	            .body("data[0].avatar", equalTo("https://reqres.in/img/faces/7-image.jpg"))
	            .body("support.url", equalTo("https://reqres.in/#support-heading"))
	            .body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
	    }

}
