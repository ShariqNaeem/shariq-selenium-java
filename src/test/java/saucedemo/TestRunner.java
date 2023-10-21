package saucedemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        features = {"src/test/java/features"},
        glue = {"saucedemo.stepdefinations"},
        monochrome = true,
        tags = "@web"
)

public class TestRunner extends AbstractTestNGCucumberTests {
}