import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_RestAssuredPutRequest {
	
	@Test
    void Put__PostMan_request() {
		
		//Step 1: Create a variable empid which we intend to update with our PUT request.
		int empid = 500;
		
		//Step 2: Create a Request pointing to the Service Endpoint.
		 RestAssured.baseURI ="https://postman-echo.com/put";
		 RequestSpecification request = RestAssured.given();
		
		 
		 //Step 3: Create a JSON request which contains all the fields which we wish to update.
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "Zion"); 
		 requestParams.put("age", 23);
		 requestParams.put("salary", 12000);
		 
		 //Step 4. Send JSON content in the body of Request and pass PUT Request
		// Add a header stating the Request body is a JSON
		 request.header("Content-Type", "application/json"); 
		  
		 // Add the Json to the body of the request
		 request.body(requestParams.toJSONString());
		  
		 // The actual request being passed equalizes to http://dummy.restapiexample.com/api/v1/update/15410
		 // Here, we capture the response for PUT request by passing the associated empID in the baseURI
		 Response response = request.put("/update/"+ empid);
		 
		 //Step 5: Validate the PUT Request response received
		 int statusCode = response.getStatusCode();
		 System.out.println(response.asString());
		 Assert.assertEquals(statusCode, 404);
		 
		
	}


}
