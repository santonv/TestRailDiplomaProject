package Pages.Projects;

import Base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Log4j2
public class ProjectsPage extends BasePage {

    private static final By PROJECTS_PAGE_TITLE = By.xpath("//div[contains(text(),'Projects')]");
    private String projectName = "//a[contains(text(),'%s')]";
    private By successMessage = By.xpath("//div[@class='message message-success']");
    private static final String PROJECT_NAME_ON_DASHBOARD = "//div[contains(@class,'table summary')]//following::a[contains(text(),'%s')]";

    @FindBy(xpath = "//a[contains(text(),'Dashboard')]")
    private WebElement dashBoardButton;

    private String deleteIcon = "//a[contains(text(),'%s')]//ancestor-or-self::tr[@class='odd hoverSensitive']//div[@class='icon-small-delete']";

    @FindBy(xpath = "//span[@class='dialog-confirm-busy']//following::input[@name='deleteCheckbox']")
    private WebElement deleteCheckbox;

    @FindBy(xpath = "//div[@id='deleteDialog']//a[contains(text(),'OK')]")
    private WebElement okButton;

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        log.debug("Check Products page is opened by locator: {}",PROJECTS_PAGE_TITLE);
        return isExist(PROJECTS_PAGE_TITLE);
    }

    @Step("Get success message on the Projects page")
    public String getMessage (){
        log.debug("Get message on the Projects page after created project by locator {}",successMessage);
        return driver.findElement(successMessage).getText();
    }

    @Step("Check project is exist")
    public boolean projectIsExist(String name){
        return driver.findElement(By.xpath(String.format(projectName,name))).isDisplayed();
    }

    @Step("Delete the created project")
    public ProjectsPage deleteProject (String name){
        log.info("Delete the created project");
        driver.findElement(By.xpath(String.format(deleteIcon,name))).click();
        deleteCheckbox.click();
        okButton.click();
        return this;
    }

    @Step("Open {nameProject} project details page")
    public ProjectDetailsPage openProjectDetailsPega(String nameProject){
        log.debug("Open {} project details page",nameProject);
        dashBoardButton.click();
        driver.findElement(By.xpath(String.format(PROJECT_NAME_ON_DASHBOARD,nameProject))).click();
        return new ProjectDetailsPage(driver);
    }

}
