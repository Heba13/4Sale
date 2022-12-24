package for_sale_app.my_app;

import for_sale_app.screen.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.net.MalformedURLException;
import java.time.Duration;

public class MyApp {
    public Home home;
    public Post_Ad post_ad;
    public Categories categories;
    public MyProfile myProfile;
    public AddMedia addMedia;
    public MyApp(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        this.home = new Home(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }
}

