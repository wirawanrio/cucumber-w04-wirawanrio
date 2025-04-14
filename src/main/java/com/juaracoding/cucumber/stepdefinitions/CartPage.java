package com.juaracoding.cucumber.stepdefinitions;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 23/03/25 23.54
@Last Modified 23/03/25 23.54
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    @FindBy(xpath = "//*[@class='title']")
    WebElement yourCartHeader;

    @FindBy(xpath = "//*[@id='checkout']")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    private List<WebElement> cartItems;


    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String getHeaderCart(){
        return yourCartHeader.getText();
    }

    public void checkout(){
        checkoutButton.click();
    }

    public int countItemInCart(){
        return cartItems.size();
    }


}
