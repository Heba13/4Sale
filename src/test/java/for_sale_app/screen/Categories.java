package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class Categories  extends BaseScreen {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView")
    MobileElement ElectronicsCategory;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.TextView")
    MobileElement AudioSection;

    public Categories(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
    }

    public void chooseSelectedCategory() {
    ElectronicsCategory.click();
    }

    public void chooseSelectedSection() {
     AudioSection.click();
    }

    public void chooseCategory(String category) {
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Electronics\"]")).click();
        String textPath = createTextPath(category);
        driver.findElement(By.xpath(textPath)).click();
    }

    public void chooseSection(String section) {
        String textPath = createTextPath(section);
        driver.findElement(By.xpath(textPath)).click();
    }
        String createTextPath( String text) {

           String textPath ="//android.widget.TextView[contains(@text=\'"+text+"\')]";
            //String textPath ="//android.widget.FrameLayout[@content-desc=\""+text+"\"]/android.view.ViewGroup/android.widget.TextView";
           // String textPath ="//android.widget.TextView[@content-desc=\""+text+"\"]";
//        String textPath ="\"//android.widget.TextView[starts-with(@text,\'"+text+"\')]\"";
//        String textPath ="//android.widget.TextView[starts-with(@text, \'"+text+"\')]";
//        String textPath ="//android.widget.TextView[@text=\'"+text+"\']";
        return  textPath;
    }
}
