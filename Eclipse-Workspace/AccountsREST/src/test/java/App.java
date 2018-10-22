import org.json.simple.JSONObject;
//import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class App {

	public static void main(String[] args) {
		getMethod();
		postMethod();
//		deleteMethod();
	}
	
	public static void getMethod () {
	RequestSpecification request = RestAssured.given();
	Response response = request.get("http://localhost:8080/accounts");
	response.prettyPrint();
	}
	
	public static void deleteMethod() {
		RequestSpecification request = RestAssured.given();
		
		Response response = request.delete("http://localhost:8080/accounts/39");
		
		System.out.println(response.getStatusCode());

	}
	
	public static void postMethod() {
		RequestSpecification request = RestAssured.given();
		
		
		request.header("Content-Type", "application/json");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("firstname", "christoph");
		requestParams.put("surname", "perrrrins");
		requestParams.put("accountNumber", "C1002");
		
		request.body(requestParams);
		
		
		Response response = request.post("http://localhost:8080/accounts");
		
	}
	
	
}
