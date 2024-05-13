package demo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestPutMethod {
	@Test
	public void testCase04() {
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
				.put()
			.then()
				.statusCode(200).log().all();

	}
}
