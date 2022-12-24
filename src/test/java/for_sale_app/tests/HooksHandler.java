package for_sale_app.tests;

import io.cucumber.java.*;
import java.net.MalformedURLException;

public class HooksHandler extends BaseTest {

    public HooksHandler() throws MalformedURLException {
        super();
    }

    @Before
    public void lanchApp() {
        driver.launchApp();
    }

    @After
    public void tearDown() {
        driver.closeApp();
    }

}
