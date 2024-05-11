package mercans.stepdefinations;

import io.cucumber.java.en.*;
import mercans.pageobjects.CommonPage;
import mercans.utils.DriverManager;

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
