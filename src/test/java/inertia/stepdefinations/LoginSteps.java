package inertia.stepdefinations;

import io.cucumber.java.en.*;
import inertia.pageobjects.CommonPage;
import inertia.pageobjects.LoginPage;
import inertia.utils.DriverManager;

import java.io.IOException;

public class LoginSteps extends DriverManager {
    private LoginPage loginPage;

    public LoginSteps(){
        loginPage = new LoginPage(getDriver());
    }

    @When("I enter email {string} in logIn Screen")
    public void iEnterUserNameOnLogInPage(String email) throws IOException, InterruptedException {
        loginPage.setEmail(email);
    }

    @And("I enter password {string} in logIn Screen")
    public void iEnterPasswordOnLogInPage(String password) throws IOException, InterruptedException {
        loginPage.setPassword(password);
    }

    @And("I click on the login button")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }
}
