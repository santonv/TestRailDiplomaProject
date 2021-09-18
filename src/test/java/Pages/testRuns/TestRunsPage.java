package Pages.testRuns;

import Base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestRun;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

@Log4j2
public class TestRunsPage extends BasePage {

    public static final By TEST_RUNS_PAGE_TITLE = By.xpath("//div[contains(text(),'Test Runs & Results')]");
    public static final String PROJECT_NAME_TEXT = "//a[contains(text(),'%s')]";

    @FindBy(xpath = "//span[contains(text(),'Add Test Run')]")
    private WebElement addTestRunButton;

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Test runs page is opened")
    public boolean isPageOpened() {
        log.debug("Check Test Runs page is opened by locator: {}", TEST_RUNS_PAGE_TITLE);
        return isExist(TEST_RUNS_PAGE_TITLE);
    }

    @Step("Check Test Run is exist")
    public void testRunIsExist(TestRun testRun) {
        String actualName = driver.findElement(By.xpath(String.format(PROJECT_NAME_TEXT, testRun.getName()))).getText();
        log.info("Check Test Run {} is exist", actualName);
        assertTrue(actualName.contains(testRun.getName()), "Test Run is not exist");
    }

    @Step("Click on the Add New Run button")
    public AddTestRunPage clickAddTestRunButton(){
        log.info("click on the Add new test run button");
        addTestRunButton.click();
        return new AddTestRunPage(driver);
    }
}
