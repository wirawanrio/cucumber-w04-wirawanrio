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
import com.juaracoding.cucumber.utils.ScreenshotUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.juaracoding.cucumber.utils.DateUtil.*;

public class Hooks {

    public static ExtentReports reports;
    public static ExtentTest extentTest;

    @Before
    public void setup(Scenario scenario){
        DriverSingleton.setDriver(Browser.CHROME);
        String dateFolder = getTodayDateFolder();

        if (reports == null) {
            String reportPath = "target/reports/" + dateFolder + "/extent-report.html";
            reports = new ExtentReports(reportPath);
        }
        extentTest = reports.startTest(scenario.getName());
    }

    @After
    public void endScenarioTest(Scenario scenario){
        if (scenario.isFailed()) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(DriverSingleton.getDriver(), scenario.getName());
            extentTest.log(LogStatus.FAIL, "Scenario Failed: " + scenario.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));
        } else {
            extentTest.log(LogStatus.PASS, "Scenario Passed: " + scenario.getName());
        }
        reports.endTest(extentTest);
        reports.flush();

        DriverSingleton.exit();
    }

}
