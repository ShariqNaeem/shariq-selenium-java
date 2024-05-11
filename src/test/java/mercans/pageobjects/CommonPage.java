package mercans.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class CommonPage {

    private WebDriver driver;

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

}
