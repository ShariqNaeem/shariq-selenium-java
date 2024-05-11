package mercans.stepdefinations;

import io.cucumber.java.en.*;
import mercans.pageobjects.CommonPage;
import mercans.pageobjects.LoginPage;
import mercans.utils.DriverManager;

import java.io.IOException;

public class LoginSteps extends DriverManager {
    private LoginPage loginPage;
    private CommonPage commonPage;

    public LoginSteps(){
        loginPage = new LoginPage(getDriver());
        commonPage = new CommonPage(getDriver());
    }

    @When("I enter email {string} in logIn Screen")
    public void iEnterUserNameOnLogInPage(String email) throws IOException, InterruptedException {
        loginPage.setEmail(commonPage.getValue(email));
    }

    @And("I enter password {string} in logIn Screen")
    public void iEnterPasswordOnLogInPage(String password) throws IOException, InterruptedException {
        loginPage.setPassword(commonPage.getValue(password));
    }

    @And("I click on the login button")
    public void iClickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("Validate the login error {string} message")
    public void validateErrorMsgOnLoginPage(String errorMsg) {
        loginPage.validateLoginErrorMsg(errorMsg);
    }
}
