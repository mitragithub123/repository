package endpoints;

public class Routes {
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	//User module
	public static String postUrl = baseUrl + "/user";
	public static String getUrl = baseUrl + "/user/{username}";
	public static String putUrl = baseUrl + "/user/{username}";
	public static String deleteUrl = baseUrl + "/user/{username}";
	public static String loginUrl = baseUrl + "/user/login";
	public static String logoutUrl = baseUrl + "/user/logout";
	
	//Store module
	public static String storePostUrl = baseUrl + "/store/order";
	public static String storeGetUrl = baseUrl + "/store/order/{orderId}";
	public static String storeDeleteUrl = baseUrl + "/store/order/{orderId}";

}
