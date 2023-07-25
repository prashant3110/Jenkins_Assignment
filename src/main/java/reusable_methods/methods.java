package reusable_methods;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;

import Base_Class.baseTest;

public class methods extends baseTest {
	

	@BeforeMethod
	public static String get_ID()		//	reading booking id from property file
	{
		String id = getProperty("booking_ID");
		return id;
	}
	
	
	@BeforeMethod						
	public static String update_ID()		//	reading updatebooking id from property file
	{
		String id = getProperty("update_ID");
		return id;
	}
	
	
	@BeforeMethod
	public static String partialUpdate_ID()		//	reading partialupdate id from property file
	{
		String id = getProperty("partialUpdate_ID");
		return id;
	}
	
	@BeforeMethod
	public static String delete_ID()	//	reading delete booking id from property file
	{
		String id = getProperty("delete_ID");
		return id;
	}
	
	
	
}
