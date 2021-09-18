package Pages;

import Base.BasePage;
import Elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class LoginPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Log In')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'loginpage-message')]")
    private WebElement loginPageErrorMessage;

    @FindBy(xpath = "//div[@class='error-alert']")
    private WebElement alert;

    private static final By LOGIN_PAGE_TITLE = By.xpath("//h1[contains(text(),'Log into')]");

    private static final By ALERT_MESSAGE = By.xpath("//div[@class='error-text']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check if login page is opened")
    public boolean isPageOpened() {
       log.debug("Check Login page is opened by locator: {}",LOGIN_PAGE_TITLE);
        return isExist(LOGIN_PAGE_TITLE);
    }

    @Step("Log in by email: {email}, password: {password}")
    public LoginPage fillEmailAndPasswordFields(String email, String password){
       log.info("Log in by email: {}, password: {}", email,password);
       new Input(driver,"Name").write(email);
       new Input(driver,"Password").write(password);
        return this;
    }

    @Step("Click on the Login button")
    public HomePage clickLoginButton(){
        loginButton.click();
        return new HomePage(driver);
    }

    @Step("Open page by {url}")
    public LoginPage openLoginPage(String url){
        log.info("Open Login page by URL: {}", url);
        driver.get(url);
        return new LoginPage(driver);
    }

    @Step("Get error message")
    public String getErrorMessage(){
if(loginPageErrorMessage.isDisplayed()){
   return loginPageErrorMessage.getText();
}
  else return driver.findElement(ALERT_MESSAGE).getText();
    }
}
