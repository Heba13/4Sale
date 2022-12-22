package tests.add_advertisement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.BaseTest;

import java.net.MalformedURLException;

public class AddAdvertiseStepDef extends BaseTest {

    public AddAdvertiseStepDef() throws MalformedURLException {
        super();
    }

    @Given("open My App")
    public void openMyApp() throws MalformedURLException {
    driver.launchApp();
    }

    @When("click on Add Adds sign in navigation bar in Home screen")
    public void clickOnAddAddsSignInNavigationBarInHomeScreen() {
        System.out.println("d");
    }

    @Then("user should be redirected to Logging page")
    public void userShouldBeRedirectedToLoggingPage() {
        System.out.println("H");
    }
}
