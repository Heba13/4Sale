package my_app;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import screen.*;

import java.net.MalformedURLException;
import java.time.Duration;

public class MyApp extends BaseScreen {

    public Login login;
    public Home home;
    public AddAds addAds;
    public Categories categories;

  //  public MyApp(AppiumDriver<MobileElement> driver) {
            public MyApp() throws MalformedURLException {

            //  super(driver);
        this.home = new Home(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)), this);
    }


}

