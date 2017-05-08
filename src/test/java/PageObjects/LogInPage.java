package PageObjects;

import AutomationFramework.CommonTask;
import AutomationFramework.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LogInPage extends MainPage {

    @FindBy (css = "body > div.ng-scope > div > div.content.ng-scope > form > div > button")
    public WebElement login;

    @FindBy (css = "body > pre")
    public WebElement unauthorized;



    public LogInPage (WebDriver passedDriver) {
        super (passedDriver);
        PageFactory.initElements(passedDriver, this);
    }

   public void logInButton () {
       Wait.visible(driver, login);
       login.click();
   }

   public String unauthorizedMessage() {
       WebDriverWait wait = new WebDriverWait(driver, 2);
       wait.until(ExpectedConditions.elementToBeClickable(unauthorized));
       String message = unauthorized.getText();
       return message;
   }



}