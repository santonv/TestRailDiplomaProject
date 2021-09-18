package Pages.Projects;

import Base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddProjectPage extends BasePage {

    private static final By ADD_PROJECT_PAGE_TITLE = By.xpath("//div[contains(text(),'Add Project')]");

    @FindBy(xpath = "//a[@id='projects-tabs-project']")
    private WebElement projectMenuItem;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    private String typeOfRepository = "//strong[contains(text(),'%s')]/following-sibling::input[@type='radio']";

    @FindBy(xpath = "//button[contains(text(),'Add Project')]")
    private WebElement addProjectButton;


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Check if Add Project page is opened")
    public boolean isPageOpened() {
        log.debug("Check Home page is opened by locator: {}", ADD_PROJECT_PAGE_TITLE);
        return isExist(ADD_PROJECT_PAGE_TITLE);
    }

    @Step("Add new project with name {projectName}")
    public ProjectsPage addNewProject(String nameOfRepository, String projectName){
        projectMenuItem.click();
        nameField.sendKeys(projectName);
        driver.findElement(By.xpath(String.format(typeOfRepository,nameOfRepository))).click();
        addProjectButton.click();
        return new ProjectsPage(driver);
    }
}
