package saucedemo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductListingPage {
    private WebDriver driver;
    By backPackAddToCart = By.cssSelector("[data-test=\"add-to-cart-sauce-labs-backpack\"]");
    By backPackRemoveCart = By.cssSelector("[data-test=\"remove-sauce-labs-backpack\"]");
    By shoppingCartContainer = By.id("shopping_cart_container");
    public ProductListingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickAddToCartBackPack() {
        driver.findElement(backPackAddToCart).click();
    }

    public void clickRemoveBackPack() {
        driver.findElement(backPackRemoveCart).click();
    }

    public void validateCountOnCartIcon(String count){
        String ActualCountText = driver.findElement(shoppingCartContainer).getText();
        Assert.assertTrue(ActualCountText.contains(count));
    }

    public void validateZeroCountOnCartIcon(String count){
        String ActualCountText = driver.findElement(shoppingCartContainer).getText();
        Assert.assertFalse(ActualCountText.contains(count));
    }
}
