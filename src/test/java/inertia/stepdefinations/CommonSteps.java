package inertia.stepdefinations;

import io.cucumber.java.en.*;
import inertia.pageobjects.CommonPage;
import inertia.utils.DriverManager;
import org.testng.Assert;

import java.io.IOException;

public class CommonSteps extends DriverManager {
    private CommonPage commonPage;

    public CommonSteps(){
        commonPage = new CommonPage(getDriver());
    }
    @Then("Validate that URL contains {string} text")
    public void validateURL(String url) throws IOException {
        commonPage.validateURL(url);
    }
    @Then("Validate that loading icon should be displayed")
    public void validateLoadingIcon() throws InterruptedException {
        Assert.assertTrue(commonPage.getLoadingIcon().isDisplayed());
    }
}
