package com.juaracoding.cucumber.runner;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 13/04/25 11.54
@Last Modified 13/04/25 11.54
Version 1.0
*/


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/features/Login.feature",
        glue = {"com/juaracoding/cucumber/stepdefinitions" , "com/juaracoding/cucumber/hooks"},
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"})


public class TestRunner extends AbstractTestNGCucumberTests {
}
