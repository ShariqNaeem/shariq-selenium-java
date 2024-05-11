package mercans.pageobjects;

import mercans.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage {

    By emailField = By.cssSelector("input[name=\"email\"]");
    By passwordField = By.cssSelector("input[name=\"password\"]");
    By loginBtn = By.cssSelector("[data-test=\"perform-login\"]");
    By errorMsg = By.className("error-message-container");

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setEmail(String email) throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
    }
    public void setPassword(String password) throws InterruptedException {
        Wait.longWaitForWebElement().until(ExpectedConditions.visibilityOfElementLocated(emailField));
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void validateLoginErrorMsg(String expectedErrorText){
        String ActualErrorText = driver.findElement(errorMsg).getText();
        Assert.assertEquals(ActualErrorText, expectedErrorText);
    }

}
