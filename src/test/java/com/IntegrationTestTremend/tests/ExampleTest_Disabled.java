package com.IntegrationTestTremend.tests;

import AutomationFramework.DataItems;
import com.IntegrationTestTremend.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExampleTest_Disabled extends DriverBase {

    @Test
            (groups = ("Test"), enabled = false) //Disabled test
    public void Example_01() throws Exception {
        WebDriver driver = getDriver();

        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("Test short description", "TestID (Example_01)", DataItems.validUsername, DataItems.validPassword);

    }
}