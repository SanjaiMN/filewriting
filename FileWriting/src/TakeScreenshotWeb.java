
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TakeScreenshotWeb 
{
	public static void main(String[] args) 
	{
	    // Set up WebDriver
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanja\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    try 
	    {
	        // Code that might throw an exception
	        driver.get("https://demo.guru99.com/test/guru99home/");
	        int num = Integer.parseInt("Not a number");
	    } 
	    catch (Exception e) 
	    {
	        // Take screenshot of exception
	        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try 
	        {
	            ImageIO.write(ImageIO.read(screenshotFile), "png", new File("exception.png"));
	            System.out.println("Screenshot of exception saved to exception.png");
	        } 
	        catch (IOException ioe) 
	        {
	            System.out.println("Failed to save screenshot of exception: " + ioe.getMessage());
	        }
	    }
	    finally 
	    {
	        // Close WebDriver
	        driver.quit();
	    }
	}
}
