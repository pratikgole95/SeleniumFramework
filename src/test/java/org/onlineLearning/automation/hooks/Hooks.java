package org.onlineLearning.automation.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.onlineLearning.automation.utils.ConfigReader;
import org.onlineLearning.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setup() {
        System.out.println("🔹 Starting setup...");
        ConfigReader.loadConfig();

        // ✅ Initialize WebDriver before any test
        String browser = ConfigReader.getProperty("browser");
        DriverManager.setDriver(browser);

        driver = DriverManager.getDriver();
        if (driver == null) {
            throw new RuntimeException("❌ WebDriver initialization failed! Driver is null.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        System.out.println("✅ Browser launched successfully: " + browser);
    }

//    @After
//    public void teardown()
//    {
//        DriverManager.quitDriver();
//    }
}
