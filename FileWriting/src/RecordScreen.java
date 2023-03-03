import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.remote.MobileCapabilityType;


import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

public class RecordScreen 
{

    public static void recordVideo() throws IOException, InterruptedException 
    {
    	
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.APP, "path/to/your/app.apk");
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Create an instance
        AndroidDriver driver = new AndroidDriver(serverURL, caps);

        // Start recording test cases
        driver.startRecordingScreen();

        // Your test code goes here

        // Stop recording test cases
        String videoRecording = driver.stopRecordingScreen();
        // Quit the driver
        driver.quit();
       
    }

    public static void main(String[] args) throws IOException, InterruptedException 
    {
        recordVideo();
    }
}
