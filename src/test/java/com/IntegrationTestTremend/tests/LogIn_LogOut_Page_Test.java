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


    @Test (groups = "Test")

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
}
