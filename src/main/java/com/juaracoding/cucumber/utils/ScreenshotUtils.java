package com.juaracoding.cucumber.utils;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/15/2025 8:25 AM
@Last Modified 4/15/2025 8:25 AM
Version 1.0
*/

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import static com.juaracoding.cucumber.utils.DateUtil.*;

public class ScreenshotUtils {

    public static String captureScreenshot(WebDriver driver, String scenarioName) {
        String timeStamp = getTimestamp();
        String dateFolder = getTodayDateFolder();
        String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timeStamp + ".png";

        String directory = "target/reports/" + dateFolder + "/screenshots/";
        String fullPath = directory + screenshotName;

        try {
            // Buat folder kalau belum ada
            File folder = new File(directory);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(fullPath));

            // relatif ke "target/extent-report.html"
            return "screenshots/" + screenshotName;

        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return null;
        }
    }

}
