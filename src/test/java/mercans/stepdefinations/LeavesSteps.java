package mercans.stepdefinations;

import io.cucumber.java.en.Then;
import mercans.pageobjects.LeavesPage;
import mercans.pageobjects.QuickAccessPage;
import mercans.utils.DriverManager;
import org.testng.Assert;


public class LeavesSteps extends DriverManager {
    private LeavesPage leavesPage;

    public LeavesSteps(){
        leavesPage = new LeavesPage(getDriver());
    }

    @Then("I click on plus button for requesting the leave")
    public void validateQuickAccessPage() throws InterruptedException {
        leavesPage.clickOnPlusButton();
    }
}
