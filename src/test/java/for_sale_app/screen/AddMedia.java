package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.net.MalformedURLException;

public class AddMedia extends BaseScreen {
    @AndroidFindBy(xpath ="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.view.View[6]/android.view.View[1]")
    MobileElement AddVedioIcon;

    public AddMedia (AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
    }

    public MobileElement getAddVedioIcon() {
        return AddVedioIcon;
    }
}