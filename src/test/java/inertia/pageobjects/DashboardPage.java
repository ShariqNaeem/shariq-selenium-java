package inertia.pageobjects;

import inertia.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {
    private WebDriver driver;
    By projectDropdown = By.cssSelector("input[role=\"combobox\"]");
    By listIcon = By.cssSelector("div.x-treelist-toolstrip div.locations-icon");
    By locationList = By.xpath("//div[contains(@class, 'x-treelist-item-text') and contains(text(), 'Locations List')]");
    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }
    public void selectProjectInDropdown(String projectName) throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(projectDropdown));
        Thread.sleep(2000);
        driver.findElement(projectDropdown).click();

        By element = By.xpath("//ul[@role='listbox']//li[text()='"+ projectName +"']");
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }

    public void clickLocationIcon() throws InterruptedException {
        Thread.sleep(6000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Wait.longWaitForWebElement().until(ExpectedConditions.presenceOfElementLocated(listIcon)));
    }

    public void clickLocationList() throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(locationList));
        driver.findElement(locationList).click();
    }
}
