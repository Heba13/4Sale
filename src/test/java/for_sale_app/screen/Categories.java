package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

public class Categories  extends BaseScreen {

    public Categories(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
    }

    public void chooseCategory(String category) {
        String textPath = createTextPath(category);
        driver.findElement(By.xpath(textPath)).click();
    }

    public void chooseSection(String section) {
        String textPath = createTextPath(section);
        driver.findElement(By.xpath(textPath)).click();
    }

    String createTextPath(String text) {
        String textPath = "//*[contains(@text, \"" + text + "\")]";
        return textPath;

    }
}