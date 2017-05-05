package PageObjects;

import AutomationFramework.CommonTask;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.AssertJUnit;

import static PageObjects.MainPage.driver;

/**
 * Created by sraschitor on 14.04.2017.
 */
public class AccountInterfacePage extends MainPage {
    public AccountInterfacePage(WebDriver passedDriver) {
        super(passedDriver);
    }


    //locators
    @FindBy (css = "body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > div.page-head.ng-scope > div > h1 > span")
    public WebElement accountTitle;

    @FindBy (css = "body > div.ng-scope > div.page-header.navbar.navbar-fixed-top.ng-scope > div > div.page-top > div > ul > li.dropdown.dropdown-user.dropdown-dark > a > span")
    public WebElement userName;

    @FindBy (css = "body > div.ng-scope > div.page-header.navbar.navbar-fixed-top.ng-scope > div > div.page-top > div > ul > li.dropdown.dropdown-user.dropdown-dark > ul > li:nth-child(3) > a")
    public WebElement logoutButton;

    @FindBy (css ="body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > div.row.ng-scope > div > div.profile-sidebar > div > div.profile-userpic > img")
    public WebElement avatar;

    @FindBy (css = "#\\3a g\\2e select-files-button > div") //(fake selector for the purpose of failing the test)
    public WebElement picSelect;

    @FindBy (css = "body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > div.row.ng-scope > div > div.profile-sidebar > div > div.profile-usermenu > ul > li:nth-child(1) > a")
    public WebElement profileButton;

    @FindBy (css = "body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > div.row.ng-scope > div > div.profile-sidebar > div > div.profile-usermenu > ul > li:nth-child(2) > a")
    public WebElement vacationsButton;

    @FindBy (css = "#updateProfileForm > div:nth-child(2) > input")
    public WebElement firstNameField;

    @FindBy (css = "#updateProfileForm > div:nth-child(3) > input")
    public WebElement lastNameField;

    @FindBy (css = "#updateProfileForm > div:nth-child(4) > input")
    public WebElement emailField;

    @FindBy (css = "#updateProfileForm > div:nth-child(5) > input")
    public WebElement phoneNumberField;

    @FindBy (css = "#updateProfileForm > div:nth-child(6) > input")
    public WebElement personalEmailField;

    @FindBy (css = "#updateProfileForm > div:nth-child(7) > input")
    public WebElement dobField;

    @FindBy (css = "#updateProfileForm > div:nth-child(8) > input")
    public WebElement skypeField;

    @FindBy (css = "#updateProfileForm > div.margiv-top-10 > button")
    public WebElement saveProfileButton;

    @FindBy (css = "body > div.ui-notification.ng-scope.success.clickable")
    public WebElement saveSuccessPop;

    @FindBy (css = "body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > ul > li:nth-child(1) > a")
    public WebElement homeButton;

    @FindBy (css = "body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > div.row.ng-scope > div > div.profile-content.fade-in-up.ng-scope > div > div > div > div.portlet-title.tabbable-line.pull-left > ul > li.active > a")
    public WebElement statusTabButton;

    @FindBy (css = "#tab_1_1 > div > div:nth-child(1) > span")
    public WebElement vacationSummaryTab;

    @FindBy (css = "#tab_1_1 > div > div:nth-child(5) > span")
    public  WebElement vacationRequestsTab;

    @FindBy (css = "#tab_1_1 > div > div:nth-child(9) > span")
    public WebElement vacationDaysTab;

    @FindBy (css = "body > div.ng-scope > div.page-container > div.page-content-wrapper > div > div > div.row.ng-scope > div > div.profile-content.fade-in-up.ng-scope > div > div > div > div.portlet-title.tabbable-line.pull-left > ul > li:nth-child(2) > a")
    public WebElement newVacationRequestTab;

    @FindBy(css = "#requestVacationForm > div > div > div:nth-child(1) > select")
    public WebElement  vacationTypeField;

    @FindBy (css =  "#start-date")
    public WebElement vacationStartDateField;

    @FindBy (css = "#end-date")
    public WebElement vacationEndDateField;

    @FindBy (css = "#requestVacationForm > div > div > div:nth-child(5) > textarea")
    public WebElement vacationApprovedField;

    @FindBy (css = "#requestVacationForm > div > div > div:nth-child(6) > textarea")
    public WebElement vacationAdditionalInfoField;

    @FindBy (css = "#requestVacationForm > div > div > div.margiv-top-10 > button")
    public WebElement sendVacReqButton;



    //General methods in Account Interface page
    public void logoutAccount () {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        Actions action = new Actions(driver);
        action.moveToElement(userName);
        action.click(logoutButton).build().perform();
    }

    public void clickAndChangeAvatar () {
        avatar.click();
        picSelect.click();
        //next steps to change avatar picture should be added when feature is implemented
    }

