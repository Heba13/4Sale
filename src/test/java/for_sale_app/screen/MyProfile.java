package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.net.MalformedURLException;

public class MyProfile extends BaseScreen{

        @AndroidFindBy(id = "")
        MobileElement settings;

        @AndroidFindBy(xpath = "")
        MobileElement language;

        @AndroidFindBy(xpath = "")
        MobileElement arabicOption;

        @AndroidFindBy(xpath = "")
        MobileElement englishOption;

        @AndroidFindBy(xpath = "")
        MobileElement okButton;

    public MyProfile(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
    }

    public MobileElement getSettings() {
        return settings;
    }

    public void clickOnSettings() {
        settings.click();
    }

    public void clickOnLanguage() {
        language.click();
    }

    public void clickOnOkButton() {
        okButton.click();
    }

    public void clickOnArabicOption() {
        arabicOption.click();
    }

    public void clickOnenglishOption() {
        englishOption.click();
    }

}
