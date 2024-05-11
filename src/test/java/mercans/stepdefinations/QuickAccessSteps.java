package mercans.stepdefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mercans.pageobjects.QuickAccessPage;
import mercans.utils.DriverManager;
import org.testng.Assert;


public class QuickAccessSteps extends DriverManager {
    private QuickAccessPage quickAccessPage;

    public QuickAccessSteps(){
        quickAccessPage = new QuickAccessPage(getDriver());
    }

    @Then("User landed to the quick access page")
    public void validateQuickAccessPage() throws InterruptedException {
        Assert.assertTrue(quickAccessPage.getLeavesCard().isDisplayed());
    }
    @When("I clicks on the quick access - leaves card")
    public void clickLeavesCard() throws InterruptedException {
        quickAccessPage.getLeavesCard().click();
    }
}
