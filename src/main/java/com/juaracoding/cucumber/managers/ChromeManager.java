package com.juaracoding.cucumber.managers;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 01.30
@Last Modified 23/03/25 01.30
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeManager {

    public static WebDriver buildDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-password-generation");
        options.addArguments("--disable-save-password-bubble");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.popups", 2);

        options.setExperimentalOption("prefs", prefs);

// Kalau mau pakai profile baru:
// options.addArguments("user-data-dir=/tmp/chrome-profile");

        return new ChromeDriver(options);
    }

}
