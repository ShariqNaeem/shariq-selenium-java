package saucedemo.stepdefinations;

import saucedemo.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class _Hooks {

    public _Hooks() {}
    @After
    public void quitDriver() {
        DriverManager.closeBrowser();
    }

    @Before
    public void setup() throws IOException {
        DriverManager.driverSetup();
    }
}
