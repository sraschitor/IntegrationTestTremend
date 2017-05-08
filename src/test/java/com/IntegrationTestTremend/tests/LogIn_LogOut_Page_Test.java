package com.IntegrationTestTremend.tests;


import AutomationFramework.CommonTask;
import AutomationFramework.DataItems;
import PageObjects.AccountInterfacePage;
import PageObjects.LogInPage;
import com.IntegrationTestTremend.DriverBase;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.zip.DataFormatException;

@Listeners(DriverBase.class)

public class LogIn_LogOut_Page_Test extends DriverBase {


    @Test (groups = "Tengine")

    public void LogIn_1() throws Exception {

        WebDriver driver = getDriver();

        //Log in test environment
        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("LogIn_1", "TestID (LGIN)", DataItems.validUsername, DataItems.validPassword);
        System.out.println("You have successfully logged in test environment. Proceed with testing...");

        //Assert if the page landed is indeed the one required: Account Interface page
        AccountInterfacePage aip = new AccountInterfacePage(driver);
        AssertJUnit.assertArrayEquals("The page reached is not the Account Interface or it has the incorrect elements", DataItems.accountInterfaceElements,aip.getAccountInterfaceDetails());
        System.out.println("You have successfully reached Account Interface page. Log out of the account...");

        //Log out of the account
        aip.logoutAccount();
        System.out.println("You have logged out of the account, now verify the log out...");

        //Assert if the logout was successful
        Assert.assertEquals(driver.getCurrentUrl(), DataItems.webAppUrl, "The page reached is not the homepage of logout from WebApp");
        System.out.println("User successfully logged out of test environment web app.");

    }

    @Test (groups = "Tengine")

    public void logIn_Neg_2() throws Exception {
        WebDriver driver = getDriver();

        //Log in test environment with invalid username
        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("LogIn_Neg_2", "TestID (LGINN2)", DataItems.inValidUsername, DataItems.inValidPassword);
        System.out.println("You have attempted to log in test environment with invalid username. Proceed with asserting unauthorized message...");

        //Assert unauthorized message
        LogInPage lg = new LogInPage(driver);
        AssertJUnit.assertEquals("You have not received the unauthorized message when attempted to log in with invalid username", DataItems.invalidUsernameMessage, lg.unauthorizedMessage());
        System.out.println("You have been successfully restricted from accessing the Test environment with an invalid username");
    }
}
