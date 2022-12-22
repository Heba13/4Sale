package tests.add_advertisement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/tests/add_advertisement/AddAdvertisement.feature",
        glue = {"tests.add_advertisement"},
        monochrome = true
        )
public class AddAdvertisementRunner extends AbstractTestNGCucumberTests {

}
