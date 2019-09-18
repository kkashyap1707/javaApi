package javaApi.utilities;


public final class GlobalVars {

    private static GlobalVars globalVars;

    public static GlobalVars getInstance() {
        if (globalVars == null) {
            globalVars = new GlobalVars();
        }
        return globalVars;
    }

    public String REPORT_FOLDER_ROOT_NAME = "Allyo-JobReq";
    public String EXTENT_CONFIG_FILE = "extent-config.xml";
    public String CONTENT_TYPE = "application/json";


    public String getREPORT_FOLDER_ROOT_NAME() {
        return REPORT_FOLDER_ROOT_NAME;
    }

    public String getEXTENT_CONFIG_FILE() {
        return EXTENT_CONFIG_FILE;
    }

    public String getCONTENT_TYPE() {
        return CONTENT_TYPE;
    }

    public static String BASE_URL;
    public static String HOST;
    public static Integer PORT;
    public static String SFTP_AUTH_USERNAME;
    public static String SFTP_AUTH_PASSWORD;

    public static String DATABASE_URL;
    public static String DATABASE_USERNAME;
    public static String DATABASE_PASSWORD;

    public static String SPREADSHEETURL;
    public static String SPREADSHEET_ID;
    public static String UPLOAD_PROGRESS_CHECK_URL;

    public static String USERNAME;
    public static String PASSWORD;

    public static String SFTP_LOCATION;

    public static String EMAIL_ID;

    public static String RECEIVER;
    public static String SENDER;
    public static String SUBJECT;
    public static String BODY;
    public static String fullFilePath;

    public static class v1 {

    }

    public static class V2 {

    }


    public static String SystemId;
    public static String createdDate;
    public static String updatedDate;
    public static String applyURL;
    public static String noOfPeople;
    public static String noOfPeopleNeededRemaining;
    public static String category;
    public static String additionalRequirements;
    public static String additionalLicensesNotListed;
    public static String employmentType;
    public static String jobFolderStatus;
    public static String licensesCertification;
    public static String orientationLocation;
    public static String otherSpecialRequirements;
    public static String physicalRequirements;
    public static String positionId;
    public static String postingTitle;
    public static String winTeamPositionTitle;
    public static String requisitionId;
    public static String securityClearance;
    public static String shiftsAvailable;
    public static String hiringManagerSystemID;
    public static String hiringManageFullName;
    public static String hiringManagerEmail;
    public static String hiringManagerPhone;
    public static String hiringManagerAddress;
    public static String hiringManagerLoginGroup;
    public static String additionalBranchReviewRequired;
    public static String additionalReqReviewerSystemId;
    public static String additionalReqReviewerFullName;
    public static String additionalReqReviewerEmail;
    public static String additionalReqReviewerPhone;
    public static String additionalReqReviewerHomeAddress;
    public static String primaryRecruiterSystemID;
    public static String primaryRecruiterFullName;
    public static String primaryRecruiterEmail;
    public static String primaryRecruiterPhone;
    public static String primaryRecruiterHomeAddress;
    public static String interviewLocationAddress;
    public static String administrativeSupportSystemID;
    public static String administrativeSupportFullName;
    public static String administrativeSupportEmail;
    public static String administrativeSupportPhone;
    public static String administrativeSupportHomeAddress;
    public static String postingLocationLocation;
    public static String postingLocationAddress;
    public static String postingLocationAddress2;
    public static String postingLocationCity;
    public static String postingLocationState;
    public static String postingLocationPostalCode;
    public static String postingLocationCountry;
    public static String requisitionPriority;
    public static String videoInterviewingPackage;
    public static String firstInterviewerSystemID;
    public static String firstInterviewerFullName;
    public static String firstInterviewerEmail;
    public static String firstInterviewerPhone;
    public static String firstInterviewerHomeAddress;
    public static String preEmploymentRequirements;
    public static String additionalQualifications;
    public static String jobOfficeAddress1;
    public static String jobOfficeAddress2;
    public static String jobOfficeAddressCity;
    public static String jobOfficeAddressState;
    public static String jobOfficeAddressZip;
    public static String jobOfficeAddressLocationName;
    public static String jobOfficeAddressEmail;
    public static String BranchOfficeLocationHireVueEnabled;


    public static String inputValue[] = {GlobalVars.SystemId,GlobalVars.createdDate,
            GlobalVars.updatedDate,GlobalVars.applyURL,GlobalVars.noOfPeople,GlobalVars.noOfPeopleNeededRemaining,GlobalVars.category,
            GlobalVars.additionalRequirements,GlobalVars.additionalLicensesNotListed,GlobalVars.employmentType,GlobalVars.jobFolderStatus,
            GlobalVars.licensesCertification,GlobalVars.orientationLocation,GlobalVars.otherSpecialRequirements,GlobalVars.physicalRequirements,
            GlobalVars.positionId,GlobalVars.postingTitle,GlobalVars.winTeamPositionTitle,GlobalVars.requisitionId,GlobalVars.securityClearance,
            GlobalVars.shiftsAvailable,GlobalVars.hiringManagerSystemID,GlobalVars.hiringManageFullName,GlobalVars.hiringManagerEmail,
            GlobalVars.hiringManagerPhone,GlobalVars.hiringManagerAddress,GlobalVars.hiringManagerLoginGroup,GlobalVars.additionalBranchReviewRequired,
            GlobalVars.additionalReqReviewerSystemId,GlobalVars.additionalReqReviewerFullName,GlobalVars.additionalReqReviewerEmail,
            GlobalVars.additionalReqReviewerPhone,GlobalVars.additionalReqReviewerHomeAddress,GlobalVars.primaryRecruiterSystemID,
            GlobalVars.primaryRecruiterFullName,GlobalVars.primaryRecruiterEmail,GlobalVars.primaryRecruiterPhone,GlobalVars.primaryRecruiterHomeAddress,
            GlobalVars.interviewLocationAddress,GlobalVars.administrativeSupportSystemID,GlobalVars.administrativeSupportFullName,
            GlobalVars.administrativeSupportEmail,GlobalVars.administrativeSupportPhone,GlobalVars.administrativeSupportHomeAddress,
            GlobalVars.postingLocationLocation,GlobalVars.postingLocationAddress,GlobalVars.postingLocationAddress2,GlobalVars.postingLocationCity,
            GlobalVars.postingLocationState,GlobalVars.postingLocationPostalCode,GlobalVars.postingLocationCountry,GlobalVars.requisitionPriority,
            GlobalVars.videoInterviewingPackage,GlobalVars.firstInterviewerSystemID,GlobalVars.firstInterviewerFullName,GlobalVars.firstInterviewerEmail,
            GlobalVars.firstInterviewerPhone,GlobalVars.firstInterviewerHomeAddress,GlobalVars.preEmploymentRequirements,GlobalVars.additionalQualifications,
            GlobalVars.jobOfficeAddress1,GlobalVars.jobOfficeAddress2,GlobalVars.jobOfficeAddressCity,GlobalVars.jobOfficeAddressCity,
            GlobalVars.jobOfficeAddressState,GlobalVars.jobOfficeAddressZip,GlobalVars.jobOfficeAddressLocationName,GlobalVars.jobOfficeAddressEmail,
            GlobalVars.BranchOfficeLocationHireVueEnabled};


}