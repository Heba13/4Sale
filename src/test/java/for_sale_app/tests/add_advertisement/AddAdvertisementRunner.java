package for_sale_app.tests.add_advertisement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/for_sale_app/tests/add_advertisement/AddAdvertisement.feature",
        glue = {"for_sale_app.tests.add_advertisement"},
        plugin = {"html:reports/Add-Advertisement.html"},
        monochrome = true
        )
public class AddAdvertisementRunner extends AbstractTestNGCucumberTests {

}
