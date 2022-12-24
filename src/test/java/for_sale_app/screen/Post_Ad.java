package for_sale_app.screen;

import for_sale_app.base_screen.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.net.MalformedURLException;

public class Post_Ad  extends BaseScreen {
    @AndroidFindBy(id = "com.forsale.forsale:id/adTitleField")
    MobileElement chooseListing ;

    @AndroidFindBy(id = "com.forsale.forsale:id/compose_view")
    MobileElement next;

    @AndroidFindBy(id = "com.forsale.forsale:id/chooseCategoryField")
    MobileElement chooseCategory ;

    @AndroidFindBy(id = "com.forsale.forsale:id/adTitleField")
    MobileElement title ;

    public Post_Ad(AppiumDriver<MobileElement> driver) throws MalformedURLException {
        super(driver);
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

}





