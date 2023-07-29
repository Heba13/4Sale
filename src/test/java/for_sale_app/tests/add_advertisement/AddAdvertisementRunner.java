package for_sale_app.tests.add_advertisement;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        features = "src/test/java/for_sale_app/tests/add_advertisement/AddAdvertisement.feature",
        glue = {"for_sale_app.tests"}

        )

public class AddAdvertisementRunner extends AbstractTestNGCucumberTests {


}
