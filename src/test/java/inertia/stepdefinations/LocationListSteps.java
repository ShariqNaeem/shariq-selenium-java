package inertia.stepdefinations;

import inertia.pageobjects.LocationListPage;
import inertia.pageobjects.LoginPage;
import inertia.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocationListSteps extends DriverManager {
    private LocationListPage locationListPage;

    public LocationListSteps(){
        locationListPage = new LocationListPage(getDriver());
    }

    @When("Select BloodDraw and Load the data")
    public void selectBloodDrawAndLoadData() throws IOException, InterruptedException {
        locationListPage.getBloodDrawRow().click();
        Thread.sleep(3000);
        locationListPage.getBloodDrawDetail().click();
        locationListPage.getLoadDataBtn().click();
    }

    @And("Validate side panel tabs should be displayed")
    public void iEnterPasswordOnLogInPage() throws IOException, InterruptedException {
        List<String> tabNames = Arrays.asList("Records", "Photos", "Properties", "Sheets");
        locationListPage.validateSidePanelTabs(tabNames);
    }

    @And("Click on the add checklist button")
    public void checklistButton() throws InterruptedException {
        locationListPage.getAddChecklistBtn().click();
    }

    @And("Click on the add checklist option modal should be displayed")
    public void checklistOption() throws InterruptedException {
        locationListPage.getChecklistOption().click();
        Assert.assertTrue(locationListPage.getLocationChecklistModal().isDisplayed());
    }

    @And("Select the {string} checklist option")
    public void selectChecklistOption(String option) throws InterruptedException {
        locationListPage.selectChecklistOption(option);
    }

    @And("Select the {string} apply to option")
    public void selectApplyToOption(String option) throws InterruptedException {
        locationListPage.selectApplyToOption(option);
    }

    @And("Click on the add modal button and close the modal")
    public void closeModal() throws InterruptedException {
        locationListPage.getAddBtnModal().click();
        Assert.assertEquals(locationListPage.getLocationChecklistModal(), "Done saving checklist");
        locationListPage.getCloseModal().click();
    }
}
