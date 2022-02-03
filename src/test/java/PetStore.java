
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


class PetStore {


	//
	@Test
	public void firstGetTest(){
	RestAssured.
	     when().get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending").
	     then().assertThat().statusCode(200);
	}

	@Test
	public void secondPostTest() throws JSONException {
		JSONObject requestBody = new JSONObject();
		requestBody.put("username", "kitkat");
		requestBody.put("firstName", "Kitty");
		requestBody.put("lastName", "Cat");
		requestBody.put("Email", "123@gmail.com");
		requestBody.put("password", "kitty");
		requestBody.put("phone", "911");
		requestBody.put("userStatus", 0);

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(requestBody.toString());
		Response response = request.post("https://petstore.swagger.io/v2/user");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}



	@Test
	public void thirdPutTest() throws JSONException {
		JSONObject requestBody = new JSONObject();
		requestBody.put("username", "NOkitkat");

		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(requestBody.toString());
		Response response = request.put("https://petstore.swagger.io/v2/user/kitkat");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void fourthDeleteTest(){
		RestAssured.
				when().delete("https://petstore.swagger.io/v2/user/NOkitkat").
				then().assertThat().statusCode(200);
	}
}
