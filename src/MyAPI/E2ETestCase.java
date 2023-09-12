package MyAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;

import Files.Payload;
import Files.ReusableMethods;

public class E2ETestCase {

	
	public static void main(String[] args) {
		// Add Place , Update Palace , Get PLace API 
		// Add Place 
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().queryParam("key", "qaclick123").body(Payload.addplace()).
		when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString(); 
		// extract().response().as String() will save the response as a string in a variable

		System.out.println(response);
		
		// Class JsonPath take 
		
		JsonPath js = new JsonPath(response); // Which take string as input and Convert to Json and it will help to parse the Json
		String PlaceId = js.getString("place_id"); // Fetch Place Id to update 
		System.out.println(PlaceId);
		
		// Update Place by Using above place Id.
		String NewAddress = "Testing";
		given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId).
		body("{\r\n"
				+ "\"place_id\":\""+PlaceId+"\",\r\n"
				+ "\"address\":\""+NewAddress+"\",\r\n" // Updated Address as Testing 
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}").when().put("maps/api/place/update/json").then().log().all();
		
		//Get Place Using same Place Id and Validate the Response.
		
		String response1 = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", PlaceId).when().get("maps/api/place/get/json").
		then().extract().response().asString();
		JsonPath js1 = ReusableMethods.rawtojson(response1); // Which take string as input and Convert to Json and it will help to parse the Json
		String ActualAddress = js1.getString("address"); // Fetch Place Id to update 
		System.out.println(ActualAddress);
		Assert.assertEquals(ActualAddress , "Test");
		
		
	}

}
