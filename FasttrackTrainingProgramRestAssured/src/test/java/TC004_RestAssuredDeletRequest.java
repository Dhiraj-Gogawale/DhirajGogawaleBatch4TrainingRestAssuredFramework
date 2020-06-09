import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_RestAssuredDeletRequest {
	
	
	@Test
    void Delete__PostMan_request() {
	// 1st Step: Create a variable empid and specify the value to be deleted.
    int empid = 520;
    
    
    //2nd Step: Specify a Request pointing to the Service Endpoint.
    RestAssured.baseURI ="https://postman-echo.com/delete";
    RequestSpecification request = RestAssured.given(); 
    
    //3rd Step: Send the Delete Request as described below.
 // Add a header stating the Request body is a JSON
    request.header("Content-Type", "application/json"); 
     
    /* Delete the request and check the response
    * The actual request being passed equalizes to http://dummy.restapiexample.com/api/v1/delete/15410 
    * Here, we capture the response for DELETE request by passing the associated empID in the baseURI */
    Response response = request.delete("/delete/"+ empid);
    
    
    //4th Step: Validate the PUT Request response received.
    int statusCode = response.getStatusCode();
    System.out.println(response.asString());
    Assert.assertEquals(statusCode, 200);
     
    String jsonString =response.asString();
    Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
    
	}
}
