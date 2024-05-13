package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonREsponseBody {
	@Test
	public void getSingleUser() {
		RequestSpecification rspec = RestAssured.given();
		rspec.baseUri("https://reqres.in");
		rspec.basePath("/api/users/2");

		Response response = rspec.get();
		ResponseBody resBody = response.getBody();
		String resString = resBody.asPrettyString();
		System.out.println("Response Body: " + resString);

		Assert.assertEquals(resString.contains("Janet"), true, "Check for Janet fails");
		
		
	}

}
