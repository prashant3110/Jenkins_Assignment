package utils;

public class path 
{
	
	public static String createToken_Path()  
	{	
		String resource = "/auth"; 			// path for creating token
		return resource;
	}

	public static String getBookingIds_Path() 
	{
		String resource = "/booking";			// path for getting booking ids
		return resource;
	}

	public static String getBooking(String id)
	{	
		String resource = "/booking/" + id;		//path for providing single id
		return resource;
	}

	public static String createBooking()
	{
		String resource = "/booking";		//path for creating booking
		return resource;
	}

	public static String updateBooking(String id)
	{	
		String resource = "/booking/" + id;		//path for update booking
		return resource;
	}
	
	public static String partialupdateBooking(String id)
	{	
		String resource = "/booking/" + id;		//path for partial update booking
		return resource;
	}
	
	public static String deleteBooking(String id)
	{	
		String resource = "/booking/" + id;		//path for delete booking
		return resource;
	}
}