package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import endpoints.StoreEndPoints;
import io.restassured.response.Response;
import payload.Store;

public class StoreTestCases {
	Faker faker;
	Store storePayload;

	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		storePayload = new Store();
		storePayload.setId(faker.number().randomDigit());
		storePayload.setPetId(faker.number().randomDigit());
		storePayload.setQuantity(faker.number().numberBetween(1, 10));
		storePayload.setShipDate(faker.date().future(30, java.util.concurrent.TimeUnit.DAYS));
		storePayload.setStatus("placed");
		storePayload.setComplete(faker.bool().bool());

	}

	@Test(priority = 1)
	public void verifyCreateStore() {
		Response response = StoreEndPoints.createStore(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("Create store executed...");
	}

	@Test(priority = 2)
	public void verifyGetOrder() {
		Response createResponse = StoreEndPoints.createStore(storePayload);
		createResponse.then().log().all();
		Assert.assertEquals(createResponse.getStatusCode(), 200);

		int orderId = createResponse.jsonPath().getInt("id");

		Response response = StoreEndPoints.getStoreOrder(orderId);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

		System.out.println("Get store order executed...");
		
	}

	@Test(priority = 3)
	public void verifyDeleteOrder() {
		Response createResponse = StoreEndPoints.createStore(storePayload);
		createResponse.then().log().all();
		Assert.assertEquals(createResponse.getStatusCode(), 200);

		int orderId = createResponse.jsonPath().getInt("id");

		Response deleteResponse = StoreEndPoints.deleteOrder(orderId);
		deleteResponse.then().log().all();

		Assert.assertEquals(deleteResponse.getStatusCode(), 200);

		System.out.println("Delete store order executed...");
	}
}
