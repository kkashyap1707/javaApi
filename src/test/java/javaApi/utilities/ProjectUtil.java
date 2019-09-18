package javaApi.utilities;

import com.aventstack.extentreports.Status;
import com.google.api.services.gmail.Gmail;
import javaApi.test.TestBaseBrowser;

import static javaApi.utilities.GMailUtil.getGMailService;

public class ProjectUtil extends TestBaseBrowser {



    public static void addJobToSpreadsheet() throws Exception{
        BrowserUtil.openBrowser();
        Integer activeRowsCount = Quickstart.getActiveRowCount(GlobalVars.SPREADSHEET_ID,"good!A2:A");
        Integer numberOfLine = activeRowsCount+1;
        Quickstart.AddLineSpreadSheet(GlobalVars.SPREADSHEET_ID,inputGenerator,numberOfLine);
        Integer latestRowCount = Quickstart.getActiveRowCount(GlobalVars.SPREADSHEET_ID,"good!A2:E");
        System.out.println("Latest row count after new line added :: "+latestRowCount);
        Reporter.test.log(Status.INFO,"Latest row count after new line added :: "+latestRowCount);
        BrowserUtil.closeBrowser();
    }

    public static void deleteJobToSpreadsheet() throws Exception{
        BrowserUtil.openBrowser();
        Integer latestRowCount = Quickstart.getActiveRowCount(GlobalVars.SPREADSHEET_ID,"good!A2:E");
        Quickstart.deleteRow(GlobalVars.SPREADSHEET_ID,latestRowCount-1,latestRowCount);
        System.out.println("Latest row count after new line added :: "+latestRowCount);
        Reporter.test.log(Status.INFO,"Latest row count after new line added :: "+latestRowCount);
        BrowserUtil.closeBrowser();
    }

    public static String downloadSpreadsheet() throws Exception{
        BrowserUtil.getFileName();
        BrowserUtil.delete("/downloads/");
        DriveUtil.downloadSpreadSheet(DriveUtil.csvFilePath,"text/csv");
        String fileDownloadFolder = BrowserUtil.getFileName1();

        return fileDownloadFolder;
    }

    public static void sendEmail(String fullFilePath, String newCSVFileNameToBeSendAsAttachment) throws Exception{

        Gmail service = getGMailService();
        GMailUtil.sendFileAsAttachments(service,GlobalVars.RECEIVER,GlobalVars.SENDER,GlobalVars.SUBJECT,GlobalVars.BODY,GMailUtil.file1(fullFilePath+newCSVFileNameToBeSendAsAttachment));


    }

}
