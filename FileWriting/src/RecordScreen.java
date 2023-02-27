import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Base64;

import org.openqa.selenium.remote.DesiredCapabilities;

public class RecordScreen {

    public static void recordVideo() throws IOException, InterruptedException {
        // Set up Appium server and driver
       
        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),new DesiredCapabilities());

        // Start screen recording for 10 seconds
        AndroidStartScreenRecordingOptions options = new AndroidStartScreenRecordingOptions()
                .withTimeLimit(Duration.ofSeconds(10));
        driver.startRecordingScreen(options);

        // Stop screen recording and decode the video data
        String base64String =  driver.stopRecordingScreen();
        //String base64String = ((AndroidDriver<?>) castDriver()).stopRecordingScreen();
        byte[] decodedData = Base64.getDecoder().decode(base64String);

        // Save video to file
        File outputFile = new File("recorded_video.mp4");
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(decodedData);
        outputStream.close();

        // Quit driver and stop Appium server
        driver.quit();
       
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        recordVideo();
    }
}
