import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC005_RestAssuredAuthenticationRequest {
	
	@Test
	public void testAuthenticationFlow()
	{
		int code=RestAssured.given()
				.auth().preemptive()
				.basic("postman", "password")
				.when()
				.get("https://postman-echo.com/basic-auth")
				.getStatusCode();
				
				System.out.println("Response Code From Server Is " +code);
	}

}
