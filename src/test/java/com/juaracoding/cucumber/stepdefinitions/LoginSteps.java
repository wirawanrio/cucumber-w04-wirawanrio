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
    @Given("I am on the login page for {string} test")
    public void i_am_on_the_login_page(String testType){
        // Logging test type
        extentTest.log(LogStatus.INFO, "TEST TYPE : " + testType.toUpperCase());
        driver.get(Constants.URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }

    @When("I enter username {string} and password {string}")
    public void enter_username_and_password(String username, String password) {
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        extentTest.log(LogStatus.PASS,"I enter username and password");
    }
    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.clickLoginButton();
        extentTest.log(LogStatus.PASS, "I click the login button");
    }

    @Then("I should see the {string}")
    public void validate_result(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("Products")) {
            Assert.assertEquals(inventoryPage.getProductheader(), "Products");
            extentTest.log(LogStatus.PASS, "User successfully logged in and redirected to inventory page");
        } else if (expectedResult.equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service")) {
            String error = loginPage.getErrorMessage();
            Assert.assertEquals(error, "Epic sadface: Username and password do not match any user in this service");
            extentTest.log(LogStatus.PASS, "Error message displayed : " + error);
        } else if (expectedResult.equalsIgnoreCase("Epic sadface: Username is required")) {
            String error = loginPage.getErrorMessage();
            Assert.assertEquals(error, "Epic sadface: Username is required");
            extentTest.log(LogStatus.PASS, "Error message displayed : " + error);
        } else if (expectedResult.equalsIgnoreCase("Epic sadface: Password is required")) {
            String error = loginPage.getErrorMessage();
            Assert.assertEquals(error, "Epic sadface: Password is required");
            extentTest.log(LogStatus.PASS, "Error message displayed : " + error);
        }
    }


}
