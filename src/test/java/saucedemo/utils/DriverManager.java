package saucedemo.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;

public class DriverManager {
    public static WebDriver driver;

    public static void driverSetup() throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        chromeOptions.setCapability("goog:loggingPrefs",logPrefs);
        driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
