package com.IntegrationTestTremend.tests;


import AutomationFramework.DataItems;
import PageObjects.AccountInterfacePage;
import com.IntegrationTestTremend.DriverBase;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(DriverBase.class)

public class Edit_Profile_Test extends DriverBase {

    @Test (groups = "Test")

    public void EP_1() throws Exception {

        WebDriver driver = getDriver();

        //Log in test environment
        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("EP_1", "TestID (EDPR)", DataItems.validUsername, DataItems.validPassword);
        System.out.println("You have successfully logged in test environment. Proceed with testing...");

        //Go to profile section and assert fields that are locked and fields that can be edited
        AccountInterfacePage aip = new AccountInterfacePage(driver);
        aip.goToProfile();
        System.out.println("You have reached profile section, verify if the locked fields can be edited...");

        //boolean arrays compared
        AssertJUnit.assertArrayEquals("Fields are not correctly restricted or set to required", DataItems.profileRestrictedFields, aip.getProfileRestrictedFields());
        System.out.println("Fields restrictions are correct. Proceed with editing the profile...");

        //Make changes to the profile and save
        aip.editRequiredFields(DataItems.phoneNumber, DataItems.personalEmail, DataItems.skypeAddress);
        System.out.println("Fields have been successfully edited. Verify if the details have been correctly updated and saved...");

        //Assert if the Success pop-up is displayed and if the fields are saved correctly
        Assert.assertTrue("Save message has not been displayed", aip.saveSuccessPop.isDisplayed());
        System.out.println("Success save message has been displayed, proceed with fields verifications...");
        AssertJUnit.assertArrayEquals("Profile fields do not have the expected details", DataItems.profileFieldsDetails, aip.getProfileFieldsDetails());
        System.out.println("Profile fields contain the correct details. Proceed with logging out...");

        //Log out of test environment
        driver.navigate().refresh(); //refresh web page to clear the success save message faster
        aip.logoutAccount();
        System.out.println("You have successfully logged out of test environment...");

















    }


}
