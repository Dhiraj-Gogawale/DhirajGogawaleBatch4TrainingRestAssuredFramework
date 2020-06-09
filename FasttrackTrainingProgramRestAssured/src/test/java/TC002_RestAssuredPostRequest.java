import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_RestAssuredPostRequest {
	
	
	@Test
    void Post__PostMan_data() {
		
		RestAssured.baseURI="https://postman-echo.com";
		RequestSpecification Request=RestAssured.given();
		
		JSONObject requestParams =  new JSONObject();
		requestParams.put("FirstName", "JohnXYZ");
		requestParams.put("LastName", "XYZJohn");
		requestParams.put("UserName", "JohnXYZ");
		requestParams.put("Password", "JohnXYZxyx");
		requestParams.put("Email", "JohnXYZ@gmail.com");
		
		Request.header("Content_Type","application/json");
		Request.body(requestParams.toJSONString());
		Response response=Request.request(Method.POST,"/post");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :" +statusCode);
		Assert.assertEquals(200, statusCode);
		
		
		
		
	}
	

}
