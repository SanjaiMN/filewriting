import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat 
{

	public static void main(String[] args) 
	{
		System.out.println(dateformat());
		//File(dateformat()+".mp4");
		//use the above line in code to call this function.
	}
	public static String dateformat()
	{
		LocalDateTime now = LocalDateTime.now(); 
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM_dd_EEE_HH_mm_ss");
		return now.format(formatter);
	}
}
