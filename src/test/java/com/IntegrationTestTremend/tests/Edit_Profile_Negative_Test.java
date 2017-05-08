package com.IntegrationTestTremend.tests;

import AutomationFramework.DataItems;
import PageObjects.AccountInterfacePage;
import com.IntegrationTestTremend.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;

/**
 * Created by sraschitor on 04.05.2017.
 */

@Listeners(DriverBase.class)

public class Edit_Profile_Negative_Test extends DriverBase  {

    @Test (groups = "Tengine")

    public void EP_N_1 () throws Exception {

        WebDriver driver = getDriver();

        //Log in test environment
        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("EP_N_1", "TestID (EDPRN)", DataItems.validUsername, DataItems.validPassword);
        System.out.println("You have successfully logged in test environment. Proceed with testing...");

        //Go to profile, make the changes and leave without saving
        AccountInterfacePage aip = new AccountInterfacePage(driver);
        aip.goToProfile();
        System.out.println("Change the profile fields with negative details; then leave without saving... ");
        aip.editRequiredFields(DataItems.phoneNumberNeg, DataItems.personalEmailNeg, DataItems.skypeAddressNeg);
        System.out.println("Fields have been successfully edited. Now leave the section without saving...");
        aip.leaveProfileAndReturn();

        //Verify if the changes remain even though you have not explicitly saved them
        System.out.println("You have left the section before saving and return, now assert if the changes are reverted");
        Assert.assertNotEquals(aip.phoneNumberField.getAttribute("value"), DataItems.phoneNumberNeg ,"The changes remain even though they are not saved");
        Assert.assertNotEquals(aip.personalEmailField.getAttribute("value"), DataItems.personalEmailNeg, "The changes remain even though they are not saved");
        Assert.assertNotEquals(aip.skypeField.getAttribute("value"), DataItems.skypeAddressNeg, "The changes remain even though they are not saved");
        System.out.println("The changes correctly do not remain after you have left the section without saving. Proceed with logging out...");

        //Log out of test environment
        aip.logoutAccount();
        System.out.println("You have successfully logged out of test environment...");



    }


}
