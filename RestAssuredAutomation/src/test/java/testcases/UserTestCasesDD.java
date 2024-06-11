package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;
import utilities.DataProviders;

public class UserTestCasesDD {

	@Test(priority = 1, dataProvider = "AllData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String userId, String UserName, String fname, String lname, String email, String pwd,
			String phone) {
		User userPayload = new User();

		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(phone);
		Response response = UserEndPoints.createUser(userPayload);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testGetUserData(String username) {
		Response response = UserEndPoints.getUser(username);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 3, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testUpdateUserData(String UserName) {
		User userPayload = new User();
		userPayload.setUsername(UserName);
		Response response = UserEndPoints.updateUser(UserName, userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4, dataProvider = "UserNamesData", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {
		Response response = UserEndPoints.deleteUser(username);
		System.out.println("Delete User Data.");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("User Data deleted...");

	}

	@Test(priority = 5, dataProvider = "UserCredentialsData", dataProviderClass = DataProviders.class)
	public void verifyUserLoginWithBasicAuth(String UserName, String password) {
		User userPayload = new User();
		userPayload.setEmail(UserName);
		userPayload.setPassword(password);
		Response response = UserEndPoints.userLogin(UserName, password);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("User logged out...");
	}

	@Test(priority = 6)
	public void verifyUserLogout() {
		Response response = UserEndPoints.userLogout();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("User logged out...");
	}

}
