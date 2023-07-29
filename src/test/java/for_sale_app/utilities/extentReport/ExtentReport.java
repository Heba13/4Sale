package for_sale_app.utilities.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class ExtentReport {
    public static ExtentSparkReporter spark ;
    private final  static ExtentReports extentReport = new ExtentReports();
    private static ExtentTest test ;
    private static Scenario scenario ;
    private  static List<PickleStepTestStep> stepDefs;
    static int currentStepDefIndex;


    @BeforeTest
    public void startReport() throws IOException {
        initializeReportConfiguration("$forSale");
    }

    public void  initializeReportConfiguration(String reportName) throws IOException {
        // start reporters
        spark = new ExtentSparkReporter("./reports/forSale2.html");
        // create ExtentReports and attach reporter(s)
        extentReport.attachReporter(spark);
        spark.loadXMLConfig("src/test/java/for_sale_app/utilities/extentReport/extentc-onfig.xml");
    }

    public static void setScenario(Scenario currentScenario) {
        ExtentReport.scenario = currentScenario;
    }

    public static void startTC() {
        String testCaseName = scenario.getName();
        test = extentReport.createTest(testCaseName);
        System.out.print(test.toString());
        //currentStepDefIndex= 0 ;
        test.assignCategory(getFeatureFileName());
    }


    public static ExtentTest getTest() {
        return test;
    }

    public static void setStepDefs() throws NoSuchFieldException, IllegalAccessException {

        TestCase testCase = getTestCase();
         stepDefs = getTestStepsDefs(testCase);
    }

    public static String getCurrentStepName(){
        String currentStepDescription;
        PickleStepTestStep currentStepDef = stepDefs.get(currentStepDefIndex);

        currentStepDescription = currentStepDef.getStep().getText();
        currentStepDefIndex += 1;

        return currentStepDescription ;
    }

    private static List<PickleStepTestStep> getTestStepsDefs(TestCase testCase) {
        return testCase.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());
    }


    private static TestCase getTestCase() throws NoSuchFieldException, IllegalAccessException {
        Field delegateField = scenario.getClass().getDeclaredField("delegate");
        delegateField.setAccessible(true);
        TestCaseState testCaseState = (TestCaseState) delegateField.get(scenario);
        Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
        testCaseField.setAccessible(true);
        TestCase testCase = (TestCase) testCaseField.get(testCaseState);
        return testCase;
    }

    @AfterTest
    public static void reportTearDown() throws URISyntaxException, IOException {
      //calling flush write everything to the log file

        extentReport.flush();
    }


    public static String getFeatureFileName() {

        Path featureFilePath = Paths.get(scenario.getUri());
        String fileName = featureFilePath.getFileName().toString();
        String[] parts = fileName.split("\\.feature");
        return parts[0];
    }








}
