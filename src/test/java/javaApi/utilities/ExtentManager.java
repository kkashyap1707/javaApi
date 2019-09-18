package javaApi.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import javaApi.test.TestBase;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtentManager {

    public static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private final static String filePath = GlobalVars.getInstance().getREPORT_FOLDER_ROOT_NAME() + "-api-execution-report" + ".html";


    public synchronized static ExtentReports getReporter() {

        if (extent == null) {
          //  extent = new ExtentReports(filePath, true);

            Map<String, String> sysInfo = new HashMap<>();
            sysInfo.put("Environment", TestBase.env);
            sysInfo.put("API Version", TestBase.ver);
           // sysInfo.put("Customer",TestBase.retrievalID);
           // sysInfo.put("ATS",TestBase.testtype);

            sysInfo.put("Host Name", System.getProperty("user.name"));

            ClassLoader classLoader = ExtentManager.class.getClassLoader();
            File file = new File(classLoader.getResource(GlobalVars.getInstance().getEXTENT_CONFIG_FILE()).getFile());

           // extent.addSystemInfo(sysInfo);
           // extent.loadConfig(file);
        }

        return extent;
    }

}