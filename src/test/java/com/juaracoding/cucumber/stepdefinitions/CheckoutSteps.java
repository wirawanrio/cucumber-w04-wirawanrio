package com.juaracoding.cucumber.stepdefinitions;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/16/2025 2:01 PM
@Last Modified 4/16/2025 2:01 PM
Version 1.0
*/

import com.juaracoding.cucumber.pages.*;
import com.juaracoding.cucumber.utils.DriverSingleton;
import com.juaracoding.cucumber.utils.WaitUtils;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

import static com.juaracoding.cucumber.hooks.Hooks.extentTest;

public class CheckoutSteps {

    private WebDriver driver;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutInformation checkoutInformation;
    private CheckoutOverview checkoutOverview;
    private CheckOutComplete checkOutComplete;


    public CheckoutSteps(){
        this.driver = DriverSingleton.getDriver();

        this.inventoryPage = new InventoryPage(driver);
        this.cartPage = new CartPage(driver);
        this.checkoutInformation = new CheckoutInformation(driver);
        this.checkoutOverview = new CheckoutOverview(driver);
        this.checkOutComplete = new CheckOutComplete(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    // TCC.HR.002
    @When("I add product to cart")
    public void i_add_product_to_cart(){
        inventoryPage.addSauceLabBackpack();
        extentTest.log(LogStatus.PASS, "I add product to cart");
    }

    @Then("I should see the shopping cart badge add up")
    public void i_should_the_shopping_cart_badge_add_up(){
        Assert.assertEquals(inventoryPage.getCartBadge(), "1");
        extentTest.log(LogStatus.PASS, "I should see the shopping cart badge add up");
    }

    @When("I navigate to the cart page")
    public void i_navigate_to_the_cart_page(){
        inventoryPage.navigateToCart();
        extentTest.log(LogStatus.PASS, "I navigate to the cart page");
    }

    @Then("I should see the cart page")
    public void i_should_see_the_cart_page(){
        Assert.assertEquals(cartPage.getHeaderCart(), "Your Cart");
        extentTest.log(LogStatus.PASS, "I should see the cart page");
    }

    @When("I see the number of products in the cart")
    public void i_see_the_number_of_product_in_the_cart(){
        Assert.assertEquals(cartPage.countItemInCart(), 1);
        extentTest.log(LogStatus.PASS, "I see the number of products in the cart");
    }

    @And("I click the checkout button")
    public void i_click_the_checkout_button(){
        cartPage.checkout();
        extentTest.log(LogStatus.PASS, "I click the checkout button");
    }

    @Then("I should see the checkout your information page")
    public void i_should_see_the_checkout_your_information_page(){
        Assert.assertEquals(checkoutInformation.getCheckoutInformationHeader(), "Checkout: Your Information");
        extentTest.log(LogStatus.PASS, "I should see the checkout your information page");
    }

    @When("I fill valid personal information")
    public void i_fill_valid_personal_information(){
        WaitUtils.waitForVisibility(driver, checkoutInformation.getElemetInputFirstName(), 5);
        checkoutInformation.fillFirstName("Rio");
        checkoutInformation.fillLastName("Renaldi");
        checkoutInformation.fillPostalCode("123456");
        extentTest.log(LogStatus.PASS, "I fill valid personal information");
    }

    @And("I click the continue button")
    public void i_click_the_continue_button(){
        checkoutInformation.clickContinue();
        extentTest.log(LogStatus.PASS, "I click the continue button");
    }

    @Then("I should see the checkout overview page")
    public void i_should_see_the_checkout_overview_page(){
        Assert.assertEquals(checkoutOverview.getHeaderOverview(), "Checkout: Overview");
        extentTest.log(LogStatus.PASS, "I should see the checkout overview page");
    }

    @Then("I validate the checkout overview")
    public void i_validate_the_checkout_overview(){
        Assert.assertEquals(checkoutOverview.getItemOverview(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverview.getPaymentInformation(), "SauceCard #31337");
        Assert.assertEquals(checkoutOverview.getShippingInformation(), "Free Pony Express Delivery!");
        Assert.assertEquals(checkoutOverview.getItemTotal(), "Item total: $29.99");
        Assert.assertEquals(checkoutOverview.getTax(), "Tax: $2.40");
        Assert.assertEquals(checkoutOverview.getTotal(), "Total: $32.39");
        extentTest.log(LogStatus.PASS, "I validate the checkout overview");
    }

    @And("I click the finish button")
    public void i_click_the_finish_button(){
        checkoutOverview.clickFinish();
        extentTest.log(LogStatus.PASS, "I click the finish button");
    }

    @Then("I should see the confirmation message Thank you for your order!")
    public void i_should_see_the_confirmation_message_thank_you_for_your_order(){
        WaitUtils.isElementPresent(driver,checkOutComplete.getElementSuccessOrder(),5);
        Assert.assertEquals(checkOutComplete.getMessageSuccess(), "Thank you for your order!");
        extentTest.log(LogStatus.PASS, "I should see the confirmation message Thank you for your order!");
    }


}
