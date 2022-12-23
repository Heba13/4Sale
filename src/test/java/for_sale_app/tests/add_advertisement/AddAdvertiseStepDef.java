package for_sale_app.tests.add_advertisement;

import for_sale_app.my_app.MyApp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import for_sale_app.tests.BaseTest;
import org.testng.Assert;
import java.net.MalformedURLException;

public class AddAdvertiseStepDef extends BaseTest {

    public MyApp myApp = new MyApp(driver);

    public AddAdvertiseStepDef() throws MalformedURLException {
        super();
    }

    @Given("open My App in lang{string}")
    public void openMyApp(String lang) throws MalformedURLException {
    driver.launchApp();
          if (lang=="AR") {
              myApp.myProfile= myApp.home.clickOnProfile();
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
        public void userShouldBeRedirectedToLoggingPage () {
            Assert.assertTrue(myApp.post_ad.getChooseCategory().isDisplayed());
            Assert.assertTrue(myApp.post_ad.getNext().isDisplayed());
            Assert.assertTrue(myApp.post_ad.getTitle().isDisplayed());
            Assert.assertTrue(myApp.post_ad.getchooseListing().isDisplayed());
    }

    @When("click on cheoose categories on Post Ad page")
    public void clickOnCheooseCategoriesOnPostAdPageWithTitle() throws MalformedURLException {
        myApp.categories = myApp.post_ad.clickOnChooseCategory();
    }

    @Then("user should be redirected to Choose Categories Page")
    public void userShouldBeRedirectedToChooseCategoriesPageWithTitle() {
    }

    @When("click on a specific {string} in Choose Categories Screen")
    public void clickOnASpecificInChooseCategoriesScreen(String cat) {
        myApp.categories.chooseCategory(cat);  }

    @And("click on a specific {string} in the {string} screen")
    public void clickOnASpecificInTheScreen(String cat, String section) {
        myApp.categories.chooseSection(section);
    }

    @Then("user should be redirected to Post Ad page page")
    public void userShouldBeRedirectedToPostAdPagePage() {
    }

    @When("click on next button on  Post Ad Screen")
    public void clickOnNextButtonOnPostAdScreen() throws MalformedURLException {
        myApp.addMedia= myApp.post_ad.clickOnNext();
    }

    @Then("descriptive error message will appear")
    public void descriptiveErrorMessageWillAppear() {
        Assert.assertFalse(myApp.addMedia.getAddVedioIcon().isDisplayed());
    }
}
