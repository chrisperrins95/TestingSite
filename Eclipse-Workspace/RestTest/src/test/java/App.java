import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class App {

		@Test
		public void getMethod () {
		RequestSpecification request = RestAssured.given();
		Response response = request.get("http://localhost:8080/accounts");
		response.then().statusCode(200);
		}
		
		@Test
		public void postMethod() {
			RequestSpecification request = RestAssured.given();
			
			
			request.header("Content-Type", "application/json");
			
			JSONObject requestParams = new JSONObject();
			requestParams.put("firstname", "christoph");
			requestParams.put("surname", "perrrrins");
			requestParams.put("accountNumber", "C1002");
			
			request.body(requestParams);
			
			
			Response response = request.post("http://localhost:8080/accounts");
			response.then().statusCode(200);
		}
		
		@Test
		public void deleteMethod() {
			RequestSpecification request = RestAssured.given();
			
			Response response = request.delete("http://localhost:8080/accounts/51");
			
			response.then().statusCode(200);
		}
}
