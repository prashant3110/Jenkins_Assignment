package Test_Cases;

import org.testng.annotations.Test;

import Base_Class.baseTest;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import reusable_methods.methods;
import utils.path;
import static org.hamcrest.Matchers.*;

public class TC03_GetBooking extends baseTest{
	
	String id = methods.get_ID();
	
	@Test(priority=3)
	void getBooking()
	{
		log.info("**************Get Booking**************");
		
	Response res = httprequest
					.when()
						.get(path.getBooking(id))
					.then()
						.log().all()
						.assertThat()
						.statusCode(200)
						.body("firstname",instanceOf(String.class))
						.body("lastname",instanceOf(String.class))
						.body("totalprice",instanceOf(Integer.class))
						.extract().response();
				
	}

}
