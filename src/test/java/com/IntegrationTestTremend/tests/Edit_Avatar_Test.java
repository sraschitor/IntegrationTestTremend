package com.IntegrationTestTremend.tests;


import AutomationFramework.DataItems;
import PageObjects.AccountInterfacePage;
import com.IntegrationTestTremend.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(DriverBase.class)

public class Edit_Avatar_Test extends DriverBase {

    @Test (groups = "Test")

    public void EA_1() throws Exception {

        WebDriver driver = getDriver();

        //Log in test environment
        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("EA_1", "TestID (EDAV)", DataItems.validUsername, DataItems.validPassword);
        System.out.println("You have successfully logged in test environment. Proceed with testing...");

        //Click Profile picture in order to change it
        AccountInterfacePage aip = new AccountInterfacePage(driver);
        aip.clickAndChangeAvatar(); // Fails due to issue TEST-749



    }


}
