package org.onlineLearning.automation.stepDefinitions;

import io.cucumber.java.en.Then;
import org.onlineLearning.automation.pages.HomePage;
import org.onlineLearning.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeSteps {
    private WebDriver driver;
    private HomePage homePage;


    @Then("Title of page {string}")
    public void titleOfPage(String expectedTitle) {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        String actualTitle = homePage.verifyTitleOfPage();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title mismatch: expected '" + expectedTitle + "' but got '" + actualTitle + "'");
    }

    @Then("scroll down the home page")
    public void scrollDownTheHomePage() {
        driver = DriverManager.getDriver();
        homePage = new HomePage(driver);
        homePage.scrollDownAndValidateText();

    }
}
