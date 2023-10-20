package saucedemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/failed_scenario.txt"
        },
        features = {"src/test/java/features/Login.feature"},
        glue = {"saucedemo.stepdefinations"},
        monochrome = true,
        tags = "@web"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}