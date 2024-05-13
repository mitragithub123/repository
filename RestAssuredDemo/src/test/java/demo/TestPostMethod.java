package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPostMethod {
	@Test
	public void testCase03() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "mitra bhanu");
		jsonData.put("job", "QA");
		RestAssured.baseURI="https://reqres.in/api/users";
		RestAssured
			.given()
				.header("content-type", "application/json")
				.contentType(ContentType.JSON)
				.body(jsonData.toJSONString())
			.when()
				.post()
			.then()
				.statusCode(201).log().all();

	}
}
