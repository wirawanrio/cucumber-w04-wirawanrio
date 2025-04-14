package com.juaracoding.cucumber.stepdefinitions;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 27/03/25 11.17
@Last Modified 27/03/25 11.17
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {

    @FindBy(xpath = "//*[@id='header_container']/div[2]/span")
    WebElement headerCheckoutOverview;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    WebElement itemOverview;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[2]")
    WebElement paymentInformation;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[4]")
    WebElement shippingInformation;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    WebElement itemTotal;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[7]")
    WebElement tax;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[8]")
    WebElement total;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement buttonFinish;

    @FindBy(xpath = "//button[@id='cancel']")
    WebElement buttonCancel;

    public CheckoutOverview(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getHeaderOverview(){
        return headerCheckoutOverview.getText();
    }

    public String getItemOverview(){
        return itemOverview.getText();
    }

    public String getPaymentInformation(){
        return paymentInformation.getText();
    }

    public String getShippingInformation(){
        return shippingInformation.getText();
    }

    public String getItemTotal(){
        return itemTotal.getText();
    }

    public String getTax(){
        return tax.getText();
    }

    public String getTotal(){
        return total.getText();
    }

    public void clickFinish(){
        buttonFinish.click();
    }

    public void clickCancel(){
        buttonCancel.click();
    }

}
