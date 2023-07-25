package Test_Cases;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Base_Class.baseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusable_methods.methods;
import utils.path;

public class TC07_DeleteBooking extends baseTest {
	
	String id = methods.delete_ID();
	
	@Test(priority=7,enabled=false)
	void deletebooking(ITestContext context)
	{
	
	String tk = (String) context.getAttribute("token");
		
	 log.info("********Delete Booking***************");	

			httprequest
				.header("Cookie","token="+tk)
				
				
				.when()
					.delete(path.deleteBooking(id))
					
				.then()
					.log().all()
					.assertThat().statusCode(201);	
		
	}
	
	

}
