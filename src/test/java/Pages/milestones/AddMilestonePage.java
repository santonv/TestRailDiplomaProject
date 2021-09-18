package Pages.milestones;

import Base.BasePage;
import Elements.Input;
import Pages.Projects.ProjectsPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddMilestonePage extends BasePage {

    private static final By ADD_MIL_TITLE = By.xpath("//div[contains(text(),'Add Milestone')]");

    @FindBy(xpath = "//button[@id='accept']")
    private WebElement addMilestoneButton;

    @FindBy(xpath = "//input[@class='dirty-trackable']")
    private WebElement checkbox;

    public AddMilestonePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check is Add Milestone page is open")
    @Override
    public boolean isPageOpened() {
        log.debug("Check Add Milestone page is opened by locator: {}",ADD_MIL_TITLE);
        return isExist(ADD_MIL_TITLE);
    }

    @Step("Create new Milestone")
    public ProjectsPage createMilestone(Milestone milestone) {
        log.info("Create new project {}", milestone.getName());
        new Input(driver, "Name").write(milestone.getName());
        new Input(driver, "Reference").write(milestone.getReferences());
        new Input(driver, "Start_on").write(milestone.getStartDate());
        new Input(driver, "Due_on").write(milestone.getEndDate());
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].scrollIntoView()", checkbox);
        checkbox.click();
        addMilestoneButton.click();
        return new ProjectsPage(driver);
    }
}
