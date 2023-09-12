import static io.restassured.RestAssured.given;

import java.awt.desktop.SystemSleepEvent;
import java.util.List;

import javax.crypto.spec.ChaCha20ParameterSpec;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.Serialization_Deserialization;
import pojo.Webautomation;
public class oAuthTest {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		String url = "https://rahulshettyacademy.com/getCourse.php?state=fstsfst&code=4%2F0Adeu5BV8srnUT-Rw2z0LioZBAlx7D6ALqcDFC-1aXQnjjG1JP7vXTBxIK-XuQN0mNO4a8w&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none";
		String partialcode = url.split("code=")[1];
		String code = partialcode.split("&scope")[0];
		System.out.println(code);
		
		System.out.println("this is suresh");

		String AccessToken = given().urlEncodingEnabled(false)
				.queryParams("code",code)
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token")
		.asString();
		JsonPath js = new JsonPath(AccessToken);
	String Token = js.getString("access_token");
		System.out.println(Token);
		
		//
		
		Serialization_Deserialization Response = given().queryParam("access_token",Token).expect().defaultParser(Parser.JSON) // you can avoid if content-type is JSON 
				.when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(Serialization_Deserialization.class);
		//System.out.println(Response);
		
		System.out.println(Response.getLinkedIn());
		//System.out.println(Response.getLinkedIn());
		
		List<Api> coursetitle = Response.getCourses().getApi();
		for (int i=0;i<coursetitle.size();i++) {
			
			if(coursetitle.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
				System.out.println(coursetitle.get(i).getPrice());
			}
		}
	List<Webautomation>	 web = Response.getCourses().getWebAutomation();
		for (int i=0;i<coursetitle.size();i++) {
			System.out.println(web.get(i).getCourseTitle());
		}
	}

}
