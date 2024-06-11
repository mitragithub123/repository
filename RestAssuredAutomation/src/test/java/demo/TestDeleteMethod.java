package demo;

import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class TestDeleteMethod {
	@Test
	public void testCase05() {
		RestAssured.baseURI="https://reqres.in/api/users/190";
		RestAssured
			.given()
			.when()
				.delete()
			.then()
				.statusCode(204).log().all();

	}
}
