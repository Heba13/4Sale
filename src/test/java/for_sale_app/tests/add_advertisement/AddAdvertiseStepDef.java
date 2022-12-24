package for_sale_app.tests.add_advertisement;

import for_sale_app.my_app.MyApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import for_sale_app.tests.BaseTest;
import org.testng.Assert;
import java.net.MalformedURLException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class AddAdvertiseStepDef extends BaseTest {

    public MyApp myApp = new MyApp(driver);

    public AddAdvertiseStepDef() throws MalformedURLException {
        super();
    }

    @Given("open My App in lang{string}")
    public void openMyApp(String lang) throws MalformedURLException {
        // driver.launchApp();
        if (Objects.equals(lang, "ar")) {
            myApp.myProfile = myApp.home.clickOnProfile();
            myApp.myProfile.clickOnSettings();
            myApp.myProfile.clickOnLanguage();
            myApp.myProfile.clickOnArabicOption();
            myApp.myProfile.clickOnOkButton();
        }
    }

    @When("click on post an Ad icon in navigation bar in Home screen")
    public void clickOnPostAnAdInNavigationBarInHomeScreen() throws MalformedURLException {
        myApp.post_ad = myApp.home.clickOnAddAds();
    }

    @Then("user should be redirected to Post Ad page")
    public void userShouldBeRedirectedToLoggingPage() {
        Assert.assertTrue(myApp.post_ad.getChooseCategory().isDisplayed());
        Assert.assertTrue(myApp.post_ad.getNext().isDisplayed());
    }

    @When("click on cheoose categories on Post Ad page")
    public void clickOnCheooseCategoriesOnPostAdPageWithTitle() throws MalformedURLException {
        myApp.categories = myApp.post_ad.clickOnChooseCategory();
    }

    @Then("user should be redirected to Choose Categories Page")
    public void userShouldBeRedirectedToChooseCategoriesPageWithTitle() {
    }

    @Then("user should be redirected back to Post Ad page page")
    public void userShouldBeRedirectedBackToPostAdPagePage() throws InterruptedException {
        Assert.assertTrue(myApp.post_ad.getChooseCategory().isDisplayed());
        Assert.assertTrue(myApp.post_ad.getNext().isDisplayed());
        Assert.assertTrue(myApp.post_ad.getchooseListing().isDisplayed());
        Assert.assertTrue(myApp.post_ad.getNext().isDisplayed());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("click on next button on Post Ad Screen")
    public void clickOnNextButtonOnPostAdScreen() throws MalformedURLException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myApp.addMedia = myApp.post_ad.clickOnNext();
    }

    @Then("descriptive error message will appear")
    public void descriptiveErrorMessageWillAppear() {
        try {
            Assert.assertFalse(myApp.addMedia.getAddVedioIcon().isDisplayed());
        }
        catch(Exception e) {
            Assert.assertFalse(false);
        }
    }

    @When("close My App")
    public void closeMyApp() {
        driver.closeApp();
    }

    @When("click on a category in Choose Categories Screen")
    public void clickOnACategoryInChooseCategoriesScreen() {
        myApp.categories.chooseSelectedCategory();
    }

    @When("click on a section in Choose Categories Screen")
    public void clickOnASectionInChooseCategoriesScreen() {
        myApp.categories.chooseSelectedSection();
    }

    @When("click on a specific {string} in Choose Categories Screen")
    public void clickOnASpecificInChooseCategoriesScreen(String cat) {
        myApp.categories.chooseCategory(cat);
    }

    @And("click on a specific {string} in the {string} screen")
    public void clickOnASpecificInTheScreen(String cat, String section) {
        myApp.categories.chooseSection(section);
    }

}