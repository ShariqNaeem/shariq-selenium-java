package saucedemo.stepdefinations;

import io.cucumber.java.en.*;
import saucedemo.pageobjects.ProductListingPage;
import saucedemo.utils.DriverManager;


public class ProducListingSteps extends DriverManager {
    private ProductListingPage productListingPage;

    public ProducListingSteps(){
        productListingPage = new ProductListingPage(getDriver());
    }

    @When("I click on the back pack add to cart button")
    public void iEnterUserNameOnLogInPage() {
        productListingPage.clickAddToCartBackPack();
    }

    @And("I click on the back pack remove button")
    public void clickOnRemoveBackPack() {
        productListingPage.clickRemoveBackPack();
    }

    @Then("Validate the count {string} on the cart icon")
    public void validateCountOnCartIcon(String count) {
        productListingPage.validateCountOnCartIcon(count);
    }

    @Then("Validate count {string} should remove on the cart icon")
    public void validateZeroCountOnCartIcon(String count) {
        productListingPage.validateZeroCountOnCartIcon(count);
    }
}
