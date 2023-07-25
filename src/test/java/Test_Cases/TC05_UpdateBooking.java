package Test_Cases;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import Base_Class.baseTest;
import io.restassured.RestAssured;
import reusable_methods.methods;
import utils.path;

public class TC05_UpdateBooking extends baseTest {
	
	String id = methods.update_ID();
	
	
	
	@Test(priority=5,enabled=false)
	void update_booking(ITestContext context)
	{
		String tk = (String) context.getAttribute("token"); // getting token 
		
				
		File uBooking = new File("Body_Data/update_booking.json");
				
		HashMap<String,String> hd = new HashMap();
		hd.put("Content-Type","application/json");
		hd.put("Accept","application/json");
		hd.put("Cookie","token="+tk);
		
			httprequest
				.headers(hd)
				.body(uBooking)
					
				.when()
					.put(path.updateBooking(id))
				.then()
					.log().all()
					.assertThat().statusCode(200);
			
		
		log.info("*****************Update Booking**************");
		
	}

}
