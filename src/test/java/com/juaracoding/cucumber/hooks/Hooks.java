package com.juaracoding.cucumber.hooks;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 02.01
@Last Modified 23/03/25 02.01
Version 1.0
*/


import com.juaracoding.cucumber.utils.Browser;
import com.juaracoding.cucumber.utils.DriverSingleton;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static ExtentReports reports;
    public static ExtentTest extentTest;

    @Before
    public void setup(Scenario scenario){
        DriverSingleton.setDriver(Browser.CHROME);
        if (reports == null) {
            reports = new ExtentReports("target/extent-report.html");
        }
        extentTest = reports.startTest(scenario.getName());
    }

    @After
    public void endScenarioTest(Scenario scenario){
        if (scenario.isFailed()) {
            extentTest.log(com.relevantcodes.extentreports.LogStatus.FAIL, "Scenario Failed: " + scenario.getName());
        } else {
            extentTest.log(com.relevantcodes.extentreports.LogStatus.PASS, "Scenario Passed: " + scenario.getName());
        }
        reports.endTest(extentTest);
        reports.flush();

        DriverSingleton.exit();
    }

}
