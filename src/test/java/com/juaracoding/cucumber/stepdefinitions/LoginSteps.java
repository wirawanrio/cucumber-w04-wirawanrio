package com.juaracoding.cucumber.stepdefinitions;

import com.juaracoding.cucumber.utils.Constants;
import com.juaracoding.cucumber.utils.DriverSingleton;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.time.Duration;

import static com.juaracoding.cucumber.hooks.Hooks.extentTest;


public class LoginSteps {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static InventoryPage inventoryPage;


    public LoginSteps(){
        driver = DriverSingleton.getDriver();

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    // TCC.HR.001
    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get(Constants.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password(){
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter a valid username and password");
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS, "I click the login button");
    }

    @Then("I should be redirected to inventory page")
    public void i_should_be_redirected_to_inventory_page(){
        Assert.assertEquals(inventoryPage.getProductheader(), "Products");
        extentTest.log(LogStatus.PASS, "I should be redirected to inventory page");
    }

}
