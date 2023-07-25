package Test_Cases;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Base_Class.baseTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import reusable_methods.methods;
import utils.path;
import static org.hamcrest.Matchers.*;

public class TC01_CreateToken extends baseTest{
	
	
	@Test(priority=1)
	void create_Token(ITestContext context)
	{
		
		String body = "{\"username\":\"admin\","
					+ "\"password\":\"password123\"}";
		
		String getToken = httprequest
						.headers("Content-Type","application/json")
						.body(body)
					.when()
						.post(path.createToken_Path())
					.then()
						.log().all()
						.assertThat()
						.statusCode(200)
						.body("token",instanceOf(String.class))
						.extract().jsonPath().getString("token");

		context.setAttribute("token", getToken);
		
		log.info("*********TOKEN CREATED************");
		System.out.println(getToken);
		
	
		
		
	}
	
}
