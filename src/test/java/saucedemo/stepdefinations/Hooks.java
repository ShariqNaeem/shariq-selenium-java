package saucedemo.stepdefinations;

import saucedemo.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    public Hooks() {}
    @After
    public void quitDriver() {
        DriverManager.closeBrowser();
    }

    @Before
    public void setup() throws IOException {
        DriverManager.driverSetup();
    }
}
