package com.IntegrationTestTremend.tests;

import AutomationFramework.DataItems;
import PageObjects.AccountInterfacePage;
import com.IntegrationTestTremend.DriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by sraschitor on 04.05.2017.
 */

@Listeners(DriverBase.class)

public class VacationPage_Status_Request_Test extends DriverBase {

    @Test(groups = {"Tengine"})

    public void VP_R_1() throws Exception {

        WebDriver driver = getDriver();

        //Log in test environment
        IntegrationTestTremend_Base base = new IntegrationTestTremend_Base(driver);
        base.setUp("VP_R_1", "TestID (VPSR)", DataItems.validUsername, DataItems.validPassword);
        System.out.println("You have successfully logged in test environment. Proceed with testing...");

        //Go to vacations section
        AccountInterfacePage aip = new AccountInterfacePage(driver);
        aip.goToVacations();
        System.out.println("You have reached Vacations section. Now verify the Status tab and the three separate sections...");

        //Assert Status tab and the three separate sections
        AssertJUnit.assertArrayEquals("The Status tab contains incorrect details", DataItems.vacationsStatusFields, aip.getVacationsStatusDetails());
        System.out.println("Details are correct in Status tab. Proceed with New Vacation Request tab check...");

        //Go to New Vacation Request tab and check
        aip.goToNewVacReq();
        System.out.println("You have reached New Vacation Request tab, check the mandatory fields...");
        AssertJUnit.assertArrayEquals("The fields are not correctly set as mandatory", DataItems.newVacationReqFields, aip.getNewVacationReqFields());
        System.out.println("You have checked the mandatory and optional fields. Now create a new vacations request... ");

        //Create a new vacation request
        aip.createNewVacReq(DataItems.vacTypeCO, DataItems.vacApprover, DataItems.vacAddInfo);




    }
}