    public void goToProfile () throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(profileButton));
        profileButton.click();
    }
    public void goToVacations() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(vacationsButton));
        vacationsButton.click();

    }


    public void editRequiredFields(String phone, String email, String skype){
        CommonTask.setInputField(driver, phoneNumberField, phone);
        CommonTask.setInputField(driver, personalEmailField, email);
        dobField.sendKeys("01", "01", "1980");                          //send keys from keyboard method
        CommonTask.setInputField(driver, skypeField, skype);
        saveProfileButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOf(saveSuccessPop));
    }

    public void leaveProfileAndReturn() {
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(homeButton));
        homeButton.click();
        profileButton.click();

    }

    public void goToNewVacReq() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(newVacationRequestTab));
        newVacationRequestTab.click();
    }

    public void createNewVacReq(String type, String approver, String aditional) {
        CommonTask.setDropDownField(driver, vacationTypeField, type);
        vacationStartDateField.click();
        vacationStartDateField.sendKeys("2017-","09-","09");
        vacationEndDateField.click();
        vacationEndDateField.sendKeys("2017-","09-","15");
        CommonTask.setInputField(driver, vacationApprovedField, approver);
        CommonTask.setInputField(driver, vacationAdditionalInfoField, aditional);
        sendVacReqButton.click();
    }



    //Get details from fields
    public String getUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }

    public String getAccountTitle(){
        String accTitle = accountTitle.getText();
        return accTitle;
    }

    public String getAccUserName() {
        String accUserName = userName.getText();
        return accUserName;
    }

    public String getProfileButtonDetails(){
        String profile = profileButton.getText();
        return profile;
    }

    public String getVacationsButtonDetail() {
        String vacations = vacationsButton.getText();
        return vacations;
    }

    public boolean getFirstNameFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        boolean firstName = firstNameField.getAttribute("readonly").equals("true");
        return firstName;
    }

    public boolean getLastNameFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        boolean lastName = lastNameField.getAttribute("readonly").equals("true");
        return lastName;
    }

    public boolean getEmailFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        boolean email = emailField.getAttribute("readonly").equals("true");
        return email;
    }

    public boolean getPhoneNumberFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        boolean phoneNumber = phoneNumberField.getAttribute("required").equals("true");
        return phoneNumber;
    }

    public boolean getPersonalEmailFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(personalEmailField));
        boolean personalEmail = personalEmailField.getAttribute("required").equals("true");
        return personalEmail;
    }
    public boolean getDateOfBirthFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(dobField));
        boolean dob = dobField.getAttribute("required").equals("true");
        return dob;
    }

    public boolean getSkypeFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(skypeField));
        boolean skype = skypeField.getAttribute("required").equals("true");
        return skype;
    }

    public String getFirstNameFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
        String name = firstNameField.getAttribute("value");
        return name;
    }

    public String getLastNameFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        String name = lastNameField.getAttribute("value");
        return name;
    }

    public String getEmailFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        String email = emailField.getAttribute("value");
        return email;
    }

    public String getPhoneNumberFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField));
        String phone = phoneNumberField.getAttribute("value");
        return phone;
    }

    public String getPersonalEmailFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(personalEmailField));
        String email = personalEmailField.getAttribute("value");
        return email;
    }

    public String getDoBFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(dobField));
        String dob = dobField.getAttribute("value");
        return dob;
    }

    public String getSkypeFieldDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(skypeField));
        String skype = skypeField.getAttribute("value");
        return skype;
    }

    public String getStatusTabDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(statusTabButton));
        String status = statusTabButton.getText();
        return status;
    }

    public String getVacationSummaryDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationSummaryTab));
        String summary = vacationSummaryTab.getText();
        return summary;
    }

    public String getVacationRequestsDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationRequestsTab));
        String requests = vacationRequestsTab.getText();
        return requests;
    }

    public String getVacationDaysDetails() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationDaysTab));
        String days = vacationDaysTab.getText();
        return days;
    }

    public boolean getVacationTypeRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(vacationTypeField));
        boolean vacation = vacationTypeField.getAttribute("required").equals("true");
        return vacation;
    }

    public boolean getVacationStartDayRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationStartDateField));
        boolean startDate = vacationStartDateField.getAttribute("required").equals("true");
        return startDate;
    }

    public boolean getVacationEndDayRestriction(){
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationEndDateField));
        boolean endDay = vacationEndDateField.getAttribute("required").equals("true");
        return endDay;
    }

    public boolean getApprovedByFieldRestriction() {
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationApprovedField));
        boolean approve = vacationApprovedField.getAttribute("required").equals("true");
        return approve;
    }

    public boolean getAdditionalInfoFieldRestriction() {                                            //this method verifies if a certain attribute is missing from an element
        WebDriverWait wait = new WebDriverWait(driver, 0,500);
        wait.until(ExpectedConditions.visibilityOf(vacationAdditionalInfoField));
        boolean additional = vacationAdditionalInfoField.getAttribute("required") == null;
        return additional;
    }











    //Create string arrays for assert
    public String[] getAccountInterfaceDetails (){
        String[] details = {
                    getUrl(),
                    getTitle(),
                    getAccountTitle(),
                    getAccUserName(),
                    getProfileButtonDetails(),
                    getVacationsButtonDetail()
        };
        return details;
    }

    public Boolean[] getProfileRestrictedFields() {
        Boolean[] details = {
                getFirstNameFieldRestriction(),
                getLastNameFieldRestriction(),
                getEmailFieldRestriction(),
                getPhoneNumberFieldRestriction(),
                getPersonalEmailFieldRestriction(),
                getDateOfBirthFieldRestriction(),
                getSkypeFieldRestriction()
        };
        return details;

    }

    public String [] getProfileFieldsDetails() {
        String[] details = {
                getFirstNameFieldDetails(),
                getLastNameFieldDetails(),
                getEmailFieldDetails(),
                getPhoneNumberFieldDetails(),
                getPersonalEmailFieldDetails(),
                getDoBFieldDetails(),
                getSkypeFieldDetails()
        };
        return details;
    }

    public String[] getVacationsStatusDetails() {
        String[] details = {
                getStatusTabDetails(),
                getVacationSummaryDetails(),
                getVacationRequestsDetails(),
                getVacationDaysDetails()
        };
        return details;
    }

    public Boolean [] getNewVacationReqFields(){
        Boolean[] details = {
                getVacationTypeRestriction(),
                getVacationStartDayRestriction(),
                getVacationEndDayRestriction(),
                getApprovedByFieldRestriction(),
                getAdditionalInfoFieldRestriction()
        };
        return details;
    }



}
