package org.onlineLearning.automation.stepDefinitions;

import io.cucumber.java.en.When;
import org.onlineLearning.automation.pages.CalendarPage;
import org.onlineLearning.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ValidateCalendarPage {

    private CalendarPage calendar;
    @When("User click on Calendar icon on left side pane of page")
    public void userClickOnCalendarIconOnLeftSidePaneOfPage() {
       calendar= new CalendarPage(DriverManager.getDriver());
        calendar.clickOnCalendar();
        System.out.println("✅ Calendar icon clicked");
    }
}
