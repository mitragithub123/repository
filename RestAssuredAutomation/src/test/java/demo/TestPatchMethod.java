package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPatchMethod {
	@Test
	public void testCase03() {
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "siku");
		jsonData.put("job", "Dev");
		RestAssured.baseURI="https://reqres.in/api/users/190";
		RestAssured
			.given()
				.header("content-type", "application/json")
				.contentType(ContentType.JSON)
				.body(jsonData.toJSONString())
			.when()
				.patch()
			.then()
				.statusCode(200).log().all();

	}
}
