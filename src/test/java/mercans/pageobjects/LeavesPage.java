package mercans.pageobjects;

import mercans.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LeavesPage {
    private WebDriver driver;
    By plusButtonForRequestNewLeave = By.cssSelector("button[aria-label=\"Request new leave\"]");
    By leaveDate = By.cssSelector("div.calendar div.month-row:nth-child(5) div.current__month:nth-child(3)");
    By modalTitle = By.id("modal-title");
    By beforeRequest = By.id("balance-bubble-before");
    By afterRequest = By.id("balance-bubble-after");
    By saveDraftBtn = By.cssSelector("button[data-test=\"save-draft\"]");
    By requestLeaveBtn = By.cssSelector("button[data-test=\"submit-approve\"]");
    By confirmRequestLeaveBtn = By.cssSelector("button[data-test=\"confirm-action-button\"]");
    By draftRequest = By.cssSelector("div.request-tiles__wrapper>div:nth-child(1)");
    By deleteDraftRequest = By.cssSelector("button[data-test=\"delete-draft\"]");
    By yesBtnDeleteModal = By.cssSelector("#dialog-box .button-main.type--danger");
    By firstDraftRequestCard = By.cssSelector("div.request-tiles__wrapper>div.tile-wrapper:nth-child(1)");
    public LeavesPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnPlusButton() throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(plusButtonForRequestNewLeave)).click();
    }

    public WebElement getModalTitle() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
    }

    public void selectADateForLeave() throws InterruptedException {
        Thread.sleep(2000);
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(leaveDate)).click();
        Thread.sleep(2000);
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(leaveDate)).click();

    }

    public WebElement getBeforeRequest() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(beforeRequest));
    }

    public WebElement getAfterRequest() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(afterRequest));
    }

    public void clickSaveDraftBtn() throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(saveDraftBtn)).click();
    }

    public void clickFirstDraftRequest() throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(firstDraftRequestCard)).click();
    }

    public void clickRequestLeaveBtn() throws InterruptedException {
        Thread.sleep(3000);
        WebElement element = Wait.longWaitForWebElement().until(ExpectedConditions.presenceOfElementLocated(requestLeaveBtn));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }
    public void clickConfirmRequestLeaveBtn() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Wait.longWaitForWebElement().until(ExpectedConditions.presenceOfElementLocated(confirmRequestLeaveBtn)));
    }

    public void deleteDraftRequest() throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(draftRequest)).click();
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(deleteDraftRequest)).click();
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(yesBtnDeleteModal)).click();
    }
}
