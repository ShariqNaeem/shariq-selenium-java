package inertia.stepdefinations;

import io.cucumber.java.en.When;
import inertia.pageobjects.DashboardPage;
import inertia.utils.DriverManager;


public class DashboardSteps extends DriverManager {
    private DashboardPage dashboardPage;

    public DashboardSteps(){
        dashboardPage = new DashboardPage(getDriver());
    }

    @When("Landed to the dashboard and select the project {string}")
    public void clickLeavesCard(String projectName) throws InterruptedException {
        dashboardPage.selectProjectInDropdown(projectName);
    }

    @When("Click on the location icon")
    public void clickLocationIcon() throws InterruptedException {
        dashboardPage.clickLocationIcon();
    }

    @When("Click on the location list")
    public void clickLocationList() throws InterruptedException {
        dashboardPage.clickLocationList();
    }
}
