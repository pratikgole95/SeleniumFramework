package org.onlineLearning.automation.stepDefinitions;

import io.cucumber.java.en.*;
import org.onlineLearning.automation.pages.LoginPage;
import org.onlineLearning.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver = DriverManager.getDriver(); // always get the driver from DriverManager
    private LoginPage loginPage = new LoginPage(driver);  // initialize page object once

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://ui.freecrm.com/");
        loginPage = new LoginPage(driver);
    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.login("prattygole07@gmail.com", "Test@1234");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("user should be redirected to home page")
    public void userShouldBeRedirectedToHomePage() {
        loginPage.homepage();
    }
//    @Then("user should be redirected to home page")
//    public void user_should_be_redirected_to_home_page() {
//        String currentUrl = driver.getCurrentUrl();

//        loginPage.homepage();
//        if (!currentUrl.contains("/home")) {
//            throw new AssertionError("User is not on home page. Current URL: " + currentUrl);
//        }
//    }

}
