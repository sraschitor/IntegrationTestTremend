package PageObjects;

import AutomationFramework.CommonTask;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    //Declare WebDriver
    protected static WebDriver driver;

    public MainPage(WebDriver passedDriver) {
        this.driver = passedDriver;
        PageFactory.initElements(passedDriver, this);
    }

    //Set locators for bellow elements

    @FindBy(id = "identifierId")
    public WebElement usernameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(css = "#identifierNext > content > span")
    public WebElement nextEmailButton;

    @FindBy (css = "#passwordNext > content > span")
    public WebElement nextPswdButton;


    @FindBy(id = "signIn")
    public WebElement signIn;


    public void loginWithUsernameAndPassword(String username, String password) throws InterruptedException {
        CommonTask.setInputField(driver, usernameField, username);
        nextEmailButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        CommonTask.setInputField(driver, passwordField, password);
        nextPswdButton.click();
        Thread.sleep(1500);




    }



}
