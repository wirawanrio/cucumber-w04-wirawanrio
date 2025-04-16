package com.juaracoding.cucumber.pages;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 30/03/25 10.49
@Last Modified 30/03/25 10.49
Version 1.0
*/


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SideBar {

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    WebElement burgerMenu;

    @FindBy(xpath = "//*[@id='inventory_sidebar_link']")
    WebElement allItems;

    @FindBy(xpath = "//*[@id='about_sidebar_link']")
    WebElement about;

    @FindBy(xpath = "//*[@id='logout_sidebar_link']")
    WebElement logOut;

    @FindBy(xpath = "//*[@id='reset_sidebar_link']")
    WebElement resetAppState;

    public SideBar(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickBurgerMenu(){
        burgerMenu.click();
    }

    public void clickLogOut(){
        logOut.click();
    }

}
