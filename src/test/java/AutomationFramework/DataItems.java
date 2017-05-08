package AutomationFramework;

import PageObjects.AccountInterfacePage;
import javax.xml.crypto.Data;

public class DataItems {

    public static String targetURL = "http://integration.tengine.tremend.ro/login"; //"https://github.com/sraschitor/IntegrationTestTremend"
    public static String validUsername = "sraschitor@tremend.ro";
    public static String validPassword = "Tremend2016";
    public static String inValidUsername = "cojoacesuport@gmail.com";
    public static String inValidPassword = "cojocarul";


    // -------------- Waiting Time
    public static int shortWait = 10;
    public static int longWait = 20;

    //URLs throughout app
    public static String webAppUrl ="http://integration.tengine.tremend.ro/logout";
    public static String accountInterfaceUrl = "http://integration.tengine.tremend.ro/account";
    public static String accountInterfaceTitle = "Tengine | Account";
    public static String invalidUsernameMessage = "Unauthorized";

    //Sections Titles
    public static String accUserName = "Sorin Gabriel";
    public static String accountTitle = "Account";

    //Profile personal details
    public static String userName = "Sorin Gabriel";
    public static String lastName = "Raschitor";
    public static String emailAdress = "sraschitor@tremend.ro";
    public static String phoneNumber = "0799.409.659";
    public static String phoneNumberNeg = "1234.567.890";
    public static String personalEmail = "gabrielraschi@gmail.com";
    public static String personalEmailNeg = "gabrielraschi@fake.com";
    public static String dateOfBirth = "1980-01-01";
    public static String skypeAddress = "sorin.raschitor";
    public static String skypeAddressNeg = "sorin.raschi";

    //Vacations details
    public static String vacTypeCO = "Concediu de odihna";
    public static String vacApprover = "GrandMaster Flash";
    public static String vacAddInfo = "Chillout & Netflix";



    // String arrays for asserts
    public static String[] accountInterfaceElements = {DataItems.accountInterfaceUrl, DataItems.accountInterfaceTitle, DataItems.accountTitle,
            DataItems.accUserName, "Profile", "Vacations" };

    public static Boolean [] profileRestrictedFields = {true, true, true, true, true, true, true };

    public static String[] profileFieldsDetails = {DataItems.userName, DataItems.lastName, DataItems.emailAdress, DataItems.phoneNumber, DataItems.personalEmail,
            DataItems.dateOfBirth, DataItems.skypeAddress};

    public static String[] vacationsStatusFields = {"Status", "VACATION SUMMARY", "VACATION REQUESTS", "VACATION DAYS"};

    public static Boolean[] newVacationReqFields = {true, true, true, true, true};




}