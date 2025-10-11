package org.onlineLearning.automation.pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {
    @FindBy(xpath = "//*[@name='email']")
    WebElement username;
    @FindBy(xpath = "//*[@type='password']")
    WebElement password;
    @FindBy(xpath = "//div[text()='Login']")
    WebElement loginBtn;
    @FindBy(xpath = "//span[text()='Home']")
    WebElement homepage;

    public LoginPage(WebDriver driver) {
        super(driver);  // ✅ calls BasePage constructor
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }

    public void homepage()
    {
        homepage.click();
        driver.get("https://ui.freecrm.com/home");
    }
}
