package MyAPI;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Files.Payload;
public class ValidateResponse {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().body(new String (Files.readAllBytes(Paths.get("C:\\Users\\Admin\\Desktop\\addbook.Json")))).
		when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200)
				.header("Server", equalTo("Apache"));

	}

}
