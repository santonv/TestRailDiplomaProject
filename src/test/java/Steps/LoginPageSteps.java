package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageSteps {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    public LoginPageSteps inputEmailAndPassword(String email, String password){
        loginPage.fillEmailAndPasswordFields(email,password);
        return this;
    }

    public LoginPageSteps clickLoginButton(){
        loginPage.clickLoginButton();
        return this;
    }

    public void isHomePageOpened(){
      boolean isOpen = homePage.isPageOpened();
        Assert.assertTrue(isOpen,"Home page doesn't open");
    }

    public void checkErrorMessage(String errorMessage){
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualMessage,errorMessage,"The error messages do not match");
    }
}
