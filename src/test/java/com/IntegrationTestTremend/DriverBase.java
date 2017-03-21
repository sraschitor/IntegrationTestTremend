package com.IntegrationTestTremend;

import com.IntegrationTestTremend.config.DriverFactory;
import mx4j.tools.adaptor.PlainAdaptorServerSocketFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DriverBase extends TestListenerAdapter {

    private static List<DriverFactory> webDriverThreadPool = Collections.synchronizedList(new ArrayList<DriverFactory>());
    private static ThreadLocal<DriverFactory> driverFactory;

    @BeforeMethod(alwaysRun = true)
    public static void instantiateDriverObject() {
        driverFactory = new ThreadLocal<DriverFactory>() {
            @Override
            protected DriverFactory initialValue() {
                DriverFactory driverFactory = new DriverFactory();
                webDriverThreadPool.add(driverFactory);
                return driverFactory;
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        return driverFactory.get().getDriver();
    }

    //get test result

    @Override
    public void onTestFailure (ITestResult result){
        System.out.println("The test run was a Failure");
    }

    @Override
    public void onTestSuccess (ITestResult result){
        System.out.println("The test run was a Success");
    }

    @Override
    public void onTestSkipped (ITestResult result) {
        System.out.println ("The test run was skipped");
    }

    @AfterMethod(alwaysRun = true)
    public static void  closeDriverObjects(Method method, ITestResult result ) {

        //get test name
        String testName = method.getName();
        System.out.println("The test that just ran was...." + testName);

       //get test result
        int res = result.getStatus();
        switch (res) {
            case ITestResult.FAILURE:
                System.out.println ("Test has failed");
                break;
            case ITestResult.SUCCESS:
                System.out.println("Test has passed");
                break;
            default: System.out.println("Test has encountered errors");
        }

        //close browser
        for (DriverFactory driverFactory : webDriverThreadPool) {
            driverFactory.quitDriver();
        }


    }
}
