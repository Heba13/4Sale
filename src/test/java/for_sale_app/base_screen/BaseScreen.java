package for_sale_app.base_screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class BaseScreen {

protected AppiumDriver driver;

 public BaseScreen(AppiumDriver< MobileElement > driver) {
            this.driver = driver;
            PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
        }
    }




