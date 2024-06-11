package endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

public class UserEndPoints2 {
	
	public static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("Routes");//Load Routes.properties
		return routes;
		
	}
	
	public static Response createUser(User payload) {
		String post_url = getUrl().getString("post_url");
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.body(payload)
							.when()
								.post(post_url);				
		return response;

	}
	
	public static Response getUser(String userName) {
		String get_url = getUrl().getString("get_url");
		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("username", userName)
							.when()
								.get(get_url);
		return response;
		
	}
	
	public static Response updateUser(String userName, User payload) {
		String put_url = getUrl().getString("update_url");
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.pathParam("username", userName)
								.body(payload)
							.when()
								.put(put_url);				
		return response;

	}
	
	public static Response deleteUser(String userName) {
		String del_url = getUrl().getString("delete_url");
		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("username", userName)
							.when()
								.delete(del_url);
		return response;
	}
	
	public static Response userLogin(String userName, String password) {
		String lgn_url = getUrl().getString("login_url");
		Response response = given()
                				.auth().basic("your_username", "your_password")
                				.contentType(ContentType.JSON)
                			.when()
                				.get(lgn_url);
        return response;
    }
	
	public static Response userLogout() {
		String lgout_url = getUrl().getString("logout_url");
		Response response = given()
                				.contentType(ContentType.JSON)
                			.when()
                				.get(lgout_url);
        return response;
    }

}
