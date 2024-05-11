package mercans.pageobjects;

import mercans.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonPage {

    private WebDriver driver;
    By alert = By.cssSelector("div[role='alert'] div.snackBar-message");
    By closeAlert = By.cssSelector("[data-test=\"snackbar-close-button\"]");
    By approvalMenu = By.xpath("//a[text()='Approvals']");
    By leavesMenuMenu = By.cssSelector(".lp-nav-menu__link.lp-nav-menu__expandable");

    public CommonPage(WebDriver driver){
        this.driver = driver;
    }
    public void validateURL(String expectedUrl){
        String currentUrl = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrl));
    }

    public String getValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(fileInputStream);

        String value = properties.getProperty(key);
        return value;
    }

    public WebElement getAlertMessage() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(alert));
    }

    public WebElement getCloseAlert() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(closeAlert));
    }

    public void clickApprovalMenu() throws InterruptedException {
//        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(approvalMenu)).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", Wait.longWaitForWebElement().until(ExpectedConditions.presenceOfElementLocated(approvalMenu)));
    }
    public void clickLeavesMenu() throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(leavesMenuMenu)).click();
    }
}
