package Section8JIRAServerAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import Files.ReusableMethods;
public class firstAPI {

	public static void main(String[] args) {
		
		 RestAssured.baseURI  = "http://localhost:8080";
		 String response =given().log().all().header("content-type","application/json").
		body("{ \"username\": \"Jayavarapusuresh\", \"password\": \"MYLIFE@2022@\" }").when().post("rest/auth/1/session").then().log().all().extract().response().asString();
		System.out.println(response);
		
		JsonPath js1 = ReusableMethods.rawtojson(response);
	String SessionID = 	js1.getString("session.value");
	System.out.println(SessionID);

	}

}
