package Pages.testRuns;

import Base.BasePage;
import Elements.DropDown;
import Elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddTestRunPage extends BasePage {

    private By titleAddRunsPage = By.xpath("//div[contains(text(),'Add Test Run')]");

    @FindBy(xpath = "//button[@id='accept']")
    private WebElement addTestRunButton;


    public AddTestRunPage(WebDriver driver) {
        super(driver);
    }
    @Step("Check Test Runs page is opened")
    @Override
    public boolean isPageOpened() {
        log.debug("Check Test Runs page is opened by locator: {}",titleAddRunsPage);
        return isExist(titleAddRunsPage);
    }

    @Step("Create new Test Run")
    public AddTestRunPage createTestRun(TestRun testRun) {
        log.info("Create new Test Run {}", testRun.getName());
        new Input(driver, "Name").write(testRun.getName());
        new Input(driver, "Refs").write(testRun.getReferences());
        new DropDown(driver, "Assign To").selectValue(testRun.getAssignedTo());
        addTestRunButton.click();
        return this;
    }
}
