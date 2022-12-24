package for_sale_app.tests;

import com.relevantcodes.extentreports.LogStatus;
import for_sale_app.utilities.extent_report.ExtentReport;
import for_sale_app.utilities.extent_report.ScreenShot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.net.MalformedURLException;
public class HooksHandler extends BaseTest {

    public HooksHandler() throws MalformedURLException {
        super();
    }

    @Before(order =0)
    public void lanchApp() {
driver.launchApp();
    }

    @Before(order = 1)
    public void startTCHooks(Scenario scenario) {
        ExtentReport.setScenario(scenario);
        ExtentReport.startTC();
    }

    @Before(order = 2)
    public void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setStepDefs();
    }

    @After(order = 1)
    public void endTC() {
        if (ExtentReport.isCurrentlyUsingReport()) {
            ExtentReport.getExtent().endTest(ExtentReport.getTest());
            ExtentReport.getExtent().flush();
        }
    }

    @After(order = 0)
    public void tearDown() {
        driver.closeApp();
    }

    @AfterStep
    public void AfterStep(Scenario scenario) {
        String stepName = ExtentReport.getCurrentStepName();
        LogStatus logStatus;

        if (scenario.isFailed())
            logStatus = LogStatus.FAIL;
        else
            logStatus = LogStatus.PASS;

        String base64Screenshot = ScreenShot.getScreenShot();
        ExtentReport.getTest().log(logStatus, stepName, ExtentReport.getTest().addBase64ScreenShot(base64Screenshot));
    }
}
