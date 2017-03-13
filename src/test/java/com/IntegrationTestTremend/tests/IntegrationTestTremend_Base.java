package com.IntegrationTestTremend.tests;
import AutomationFramework.DataItems;
import PageObjects.MainPage;
import org.openqa.selenium.WebDriver;

public class IntegrationTestTremend_Base {

    WebDriver driver;

    public IntegrationTestTremend_Base(WebDriver passedDriver) {
        driver = passedDriver;
    }

    public void setUp(String testTitle, String scenarioID) {

        System.out.println("TEST: "+testTitle);
        System.out.println("Scenario ID: "+scenarioID);

        //Navigate to QA site
        System.out.println("Navigating to QA Environment...");
        driver.get(DataItems.targetURL);

        //Maximize browser window
        driver.manage().window().maximize();
    }

    public void setUp(String testTitle, String scenarioID, String username, String password) {

        System.out.println("TEST: "+testTitle);
        System.out.println("Scenario ID: "+scenarioID);

        //Navigate to QA site
        System.out.println("Navigating to Environment...");
        driver.get(DataItems.targetURL);

        //Maximize browser window
        driver.manage().window().maximize();

        MainPage mp = new MainPage(driver);

        //Login with valid credentials
        //mp.loginWithUsernameAndPassword(username, password);
    }
}
