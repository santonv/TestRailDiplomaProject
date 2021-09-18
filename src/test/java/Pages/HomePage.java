package Pages;

import Base.BasePage;
import Pages.Projects.AddProjectPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HomePage extends BasePage {

    public static final By ALL_PROJECT_TITLE = By.xpath("//div[contains(text(),'All Projects')]");

    @FindBy(xpath = "//a[contains(text(),'Add Project')]")
    private WebElement addProjectButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check if home page is opened")
    public boolean isPageOpened() {
        log.debug("Check Home page is opened by locator: {}", ALL_PROJECT_TITLE);
        return isExist(ALL_PROJECT_TITLE);
    }

    @Step("Click the button 'Add Project'")
    public AddProjectPage clickButtonAddProject() {
        log.debug("Click the button 'Add Project'");
        addProjectButton.click();
        return new AddProjectPage(driver);
    }
}
