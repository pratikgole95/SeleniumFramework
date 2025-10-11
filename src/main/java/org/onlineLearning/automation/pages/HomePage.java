package org.onlineLearning.automation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);  // ✅ calls BasePage constructor
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//span[@class='user-display']")
    WebElement userName;
    
    public String verifyTitleOfPage()
    {
        return driver.getTitle();
    }

    public void scrollDownAndValidateText()
    {
        JavascriptExecutor js =(JavascriptExecutor) driver;
        //scroll down by pixels
//        js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
