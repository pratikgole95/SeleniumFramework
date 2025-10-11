package org.onlineLearning.automation.utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
        //private constructor to avoid instantiation
    }

    public static void setDriver(String browserName) {
        if (browserName == null) {
            browserName = "chrome";
        }

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();

                //Headless configuration in CI/CD
               if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
                   chromeOptions.addArguments("--headless");
               }

                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--remote-allow-origins=*");

                driver.set(new ChromeDriver(chromeOptions));
                break;

            default:
                throw new IllegalArgumentException("unsupported browser"+browserName);
        }
    }


    public static WebDriver getDriver() {
        return driver.get();
    }

   public static void quitDriver() {
       if (driver.get() != null) {
           driver.get().quit();
           driver.remove();
       }
   }
}
