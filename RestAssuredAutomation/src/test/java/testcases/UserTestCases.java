package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;

public class UserTestCases {
	Faker faker;
	User userPayload;
	public static Logger logger = LogManager.getLogger(UserTestCases.class);

	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}

	@Test(priority = 1)
	public void verifyCreateUser() {
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Create User executed...");
		logger.info("**Create User executed**");
	}

	@Test(priority = 2)
	public void verifyGetUser() {
		Response response = UserEndPoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Get User Data executed...");
	}

	@Test(priority = 3)
	public void verifyUpdateUser() {
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

		Response responseAfterUpdate = UserEndPoints.getUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		System.out.println("After Update User Data...");
	}

	@Test(priority = 4)
	public void verifyDeleteUser() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("User Data deleted...");
	}

	@Test(priority = 5)
	public void verifyUserLoginWithBasicAuth() {
		Response response = UserEndPoints.userLogin(this.userPayload.getUsername(), this.userPayload.getPassword());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("User logged in...");
	}

	@Test(priority = 6)
	public void verifyUserLogout() {
		Response response = UserEndPoints.userLogout();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("User logged out...");
	}

}
