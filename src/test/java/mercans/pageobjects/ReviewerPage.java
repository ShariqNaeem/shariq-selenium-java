package mercans.pageobjects;

import mercans.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ReviewerPage {
    private WebDriver driver;
    By leavesTable = By.id("tableBody-leave-table");
    By firstLeaveRow = By.cssSelector("#tableBody-leave-table tr:first-child");
    By rejectRequestBtn = By.cssSelector("[data-test=\"reject-request\"]");
    By rejectNote = By.id("rejected_notes");
    public ReviewerPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getLeaveTable() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(leavesTable));
    }

    public WebElement getFirstLeaveRow() throws InterruptedException {
        Thread.sleep(2000);
        return Wait.longWaitForWebElement().until(ExpectedConditions.presenceOfElementLocated(firstLeaveRow));
    }

    public WebElement getRejectButton() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(rejectRequestBtn));
    }

    public void submitRejectionReason(String reason) throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(rejectNote)).sendKeys(reason);
        this.getRejectButton().click();
    }
}
