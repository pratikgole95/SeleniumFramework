package org.onlineLearning.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.onlineLearning.automation.stepDefinitions"},
        plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber.json"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

