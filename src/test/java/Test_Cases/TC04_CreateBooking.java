package Test_Cases;

import org.testng.annotations.Test;

import Base_Class.baseTest;

import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import reusable_methods.methods;
import utils.path;
import org.hamcrest.Matcher.*;



public class TC04_CreateBooking extends baseTest {

	
	@Test(priority=4)
	void create_booking() throws IOException
	{
		
			//creating a file instance
		File cbooking = new File("Body_Data/create_booking.json");
		
		
					    httprequest
						.contentType("application/json")
						.body(cbooking)
				
						.when()
							.post(path.createBooking())
						.then()
							.log().all()
							.assertThat().statusCode(200)
							.body("booking.firstname",equalTo("Prashant"),
									"booking.lastname",equalTo("Chauhan"),
									"booking.totalprice",equalTo(500));
					
		log.info("*****************Booking Created*******************");					
		
	}
	
	
}
