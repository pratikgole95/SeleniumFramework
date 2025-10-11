package org.onlineLearning.automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.onlineLearning.automation.utils.ConfigReader;
import org.onlineLearning.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void Setup() {
        ConfigReader.loadConfig();
        DriverManager.setDriver(ConfigReader.getProperty("browser"));
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
        System.out.println("✅ Browser launched successfully.");
    }

//    @After
//    public void teardown()
//    {
//        DriverManager.quitDriver();
//    }
}
