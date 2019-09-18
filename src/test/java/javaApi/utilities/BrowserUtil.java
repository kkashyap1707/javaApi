package javaApi.utilities;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javaApi.test.TestBaseBrowser;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserUtil extends TestBaseBrowser {

    private static String OS = System.getProperty("os.name").toLowerCase();
    public static String browserType = System.getProperty("browserType");
    public static String currentDirectory = System.getProperty("user.dir");

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String fileDownloadPath = currentDirectory + "/downloads";
    public static String chromeDriverPath = currentDirectory + "/lib/chromedriver_linux64/chromedriver";


    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver=new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        Reporter.test.log(Status.INFO,"Browser Launched Successfully");
    }

    public static void closeBrowser() {
        if(driver!=null) {
            driver.quit();
            Reporter.test.log(Status.INFO,"Browser closed successfully");
        }
    }

    public static ChromeOptions chromeProperties(){
        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("download.default_directory", fileDownloadPath);

        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", prefsMap);
        option.addArguments("--test-type");
        option.addArguments("--disable-extensions");

        return option;
    }

    public static void launchBrowser(String URL){
        driver = new ChromeDriver(chromeProperties());
        driver.navigate().to(URL);
        //driver.get(URL);
        Reporter.test.log(Status.PASS, "Browser launched successfully.");
    }

    public static void launch(String URL) throws InterruptedException{

        driver = new ChromeDriver(chromeProperties());
        driver.get(URL);
        Reporter.test.log(Status.PASS, "Browser launched successfully.");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(5000);
        System.out.println("Downloaded of csv completed.");

        Reporter.test.log(Status.PASS, "CSV File downloaded successfully.");
        //driver.quit();
        Reporter.test.log(Status.PASS, "Browser closed successfully.");
    }

    public static void deleteFile(){

        File file = new File(currentDirectory + "/downloads/Corporate_1 - good.csv");

        // renaming the file and moving it to a new location
        if(file.renameTo
                (new File(currentDirectory + "/oldFile/Corporate_2.csv")))
        {
            // if file copied successfully then delete the original file
            //file.delete();
            System.out.println("File moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }

    public static void delete(String folderName){

        File dir1 = new File(currentDirectory + folderName);

        if(dir1.isDirectory()) {
            System.out.println("HOLA 1");
            File[] content = dir1.listFiles();

            System.out.println("Total number of files :: "+content.length);
            Reporter.test.log(Status.INFO,"Total number of files :: "+content.length);

            if(content.length==0){
                System.out.println("No previously downloaded file found.");
                Reporter.test.log(Status.INFO,"No previously downloaded file found.");
            }else {
                for(int i = 0; i < content.length; i++) {

                    //move content[i]

                    String currentFileName = content[i].getName();
                    System.out.println("Current file name :: "+currentFileName);
                    Reporter.test.log(Status.INFO,"Current file name :: "+currentFileName);

                    content[i].delete();
                    System.out.println(i+" "+currentFileName+":: Old file deleted.");
                    Reporter.test.log(Status.PASS,i+" Old file deleted.");
                }
            }
        }
    }

    /*public static void renameFile(String oldFileName, String newFileName){

        File file = new File(currentDirectory + "/downloads/"+oldFileName);

        // renaming the file and moving it to a new location
        if(file.renameTo(new File(currentDirectory + "/oldFile/"+newFileName)))
        {
            // if file copied successfully then rename the original file
            System.out.println("File renamed successfully "+newFileName);

            Reporter.test.log(Status.INFO,"File renamed successfully "+newFileName);

            System.out.println("New file name is :: "+newFileName);
            Reporter.test.log(Status.INFO,"New file name is :: "+newFileName);
        }
        else
        {
            System.out.println("Failed to renamed the file");
            Reporter.test.log(Status.ERROR,"Failed to renamed the file");
        }
    }*/

    public static String renameFileAsCSV(String oldFileName, String newFileName){

        File file = new File(currentDirectory + "/downloads/"+oldFileName);
        String newCSVFile = null;

        // renaming the file and moving it to a new location
        if(file.renameTo(new File(currentDirectory + "/oldFile/"+newFileName)))
        {
            newCSVFile = newFileName;
            // if file copied successfully then rename the original file
            System.out.println("File renamed successfully "+newFileName);

            Reporter.test.log(Status.INFO,"File renamed successfully "+newFileName);

            System.out.println("New file name is :: "+newFileName);
            Reporter.test.log(Status.INFO,"New file name is :: "+newFileName);
        }
        else
        {
            System.out.println("Failed to renamed the file");
            Reporter.test.log(Status.ERROR,"Failed to renamed the file");
        }

        return newCSVFile;
    }

    public static void getFileName(){

        File folder = new File(currentDirectory + "/downloads/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());

            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());

            }
        }
    }

    public static String getFileName1(){

        String fileNameInDownloadsFolder = null;

        File folder = new File(currentDirectory + "/downloads/");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());

                fileNameInDownloadsFolder = listOfFiles[i].getName();

            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());

            }
        }

        return fileNameInDownloadsFolder;
    }

    public static void validateProgress(String URL) throws InterruptedException{
        driver.get(URL);
        BrowserUtil.login(GlobalVars.USERNAME,GlobalVars.PASSWORD);
        Thread.sleep(10000);
        driver.navigate().refresh();
    }

    public static void login(String UserName, String Password){

        driver.findElement(By.cssSelector("#id_auth-username")).sendKeys(UserName);
        driver.findElement(By.cssSelector("#id_auth-password")).sendKeys(Password);
        driver.findElement(By.cssSelector("body > div.container > div > div > form > button.btn.btn-primary")).click();

    }

    public static void logout(){
        driver.findElement(By.cssSelector("#user-tools > a:nth-child(4)")).click();
    }

    public static String employerUploadPath() throws InterruptedException{

        Thread.sleep(9000);
        driver.navigate().refresh();
        Thread.sleep(19000);
        String employerUploadPathName =  driver.findElement(By.cssSelector("#result_list > tbody > tr:nth-child(1) > td.field-path")).getText();

        return employerUploadPathName;
    }

    public static String path() throws InterruptedException{
        BrowserUtil.validateProgress(GlobalVars.UPLOAD_PROGRESS_CHECK_URL);
        String uploadPath = BrowserUtil.employerUploadPath();
        System.out.println("Path is :: "+uploadPath);
        BrowserUtil.logout();

        return uploadPath;
    }



}
