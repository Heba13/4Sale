package for_sale_app.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public static AppiumDriver driver;
    public BaseTest() throws MalformedURLException {
        String URL = "http://127.0.0.1:4723/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus5API30");
        caps.setCapability(MobileCapabilityType.APP, "D:/automation/newforsale/4Sale/src/test/java/for_sale_app/com.forsale.forsale.apk");
        driver = new AndroidDriver(new URL(URL), caps);
    }

}