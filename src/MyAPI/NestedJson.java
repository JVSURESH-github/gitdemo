package MyAPI;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.path.json.JsonPath;

public class NestedJson {

	public static void main(String[] args) {
		
	JsonPath js = ReusableMethods.rawtojson(Payload.nestedJson());
	// Print Purchase Amount
	int amount = js.getInt("dashboard.purchaseAmount");
	System.out.println("Purchase Amount: " + amount);
	
	//Print website name
	String website = js.getString("dashboard.website");
	System.out.println("website name: " + website);
	
	//Print no of courses
	int count = js.getInt("courses.size()");
	System.out.println("Total courses in response: "+ count);
	
	//Print 1st course Title
	String title = js.getString("courses[0].title");
	System.out.println("1st course Title: "+ title);
	
	//Print all course titles
	
	for (int i=0;i<count;i++) {
		String title1 = js.get("courses["+i+"].title");
		System.out.println( title1);
		
		
	}
	 // Print no of copies sold by RPA course
	for (int i=0;i<count;i++) {
		String title1 = js.get("courses["+i+"].title");
		if (title1.equals("RPA") ) {
			
			int copies = js.get("courses["+i+"].copies");
			System.out.println(copies);
			
			
			
	}
	}
	
	
	
	
	}

}
