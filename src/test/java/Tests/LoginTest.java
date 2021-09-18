package Tests;


import Steps.BaseSteps;
import Steps.LoginPageSteps;
import config.UserConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test(description = "Login should be successful")
    public void login(){
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.openLoginPage(UserConfig.getBaseUrl()).
                isLoginPageOpened();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.inputEmailAndPassword(UserConfig.getEMAIL(),UserConfig.getPASSWORD()).
                clickLoginButton().
                isHomePageOpened();
    }

    @DataProvider(name = "Login Data")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "UtblKrUW5UijCYr6PfQc", "Email/Login is required."},
                {"sidorik.a97@gmail.com", "", "Password is required."},
                {"sidorik.a97@gmail.com", "invalid value", "Sorry, there was a problem.\n" +
                        "Email/Login or Password is incorrect. Please try again."}
        };
    }

    @Test(description = "Negative tests for login", dataProvider = "Login Data")
    public void negativeTestsForLogin(String email, String password, String errorMessage){
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.openLoginPage("https://sidorika97.testrail.io/").
                isLoginPageOpened();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.inputEmailAndPassword(email,password).
                clickLoginButton().
                checkErrorMessage(errorMessage);
    }
}
