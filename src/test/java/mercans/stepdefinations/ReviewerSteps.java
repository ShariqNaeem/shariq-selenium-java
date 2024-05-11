package mercans.stepdefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mercans.pageobjects.QuickAccessPage;
import mercans.pageobjects.ReviewerPage;
import mercans.utils.DriverManager;
import org.testng.Assert;


public class ReviewerSteps extends DriverManager {
    private ReviewerPage reviewerPage;

    public ReviewerSteps(){
        reviewerPage = new ReviewerPage(getDriver());
    }

    @Then("User landed to the reviewer listing page")
    public void validateReviewerPage() throws InterruptedException {
        Assert.assertTrue(reviewerPage.getLeaveTable().isDisplayed());
    }
    @When("I clicks on the first leave that required the approval")
    public void clickFirstLeave() throws InterruptedException {
        reviewerPage.getFirstLeaveRow().click();
    }

    @When("I clicks on the reject button in the right side-bar")
    public void clickRejectButton() throws InterruptedException {
        reviewerPage.getRejectButton().click();
    }

    @When("Submit the leave rejection note|reason {string}")
    public void submitRejectionNote(String reason) throws InterruptedException {
        reviewerPage.submitRejectionReason(reason);
    }
}
