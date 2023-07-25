package Test_Cases;

import org.testng.annotations.Test;

import Base_Class.baseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.path;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

public class TC02_GetBookingIDs extends baseTest {

	@Test(priority=2,enabled=false)
	void getBookingIds()
	{
		log.info("***********Getting the Booking ID****************");
	
		Response res = 	httprequest
					.when()
						.get(path.getBookingIds_Path())
					.then()
						.log().all()
						.assertThat()
						.statusCode(200)
						.body("bookingid",instanceOf(ArrayList.class))
						.extract().response();
						
		res.prettyPeek();		
		
	}	
	
}
