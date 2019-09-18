package javaApi.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.*;
import javaApi.utilities.Keywords;

import java.lang.reflect.Method;

public class TestBase {

    public static String env = System.getProperty("env");
    public static String ver = System.getProperty("ver");


    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeSuite(alwaysRun=true)
    public void beforeSuite(){
        Keywords.loadSheetValue();
        Keywords.setURL(env,ver);
    }

    @BeforeTest(alwaysRun=true)
    public void beforeTest(){


        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");

        extent = new ExtentReports();  //create object of ExtentReports
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(false);

        htmlReporter.config().setDocumentTitle("Allyo API Automation Report"); // Tittle of Report
        htmlReporter.config().setReportName("Allyo Test Report"); // Name of the report
        htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
        htmlReporter.config().enableTimeline(true);
        htmlReporter.config().setAutoCreateRelativePathMedia(true);
        htmlReporter.config().setProtocol(Protocol.HTTPS);
        htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setCSS(".subview-left{width: 35%;}");

        // General information releated to application
        extent.setSystemInfo("Application Name", "Dashboard API Test");
        extent.setSystemInfo("User Name", "Keshav Kahsyap");
        extent.setSystemInfo("Envirnoment", "Production");
        extent.setSystemInfo("OS", "Ubuntu");

    }

    @BeforeMethod(alwaysRun=true)
    public void beforeMethod(Method method){

        test = extent.createTest(Feature.class, method.getName()).assignCategory("", this.getClass().getSimpleName());

    }

    @AfterMethod(alwaysRun=true)
    public void getResult(ITestResult result) throws Exception
    {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
        }
        else if(result.getStatus() == ITestResult.SKIP){
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

    @AfterSuite
    public void afterSuite() {
        //ExtentManager.getReporter().flush();
    }

}
