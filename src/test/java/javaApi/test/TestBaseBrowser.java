package javaApi.test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestResult;
import org.testng.annotations.*;
import javaApi.utilities.GlobalVars;
import javaApi.utilities.InputGenerator;
import javaApi.utilities.Keywords;
import javaApi.utilities.Reporter;

import java.lang.reflect.Method;

import static javaApi.utilities.Reporter.extent;

public class TestBaseBrowser {

    public static String env = System.getProperty("env");
    public static String ver = System.getProperty("ver");

    public static String inputGenerator[];

    //public static InputGenerator file1 = new InputGenerator();

    @BeforeSuite(alwaysRun=true)
    public void beforeSuite(){
        Keywords.loadSheetValue();
        System.out.println(GlobalVars.SystemId);
        Keywords.setURL(env,ver);
    }

    @BeforeTest(alwaysRun=true)
    public void beforeTest(){

        Reporter.setReportName("/test-output/ExtentReport.html");
        Reporter.createObjectExtentReport();
        Reporter.setReportConfig();
        Reporter.setSystemInfoOfReport();
        inputGenerator = InputGenerator.inputValue1;
    }

    @BeforeMethod(alwaysRun=true)
    public void beforeMethod(Method method){
        Reporter.test = extent.createTest(Feature.class, method.getName()).assignCategory("", this.getClass().getSimpleName());
    }

    @AfterMethod(alwaysRun=true)
    public void getResult(ITestResult result) throws Exception
    {
        if(result.getStatus() == ITestResult.FAILURE) {
            Reporter.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            Reporter.test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            Reporter.test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            Reporter.test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @AfterSuite
    public void afterSuite() {

    }

}
