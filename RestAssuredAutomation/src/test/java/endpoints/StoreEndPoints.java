package endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.Store;


public class StoreEndPoints {
	public static Response createStore(Store payload) {
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.body(payload)
							.when()
								.post(Routes.storePostUrl);				
		return response;

	}
	
	public static Response getStoreOrder(int orderId) {
        Response response = given()
                                .accept(ContentType.JSON)
                                .pathParam("orderId", orderId)
                            .when()
                                .get(Routes.storeGetUrl);
        return response;
    }
	
	 public static Response deleteOrder(int orderId) {
	        Response response = given()
	                                .accept(ContentType.JSON)
	                                .pathParam("orderId", orderId)
	                            .when()
	                                .delete(Routes.storeDeleteUrl);
	        return response;
	    }
}
