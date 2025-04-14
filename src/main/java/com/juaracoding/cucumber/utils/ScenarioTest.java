package com.juaracoding.cucumber.utils;

public enum ScenarioTest {

    // T1-T1000
    T1("Successful login with valid credentials"),
    T2("Invalid login with invalid credentials");

    private String scenarioTestName;

    ScenarioTest(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }

}
