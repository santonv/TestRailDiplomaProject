package Pages.Projects;

import Base.BasePage;
import Pages.MilestoneModalPage;
import Pages.TestCases.AddTestCasePage;
import Pages.milestones.AddMilestonePage;
import Pages.testRuns.AddTestRunPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class ProjectDetailsPage extends BasePage {

    public static final By ACTIONS_TITLE = By.xpath("//div[@class='sidebar-h1 top']");

    @FindBy(xpath = "//a[@id='sidebar-milestones-add' and contains(text(),'Add')]")
    private WebElement addNewMilestonesButton;

    @FindBy(xpath = "//a[@id='sidebar-milestones-viewall' and contains(text(),'View All')]")
    private WebElement viewAllMilestonesButton;

    @FindBy(xpath = "//a[@id='sidebar-runs-add' and contains(text(),'Add')]")
    private WebElement addNewTestRunButton;

    @FindBy(xpath = "//a[@id='sidebar-runs-viewall' and contains(text(),'All')]")
    private WebElement viewTestRunsButton;

    @FindBy(xpath = "//a[@id='sidebar-cases-add' and contains(text(),'Add')]")
    private WebElement addNewTestCaseButton;

    @FindBy(xpath = "//a[@id='sidebar-suites-viewall' and contains(text(),'All')]")
    private WebElement viewAllTestCasesButton;

    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        log.debug("Check Login page is opened by locator: {}", ACTIONS_TITLE);
        return isExist(ACTIONS_TITLE);
    }

    @Step("Click the Add Milestone button")
    public AddMilestonePage clickAddNewMilestoneButton(){
        log.info("click on the Add new Milestone button");
        addNewMilestonesButton.click();
        return new AddMilestonePage(driver);
    }

    @Step("Click the Add Test case button")
    public AddTestCasePage clickAddNewTestCaseButton(){
        log.info("click on the Add new Test case button");
        addNewTestCaseButton.click();
        return new AddTestCasePage(driver);
    }

    @Step("Click the Add Test run button")
    public AddTestRunPage clickAddNewTestRunButton(){
        log.info("click on the Add new Test run button");
        addNewTestRunButton.click();
        return new AddTestRunPage(driver);
    }
}
