package saucedemo.stepdefinations;

import io.cucumber.java.en.*;
import saucedemo.pageobjects.LoginPage;
import saucedemo.utils.DriverManager;

public class LoginSteps extends DriverManager {
    private LoginPage loginPage;

    public LoginSteps(){
        loginPage = new LoginPage(getDriver());
    }

    @When("I enter user name {string} in logIn Screen")
    public void iEnterUserNameOnLogInPage(String userName) {
        loginPage.setUserName(userName);
    }

    @And("I enter password {string} in logIn Screen")
    public void iEnterPasswordOnLogInPage(String password) {
        loginPage.setPassword(password);
    }

    @And("I click on the login button")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }
}
