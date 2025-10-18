package org.onlineLearning.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage extends BasePage{

    //Locators
    private @FindBy (xpath = "//span[normalize-space()='Calendar']")
    WebElement calendarLink;


//    @FindBy fields are handled by Selenium’s PageFactory.
//    When you call:
//    PageFactory.initElements(driver, this);
//    Selenium automatically finds and assigns all @FindBy elements in your class to actual WebElements in the browser DOM.
//    //Constructor
    public CalendarPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);   // ✅ This initializes @FindBy elements
    }

    public void  clickOnCalendar()
    {
        System.out.println("➡ Clicking on Calendar icon...");
        clickElement(calendarLink);
        System.out.println("✅ Calendar icon clicked successfully!");
    }
}
