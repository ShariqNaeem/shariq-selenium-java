package mercans.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class DriverManager {
    public static WebDriver driver;

    public static void driverSetup() throws IOException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().window().maximize();

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
        properties.load(fileInputStream);

        String baseUrl = properties.getProperty("baseUrl");
        String expectedTitle = properties.getProperty("title");

        driver.get(baseUrl);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match the expected title.");
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static void closeBrowser(Scenario scenario) {
        if(scenario.isFailed())
        {
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
            driver.quit();
    }
}
