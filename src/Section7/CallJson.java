package Section7;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class CallJson {

	public static void main(String[] args) throws IOException {
		// content to file to string
		// To do that content of file and convert into byte then convert to String
		//Files.readAllBytes(Paths.get("c:\\desktop")) => It will read bytes
		// new String(Files.readAllBytes(Paths.get("c:\\desktop"))) => it converts to string
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").body(new String(Files.readAllBytes(Paths.get("C:\\Users\\Admin\\Desktop\\addplace.Json")))).
		when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response().asString(); 
		// extract().response().as String() will save the response as a string in a variable

		System.out.println(response);
		
		// Class JsonPath take 
		
		JsonPath js = new JsonPath(response); // Which take string as input and Convert to Json and it will help to parse the Json
		String PlaceId = js.getString("place_id"); // Fetch Place Id to update 
		System.out.println(PlaceId);
		

	}

}
