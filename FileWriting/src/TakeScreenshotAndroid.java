import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.net.URL;

public class TakeScreenshotAndroid 
{
    public static void main(String[] args) throws Exception 
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "vivo I2012");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.sanjaimn.screenshotappdemo");
        capabilities.setCapability("appActivity", "com.sanjaimn.screenshotappdemo.MainActivity");
        
        try 
        {
        	//creating deliberate exception
        	int b=1/0;
        	System.out.println(b);
        } 
        catch (Exception e) 
        {
            // Take screenshot and save it to file
        	AppiumDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotFile = "src\\screenshot.jpeg";
            FileUtils.copyFile(scrFile, new File(screenshotFile));
            driver.quit();
        }
        
    }
}