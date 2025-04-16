package com.juaracoding.cucumber.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 02.10
@Last Modified 23/03/25 02.10
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class LoginPage {
    private Actions actions;

    @FindBy (xpath = "//input[@id='user-name']")
    WebElement inputUsername;

    @FindBy (xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy (xpath = "//input[@id='login-button']")
    WebElement loginButton;

    @FindBy (xpath = "//h3[@data-test='error']")
    WebElement errorMessageLogin;

    public LoginPage(WebDriver driver){
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String username){
        inputUsername.sendKeys(username);
    }

    public void fillPassword(String password){
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void loginActions(String username, String password){
        actions.click(inputUsername).sendKeys(username)
                .pause(Duration.ofSeconds(1))
                .click(inputPassword).sendKeys(password)
                .pause(Duration.ofSeconds(1))
                .click(loginButton).build().perform();
    }

    public String getErrorMessage(){
        return errorMessageLogin.getText();
    }

}
