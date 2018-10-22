import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import groovyjarjarantlr.Parser;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class App {

	public static void main(String[] args) throws ParseException {
		manipulation();
	}
	
	
// [{"id":1,"accountNumber":"dsfd","firstname":"Chris","surname":"Perrins"},{"id":2,"accountNumber":"k","firstname":"k","surname":"k"},{"id":52,"accountNumber":"C1002","firstname":"christoph","surname":"perrrrins"}]
// to Chris, k and Christoph.
	public static void manipulation() throws ParseException {	
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8080/accounts");
		String string = response.asString();
		System.out.println(string);
		JSONParser parser = new JSONParser(); 
	
		JSONArray jsonArray = (JSONArray) parser.parse(string);
		for (Object object : jsonArray) { //array is made up of objects
			JSONObject jsonObject = (JSONObject) parser.parse(object.toString()); //turn the object to a string which is then parsed to JSONObject
			
			System.out.println(jsonObject.get("firstname")); // from this jsonObject get the firstname key, and print all values
		}
	}
}

