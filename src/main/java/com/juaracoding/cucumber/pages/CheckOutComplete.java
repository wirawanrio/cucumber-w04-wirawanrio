package com.juaracoding.cucumber.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 30/03/25 10.34
@Last Modified 30/03/25 10.34
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutComplete {

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement chekcoutCompleteHeader;

    @FindBy(xpath = "//*[@id='checkout_complete_container']/h2")
    WebElement successOrder;

    @FindBy(xpath = "//button[@id='back-to-products']")
    WebElement backToHome;

    public CheckOutComplete(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getCheckoutCompleteHeader(){
        return chekcoutCompleteHeader.getText();
    }

    public String getMessageSuccess(){
        return successOrder.getText();
    }

    public void clickBackToHome(){
        backToHome.click();
    }

}
