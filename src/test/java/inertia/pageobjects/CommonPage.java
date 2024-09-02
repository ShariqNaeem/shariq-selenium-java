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
import java.util.Properties;

public class CommonPage {

    private WebDriver driver;
    By loadingIcon = By.className(".loading-indicator");

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

    public WebElement getLoadingIcon() throws InterruptedException {
        return Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(loadingIcon));
    }
}
