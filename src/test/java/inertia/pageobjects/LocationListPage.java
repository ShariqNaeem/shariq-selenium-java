package inertia.pageobjects;
import inertia.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class LocationListPage {
    private WebDriver driver;
    private By bloodDrawRow = By.cssSelector("div.x-grid-item-container table:nth-child(1) div[data-groupname]");
    private By bloodDrawDetail = By.cssSelector("div.x-grid-item-container table:nth-child(1) tr.row-no-expander");
    private By loadDataBtn = By.xpath("//span[@data-ref='btnInnerEl' and text()='Load Data']");
    private By addChecklistBtn = By.xpath("//span[@data-ref='btnInnerEl' and text()='Add']");
    private By checklistOption = By.cssSelector("div.x-box-scroller-body-vertical div.checklist-icon");
    private By locationChecklistModal = By.cssSelector("div[role='dialog']");
    private By checklistDropdownModal = By.cssSelector("input[name='checklistId']");
    private By applyToDropdownOptionModal = By.cssSelector("input[name='apply']");
    private By addBtnModal = By.cssSelector("div[role='dialog'] a[role='button']");
    private By closeModal = By.cssSelector("div[role='dialog'] div[data-qtip='Close dialog']");
    private By sidePanelTabs = By.cssSelector("div.side-panel-tabs span.x-tab-inner.x-tab-inner-default");
    private String sidePanelTabsXPath = "//div[contains(@class, 'side-panel-tabs')]//span[contains(@class, 'x-tab-inner x-tab-inner-default') and text()='%s']";

    public LocationListPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getBloodDrawRow() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(bloodDrawRow));
    }

    public WebElement getBloodDrawDetail() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(bloodDrawDetail));
//        WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript(
//                "return document.querySelector('your-css-selector');"
//        );
//        return element;
    }

    public WebElement getLoadDataBtn() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.elementToBeClickable(loadDataBtn));
    }

    public WebElement getAddChecklistBtn() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.elementToBeClickable(addChecklistBtn));
    }

    public WebElement getChecklistOption() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(checklistOption));
    }

    public WebElement getLocationChecklistModal() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(locationChecklistModal));
    }

    public WebElement getChecklistDropdownModal() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(checklistDropdownModal));
    }

    public WebElement getApplyToDropdownOptionModal() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(applyToDropdownOptionModal));
    }

    public WebElement getAddBtnModal() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.elementToBeClickable(addBtnModal));
    }

    public WebElement getCloseModal() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(closeModal));
    }

    public void validateSidePanelTabs(List<String> tabNames) throws InterruptedException {
        for (String tabName : tabNames) {
            By tabLocator = By.xpath(String.format(sidePanelTabsXPath, tabName));
            WebElement tabElement = Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(tabLocator));
            if (!tabElement.isDisplayed()) {
                throw new AssertionError("Tab " + tabName + " is not visible.");
            }
        }
    }

    public void selectChecklistOption(String checklistName) throws InterruptedException {
        WebElement dropdown = this.getChecklistDropdownModal();
        dropdown.click();
        WebElement option = Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[contains(@class, 'x-list-plain')]//li[@role='option' and text()='" + checklistName + "']")));
        option.click();
    }

    public void selectApplyToOption(String applyName) throws InterruptedException {
        WebElement dropdown = this.getApplyToDropdownOptionModal();
        dropdown.click();
        WebElement option = Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[contains(@class, 'x-list-plain')]//li[@role='option' and text()='" + applyName + "']")));
        option.click();
    }
}
