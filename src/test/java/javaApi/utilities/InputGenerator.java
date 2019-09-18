package javaApi.utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public  class InputGenerator {


    //Locale locale = new Locale("en-IND"); // It will generate India specific data.
    public static Locale locale = new Locale("en-US"); // It will generate US specific data.
    public static Faker faker = new Faker(locale);

    public static String stateCode = faker.address().stateAbbr();
    public static String timeZone = faker.address().timeZone();

    public static String hiringManageFullName = faker.name().fullName();
    public static String administrativeSupportFullName = faker.name().fullName();
    public static String primaryRecruiterFullName = faker.name().fullName();
    public static String firstInterviewerFullName = faker.name().fullName();
    public static String additionalReqReviewerFullName = faker.name().fullName();

    public static String primaryRecruiterPhone = faker.phoneNumber().phoneNumber();
    public static String hiringManagerPhone = faker.phoneNumber().phoneNumber();
    public static String additionalReqReviewerPhone = faker.phoneNumber().phoneNumber();
    public static String administrativeSupportPhone = faker.phoneNumber().phoneNumber();
    public static String firstInterviewerPhone = faker.phoneNumber().phoneNumber();

    public static String cellPhoneNumber = faker.phoneNumber().cellPhone();
    public static String email = faker.internet().emailAddress();
    //String alphaNumericString = fakeValuesService.regexify("[a-z1-9]{10}");

    public static String createdDate = DateUtil.currentDateTime("MM/dd/yyyy hh:mm:ss a",timeZone);
    public static String updatedDate = DateUtil.currentDateTime("MM/dd/yyyy hh:mm:ss a",timeZone);

    public static String hiringManagerEmail = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");
    public static String additionalReqReviewerEmail = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");
    public static String primaryRecruiterEmail = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");
    public static String administrativeSupportEmail = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");
    public static String firstInterviewerEmail = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");

    //public static String firstInterviewerEmailBlank = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");
    public static String jobOfficeAddressEmail = faker.bothify(InputGenerator.faker.name().username()+"@allyo.com");

    public static String postingLocationPostalCode = faker.address().zipCodeByState(stateCode);
    public static String jobOfficeAddressZip = faker.address().zipCodeByState(stateCode);

    public static String jobOfficeAddressCity =faker.address().city();
    public static String postingLocationCity =faker.address().city();

    public static String postingLocationState =faker.address().stateAbbr();
    public static String jobOfficeAddressState =faker.address().stateAbbr();

    public static String postingLocationCountry = faker.address().countryCode();

    public static String otherSpecialRequirements = faker.job().title();
    public static String winTeamPositionTitle = faker.job().title();
    public static String postingTitle = faker.job().position();


    public static String postingLocationLocation = faker.address().streetAddress() + ", " +postingLocationCity;
    public static String jobOfficeAddressLocationName = faker.address().streetAddress() + ", " +jobOfficeAddressCity;

    public static String postingLocationAddress = "";
    public static String postingLocationAddress2 = "";

    public static String jobOfficeAddress1 = "";
    public static String jobOfficeAddress2 = "";

    public static String additionalQualifications = "";
    public static String additionalBranchReviewRequired = "";
    public static String interviewLocationAddress = "";
    public static String preEmploymentRequirements = "";

    public static String additionalRequirements = "";
    public static String additionalLicensesNotListed = "";

    public static String physicalRequirements = "";
    public static String requisitionPriority = "";
    public static String positionId = "";
    public static String BranchOfficeLocationHireVueEnabled = "";

    public static String videoInterviewingPackage = "HireVue Standard";
    public static String orientationLocation = "Branch Office";
    public static String licensesCertification = "CPR Certification";
    public static String employmentType = "Part Time";
    public static String jobFolderStatus = "Approved";
    public static String securityClearance = "Not Applicable";
    public static String shiftsAvailable = "Afternoon, Evening, Morning, Overnight";
    public static String hiringManagerLoginGroup ="Hiring Manager (AllyO Enabled)";

    public static String administrativeSupportHomeAddress = postingLocationCountry +"-"+postingLocationState+"-"+postingLocationCity;
    public static String primaryRecruiterHomeAddress = postingLocationCountry +"-"+postingLocationState+"-"+postingLocationCity;
    public static String additionalReqReviewerHomeAddress = postingLocationCountry +"-"+postingLocationState+"-"+postingLocationCity;
    public static String firstInterviewerHomeAddress = postingLocationCountry +"-"+postingLocationState+"-"+postingLocationCity;

    public static String hiringManagerAddress = postingLocationCountry +"-"+postingLocationState+"-"+postingLocationCity;
    public static String applyURL = "https://securitycareers-aus.icims.com/jobs/"+faker.numerify("######")+"/job";

    public static String SystemId = faker.numerify("######");
    public static String hiringManagerSystemID = faker.numerify("######");
    public static String additionalReqReviewerSystemId = faker.numerify("######");
    public static String primaryRecruiterSystemID = faker.numerify("######");
    public static String firstInterviewerSystemID = faker.numerify("######");
    public static String administrativeSupportSystemID = faker.numerify("#######");

    public static String noOfPeople = faker.numerify("##");
    public static String noOfPeopleNeededRemaining = faker.numerify("#");

    public static String requisitionId = DateUtil.currentYear("yyyy",timeZone)+"-"+faker.numerify("######");
    public static String category = faker.job().seniority();



    public static String inputValue1[] = {SystemId,

            createdDate,
            updatedDate,
            applyURL,
            noOfPeople,
            noOfPeopleNeededRemaining,
            category,
            additionalRequirements,
            additionalLicensesNotListed,
            employmentType,
            jobFolderStatus,
            licensesCertification,
            orientationLocation,
            otherSpecialRequirements,
            physicalRequirements,
            positionId,
            postingTitle,
            winTeamPositionTitle,
            requisitionId,
            securityClearance,
            shiftsAvailable,
            hiringManagerSystemID,
            hiringManageFullName,
            hiringManagerEmail,

            hiringManagerPhone,

            hiringManagerAddress,
            hiringManagerLoginGroup,
            additionalBranchReviewRequired,
            additionalReqReviewerSystemId,
            additionalReqReviewerFullName,
            additionalReqReviewerEmail,
            additionalReqReviewerPhone,
            additionalReqReviewerHomeAddress,
            primaryRecruiterSystemID,
            primaryRecruiterFullName,
            primaryRecruiterEmail,
            primaryRecruiterPhone,
            primaryRecruiterHomeAddress,
            interviewLocationAddress,
            administrativeSupportSystemID,
            administrativeSupportFullName,
            administrativeSupportEmail,
            administrativeSupportPhone,
            administrativeSupportHomeAddress,
            postingLocationLocation,
            postingLocationAddress,
            postingLocationAddress2,
            postingLocationCity,
            postingLocationState,
            postingLocationPostalCode,
            postingLocationCountry,
            requisitionPriority,
            videoInterviewingPackage,
            firstInterviewerSystemID,
            firstInterviewerFullName,
            firstInterviewerEmail,
            firstInterviewerPhone,
            firstInterviewerHomeAddress,
            preEmploymentRequirements,
            additionalQualifications,
            jobOfficeAddress1,
            jobOfficeAddress2,
            jobOfficeAddressCity,
            jobOfficeAddressState,
            jobOfficeAddressZip,
            jobOfficeAddressLocationName,
            jobOfficeAddressEmail,
            BranchOfficeLocationHireVueEnabled};

}
