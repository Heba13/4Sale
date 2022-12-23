package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import javax.xml.xpath.XPath;
import java.net.MalformedURLException;

import static java.awt.SystemColor.text;

public class Post_Ad  extends BaseScreen {
    @AndroidFindBy(id = "com.forsale.forsale:id/adTitleField")
    MobileElement chooseListing ;

    @AndroidFindBy(id = "com.forsale.forsale:id/compose_view")
    MobileElement next;

    @AndroidFindBy(id = " com.forsale.forsale:id/chooseCategoryField")
    MobileElement chooseCategory ;

    @AndroidFindBy(id = "com.forsale.forsale:id/adTitleField")
    MobileElement title ;
    @AndroidFindBy(id = "")
    MobileElement errorMessage ;

    public Post_Ad(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super();
    }
    public MobileElement getChooseCategory() {
        return chooseCategory;
    }

    public MobileElement getNext() {
        return next;
    }

    public MobileElement getTitle() {
        return title;
    }

    public MobileElement getchooseListing() {
        return chooseListing;
    }

    public AddMedia clickOnNext() throws MalformedURLException {
        next.click();
        return new AddMedia(driver);
    }
    public Categories clickOnChooseCategory() throws MalformedURLException {
        chooseCategory.click();
        return new Categories(driver);
    }

    public void enterTitle(String AddTitle) {
        title.sendKeys(AddTitle);
    }

    public String getErrorMessage (){
      return   errorMessage.getText();
    }

}





