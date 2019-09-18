package javaApi.utilities;

import javaApi.test.TestBase;

import java.io.FileReader;
import java.util.Properties;

public class Keywords extends TestBase{


    public static void loadSheetValue() {

        Properties properties = new Properties();
        String fileName = TestBase.env + "_GoogleSpreadsheet.properties";
        System.out.println(fileName);
        try {
            FileReader reader = new FileReader(fileName);
            properties.load(reader);

            //GlobalVars.SystemId    = properties.getProperty("SystemId").isEmpty()?properties.getProperty("SystemId"):"";
            GlobalVars.SystemId    = properties.getProperty("SystemId");
            GlobalVars.createdDate = properties.getProperty("createdDate");
            GlobalVars.updatedDate = properties.getProperty("updatedDate");
            GlobalVars.applyURL    = properties.getProperty("applyURL");
            GlobalVars.noOfPeople  = properties.getProperty("noOfPeople");
            GlobalVars.noOfPeopleNeededRemaining    = properties.getProperty("noOfPeopleNeededRemaining");
            GlobalVars.category                     = properties.getProperty("category");
            GlobalVars.additionalRequirements       = properties.getProperty("additionalRequirements");
            GlobalVars.additionalLicensesNotListed  = properties.getProperty("additionalLicensesNotListed");
            GlobalVars.employmentType  = properties.getProperty("employmentType");
            GlobalVars.jobFolderStatus = properties.getProperty("jobFolderStatus");
            GlobalVars.licensesCertification   = properties.getProperty("licensesCertification");
            GlobalVars.orientationLocation     = properties.getProperty("orientationLocation");
            GlobalVars.otherSpecialRequirements= properties.getProperty("otherSpecialRequirements");
            GlobalVars.physicalRequirements    = properties.getProperty("physicalRequirements");
            GlobalVars.positionId              = properties.getProperty("positionId");
            GlobalVars.postingTitle            = properties.getProperty("postingTitle");
            GlobalVars.winTeamPositionTitle    = properties.getProperty("winTeamPositionTitle");
            GlobalVars.requisitionId           = properties.getProperty("requisitionId");
            GlobalVars.securityClearance       = properties.getProperty("securityClearance");
            GlobalVars.shiftsAvailable         = properties.getProperty("shiftsAvailable");
            GlobalVars.hiringManagerSystemID   = properties.getProperty("hiringManagerSystemID");
            GlobalVars.hiringManageFullName    = properties.getProperty("hiringManageFullName");
            GlobalVars.hiringManagerEmail      = properties.getProperty("hiringManagerEmail");
            GlobalVars.hiringManagerPhone      = properties.getProperty("hiringManagerPhone");
            GlobalVars.hiringManagerAddress    = properties.getProperty("hiringManagerAddress");
            GlobalVars.hiringManagerLoginGroup = properties.getProperty("hiringManagerLoginGroup");
            GlobalVars.additionalBranchReviewRequired = properties.getProperty("additionalBranchReviewRequired");
            GlobalVars.additionalReqReviewerSystemId  = properties.getProperty("additionalReqReviewerSystemId");
            GlobalVars.additionalReqReviewerFullName  = properties.getProperty("additionalReqReviewerFullName");
            GlobalVars.additionalReqReviewerEmail     = properties.getProperty("additionalReqReviewerEmail");
            GlobalVars.additionalReqReviewerPhone     = properties.getProperty("additionalReqReviewerPhone");
            GlobalVars.additionalReqReviewerHomeAddress = properties.getProperty("additionalReqReviewerHomeAddress");
            GlobalVars.primaryRecruiterSystemID = properties.getProperty("primaryRecruiterSystemID");
            GlobalVars.primaryRecruiterFullName = properties.getProperty("primaryRecruiterFullName");
            GlobalVars.primaryRecruiterEmail    = properties.getProperty("primaryRecruiterEmail");
            GlobalVars.primaryRecruiterPhone    = properties.getProperty("primaryRecruiterPhone");
            GlobalVars.primaryRecruiterHomeAddress   = properties.getProperty("primaryRecruiterHomeAddress");
            GlobalVars.interviewLocationAddress      = properties.getProperty("interviewLocationAddress");
            GlobalVars.administrativeSupportSystemID = properties.getProperty("administrativeSupportSystemID");
            GlobalVars.administrativeSupportFullName = properties.getProperty("administrativeSupportFullName");
            GlobalVars.administrativeSupportEmail    = properties.getProperty("administrativeSupportEmail");
            GlobalVars.administrativeSupportPhone    = properties.getProperty("administrativeSupportPhone");
            GlobalVars.administrativeSupportHomeAddress= properties.getProperty("administrativeSupportHomeAddress");
            GlobalVars.postingLocationLocation   = properties.getProperty("postingLocationLocation");
            GlobalVars.postingLocationAddress    = properties.getProperty("postingLocationAddress");
            GlobalVars.postingLocationAddress2    = properties.getProperty("postingLocationAddress2");
            GlobalVars.postingLocationCity       = properties.getProperty("postingLocationCity");
            GlobalVars.postingLocationState      = properties.getProperty("postingLocationState");
            GlobalVars.postingLocationPostalCode = properties.getProperty("postingLocationPostalCode");
            GlobalVars.postingLocationCountry    = properties.getProperty("postingLocationCountry");
            GlobalVars.requisitionPriority       = properties.getProperty("requisitionPriority");
            GlobalVars.videoInterviewingPackage  = properties.getProperty("videoInterviewingPackage");
            GlobalVars.firstInterviewerSystemID  = properties.getProperty("firstInterviewerSystemID");
            GlobalVars.firstInterviewerFullName  = properties.getProperty("firstInterviewerFullName");
            GlobalVars.firstInterviewerEmail     = properties.getProperty("firstInterviewerEmail");
            GlobalVars.firstInterviewerPhone     = properties.getProperty("firstInterviewerPhone");
            GlobalVars.firstInterviewerHomeAddress = properties.getProperty("firstInterviewerHomeAddress");
            GlobalVars.preEmploymentRequirements   = properties.getProperty("preEmploymentRequirements");
            GlobalVars.additionalQualifications    = properties.getProperty("additionalQualifications");
            GlobalVars.jobOfficeAddress1           = properties.getProperty("jobOfficeAddress1");
            GlobalVars.jobOfficeAddress2     = properties.getProperty("jobOfficeAddress2");
            GlobalVars.jobOfficeAddressCity  = properties.getProperty("jobOfficeAddressCity");
            GlobalVars.jobOfficeAddressState = properties.getProperty("jobOfficeAddressState");
            GlobalVars.jobOfficeAddressZip   = properties.getProperty("jobOfficeAddressZip");
            GlobalVars.jobOfficeAddressLocationName= properties.getProperty("jobOfficeAddressLocationName");
            GlobalVars.jobOfficeAddressEmail = properties.getProperty("jobOfficeAddressEmail");
            GlobalVars.BranchOfficeLocationHireVueEnabled = properties.getProperty("BranchOfficeLocationHireVueEnabled");



        }catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void setURL(String env, String ver) {

        Properties properties = new Properties();
        String fileName = "application-" + TestBase.env + ".properties";
        System.out.println(fileName);
        try {
            FileReader reader = new FileReader(fileName);
            properties.load(reader);

            GlobalVars.EMAIL_ID = properties.getProperty("EMAIL_ID");
            GlobalVars.BASE_URL = properties.getProperty("BASE_URL");
            GlobalVars.HOST = properties.getProperty("HOST");
            GlobalVars.PORT = Integer.parseInt(properties.getProperty("PORT"));
            GlobalVars.SFTP_AUTH_USERNAME = properties.getProperty("SFTP_AUTH_USERNAME");
            GlobalVars.SFTP_AUTH_PASSWORD = properties.getProperty("SFTP_AUTH_PASSWORD");
            GlobalVars.SFTP_LOCATION = properties.getProperty("SFTP_LOCATION");

            GlobalVars.DATABASE_URL = properties.getProperty("DATABASE_URL");
            GlobalVars.DATABASE_USERNAME = properties.getProperty("DATABASE_USERNAME");
            GlobalVars.DATABASE_PASSWORD = properties.getProperty("DATABASE_PASSWORD");

            GlobalVars.SPREADSHEETURL = properties.getProperty("SPREADSHEETURL");
            GlobalVars.SPREADSHEET_ID = properties.getProperty("SPREADSHEET_ID");
            GlobalVars.UPLOAD_PROGRESS_CHECK_URL = properties.getProperty("UPLOAD_PROGRESS_CHECK_URL");

            GlobalVars.USERNAME = properties.getProperty("USERNAME");
            GlobalVars.PASSWORD = properties.getProperty("PASSWORD");

            GlobalVars.SENDER = properties.getProperty("SENDER");
            GlobalVars.RECEIVER = properties.getProperty("RECEIVER");
            GlobalVars.SUBJECT = properties.getProperty("SUBJECT");
            GlobalVars.BODY = properties.getProperty("BODY");
            GlobalVars.fullFilePath = properties.getProperty("fullFilePath");


        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }



}
