package Test_Cases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Base_Class.baseTest;
import Pojo.partialUpdate;
import io.restassured.RestAssured;
import reusable_methods.methods;
import utils.path;

public class TC06_PartialUpdate extends baseTest {

	String id = methods.partialUpdate_ID();
	
	@Test(priority=6,enabled=false)
	void partial_Update_request(ITestContext context)
	{
		
		String tk = (String) context.getAttribute("token");
		
		
		log.info("**********Partial update booking****************");
		
		partialUpdate body = new partialUpdate();
			body.setFirstname("Prashant");
			body.setLastname("Chauhan");
		
		httprequest
				.header("Content-Type","application/json")
				.header("Accept","application/json")
				.header("Cookie","token="+tk)
				.body(body)
				.when()
					.patch(path.partialupdateBooking(id))
				.then()
					.log().all()
					.assertThat().statusCode(200);	
				
	}	
}
