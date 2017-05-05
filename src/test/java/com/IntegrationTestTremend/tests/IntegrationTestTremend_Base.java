package com.IntegrationTestTremend.tests;
import AutomationFramework.DataItems;
import PageObjects.LogInPage;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class IntegrationTestTremend_Base {

    WebDriver driver;

    public IntegrationTestTremend_Base(WebDriver passedDriver) {
        driver = passedDriver;
    }

    public void setUp(String testTitle, String scenarioID) {

        System.out.println("TEST: "+testTitle);
        System.out.println("Scenario ID: "+scenarioID);

        //Navigate to test site
        System.out.println("Navigating to TEST Environment...");
        driver.get(DataItems.targetURL);


    }

    public void setUp(String testTitle, String scenarioID, String username, String password) throws InterruptedException {

        System.out.println("TEST: "+testTitle);
        System.out.println("Scenario ID: "+scenarioID);

        //Navigate to QA site
        System.out.println("Navigating to Environment...");
        driver.get(DataItems.targetURL);


        MainPage mp = new MainPage(driver);
        LogInPage lg = new LogInPage(driver);
        lg.logInButton();

        //Login with valid credentials
        mp.loginWithUsernameAndPassword(username, password);

    }
}
