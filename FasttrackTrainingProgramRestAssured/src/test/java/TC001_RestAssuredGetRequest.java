import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_RestAssuredGetRequest {


	@Test
	void Get__PostMan_data() {

		RestAssured.baseURI="https://postman-echo.com";
		RequestSpecification httpRequest=RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/get?foo1=bar1&foo2=bar2");
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is :" +responseBody);

		int statusCode=response.getStatusCode();
		System.out.println("Status Code is :" +statusCode);	
		Assert.assertEquals(200, statusCode);

		String statusline = response.getStatusLine();
		System.out.println("Status Line is :" +statusline);
		Assert.assertEquals("HTTP/1.1 200 OK", statusline);

	}

}
