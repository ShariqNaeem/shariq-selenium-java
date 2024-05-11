package mercans.pageobjects;

import mercans.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class QuickAccessPage {
    private WebDriver driver;
    By leavesCard = By.cssSelector("a.lp-dashboard-card");
    public QuickAccessPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getLeavesCard() throws InterruptedException {

        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(leavesCard));
    }
}
