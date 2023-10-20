package saucedemo.stepdefinations;

import io.cucumber.java.en.*;
import saucedemo.pageobjects.CommonPage;
import saucedemo.utils.DriverManager;

public class CommonSteps extends DriverManager {
    private CommonPage commonPage;

    public CommonSteps(){
        commonPage = new CommonPage(getDriver());
    }
    @Then("Validate that URL contains {string} text")
    public void validateURL(String url) {
        commonPage.validateURL(url);
    }
}
