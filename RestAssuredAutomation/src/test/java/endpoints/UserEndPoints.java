package endpoints;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

public class UserEndPoints {
	
	public static Response createUser(User payload) {
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.body(payload)
							.when()
								.post(Routes.postUrl);				
		return response;

	}
	
	public static Response getUser(String userName) {
		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("username", userName)
							.when()
								.get(Routes.getUrl);
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload) {
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)
							.when()
								.put(Routes.putUrl);				
		return response;

	}
	
	public static Response deleteUser(String userName) {
		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("username", userName)
							.when()
								.delete(Routes.deleteUrl);
		return response;
	}
	
	public static Response userLogin(String userName, String password) {
		Response response = given()
                				.auth().basic("your_username", "your_password")
                				.contentType(ContentType.JSON)
                			.when()
                				.get(Routes.loginUrl);
        return response;
    }
	
	public static Response userLogout() {
		Response response = given()
                				.contentType(ContentType.JSON)
                			.when()
                				.get(Routes.logoutUrl);
        return response;
    }

}
