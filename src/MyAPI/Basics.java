package MyAPI;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class Basics {

	public static void main(String[] args) {
		RestAssured.baseURI = "http://216.10.245.166";
		given().log().all().body("{\r\n"
				+ "\"name\":\"j v s1\",\r\n"
				+ "\"isbn\":\"jvs1\",\r\n"
				+ "\"aisle\":\"2023\",\r\n"
				+ "\"author\":\"suresh\"\r\n"
				+ "}").when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200);
   
		// TODO Auto-generated method stub

	}

}
