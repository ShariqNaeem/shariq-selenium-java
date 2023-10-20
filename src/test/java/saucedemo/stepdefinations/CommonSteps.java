package saucedemo.stepdefinations;

import io.cucumber.java.en.And;
import saucedemo.pageobjects.CommonPage;
import saucedemo.utils.DriverManager;

public class CommonSteps extends DriverManager {
    private CommonPage commonPage;

    public CommonSteps(){
        commonPage = new CommonPage(getDriver());
    }
    @And("Validate that URL contains {string} text")
    public void validateURL(String url) {
        commonPage.validateURL(url);
    }
}
