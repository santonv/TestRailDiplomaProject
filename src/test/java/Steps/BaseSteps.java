package Steps;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class BaseSteps {

    LoginPage loginPage;

    public BaseSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    public BaseSteps openLoginPage(String url){
        loginPage.openLoginPage(url);
        return this;
    }

    public void isLoginPageOpened(){
        boolean isOpened = loginPage.isPageOpened();
        Assert.assertTrue(isOpened,"Login page doesn't open");
    }
}
