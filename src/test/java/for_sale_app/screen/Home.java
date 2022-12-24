package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.net.MalformedURLException;

public class Home extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Post an Ad\"]/android.widget.FrameLayout/android.widget.ImageView")
    MobileElement addAds;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.FrameLayout/android.widget.ImageView")
    MobileElement profile;

    public Home(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
    }

    public Post_Ad clickOnAddAds() throws MalformedURLException {
        addAds.click();
        return new Post_Ad(driver);
    }

    public MyProfile clickOnProfile() throws MalformedURLException {
        profile.click();
        return new MyProfile (driver);
    }

}
