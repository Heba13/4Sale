package for_sale_app.tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import for_sale_app.utilities.extentReport.ExtentReport;
import for_sale_app.utilities.extentReport.ScreenShot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
public class HooksHandler extends BaseTest {

    public HooksHandler() throws MalformedURLException {
        super();
    }

    @Before(order= 1)
     public void startTCHooks(Scenario scenario) throws NoSuchFieldException, IllegalAccessException {
    ExtentReport.setScenario(scenario);
    ExtentReport.startTC();
    ExtentReport.setStepDefs();
}

    @Before (order=2)
    public void lanchApp() {
      //  driver.launchApp();
    }


    @Before(order = 3)
    public void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setStepDefs();
    }


    @After(order=1)
    public void tearDown() {

        driver.closeApp();
        System.out.println("good buye");

    }

    @After(order = 2)
    public void endTC() throws URISyntaxException, IOException {
        {
            ExtentReport.reportTearDown();

        }
    }


    @AfterStep
    public void AfterStep(Scenario scenario) {
        String stepName = ExtentReport.getCurrentStepName();
        Status logStatus;

        if (scenario.isFailed()) {
            logStatus = Status.FAIL;
            String base64Screenshot = ScreenShot.getScreenShot();
            ExtentReport.getTest().log(logStatus, stepName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());        }
        else {
            logStatus = Status.PASS;
            ExtentReport.getTest().log(logStatus, stepName);
        }

    }
}
