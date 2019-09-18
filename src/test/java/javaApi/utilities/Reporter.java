package javaApi.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import javaApi.test.TestBaseBrowser;

public class Reporter {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;


	public static void setReportName(String fileLocationAndName){
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + fileLocationAndName);

	}

	public static void createObjectExtentReport(){
		extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);
		extent.setReportUsesManualConfiguration(false);

	}

	public static void setReportConfig(){

		htmlReporter.config().setDocumentTitle("Testing Automation Report"); // Tittle of Report
		htmlReporter.config().setReportName("Testing Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report
		htmlReporter.config().enableTimeline(true);
		htmlReporter.config().setAutoCreateRelativePathMedia(true);
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setCSS(".subview-left{width: 35%;}");

	}

	public static void setSystemInfoOfReport(){
		extent.setSystemInfo("Application Name", "Testing Automation Test");
		extent.setSystemInfo("User Name", "Keshav Kahsyap");
		extent.setSystemInfo("Envirnoment", TestBaseBrowser.env);
		extent.setSystemInfo("OS", "Ubuntu");
	}

}
