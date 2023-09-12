package Section7;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Dynamic {

	@Test(dataProvider = "booksdata")
	public void addbook(String isbn , String aisle) {
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().header("Content-Type","application/json").body(Payload.addbook(""+isbn+"",""+aisle+"")).
		when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js = ReusableMethods.rawtojson(response);
		String id = js.get("ID");
		System.out.println(id);
	}
		// Test NG dataprovider
		//Helps us to do parameterization
	//how to connect dataprovider and method write @Test(DataProvider="booksdata") 
	@DataProvider(name="booksdata")
	public Object[][] getData() 
	{
		// what is array : collection of elements array[]={1,2}
		// what is Multi dimensinal array : Collection of arrays array[][]={{1,1},{2,3}}
		
		//new object[][] {array1,array2,....arrayn};
		
		return new Object[][] {{"papa","1231"},{"mama","1011"},{"bb","11"}};
	
	}
}
