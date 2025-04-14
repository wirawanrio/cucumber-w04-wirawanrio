package com.juaracoding.cucumber.utils;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 01.47
@Last Modified 23/03/25 01.47
Version 1.0
*/


import com.juaracoding.cucumber.strategies.DriverStrategies;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            throw new IllegalStateException("Driver not initialized");
        }

        return driver;

    }

    public static void setDriver(String browser){
        if (driver == null){
            driver = DriverStrategies.setStrategy(browser);
        }
    }


    public static void exit(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
