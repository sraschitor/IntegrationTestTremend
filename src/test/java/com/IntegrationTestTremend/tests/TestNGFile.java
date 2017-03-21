package com.IntegrationTestTremend.tests;

import AutomationFramework.DataItems;
import com.IntegrationTestTremend.DriverBase;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import org.testng.Assert;



/**
 * Created by sraschitor on 17.03.2017.
 */

@Listeners (DriverBase.class)

public class TestNGFile extends DriverBase {



    @Test (groups = "Test")

    public void TestNGReports() throws Exception {
        WebDriver driver = getDriver();

        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("TestNG Reports", "TestID (TNGR)");

        String expectedTitle = "GitHub - sraschitor/IntegrationTestTremend: Automation Framework and CI @Tremend";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);





    }

}