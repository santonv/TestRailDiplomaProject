package Pages.testRuns;

import Base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

@Log4j2
public class TestRunDetailsPage extends BasePage {

    public static final By MESSAGE = By.xpath("//div[@class='message message-success']");
    public static final By TEST_RUNS_PAGE = By.xpath("//a[contains(text(),'Test Runs & Results')]");

    public TestRunDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Test Run details page is opened")
    public boolean isPageOpened() {
        log.debug("Check Test Run details page is opened by locator: {}", MESSAGE);
        return isExist(MESSAGE);
    }

    @Step("Validate message after the addition of the Test Run")
    public void validateMessageAfterAdditionOfTestRun() {
        log.debug("Get message by locator {}", MESSAGE);
        String message = driver.findElement(MESSAGE).getText();
        assertEquals(message, "Successfully added the new test run.",
                "Test run details page was not opened");
    }

    @Step("Open Test Runs page")
    public TestRunsPage openTestRunsPage() {
        log.debug("Click menu 'Test Runs & Results' by locator: {}", TEST_RUNS_PAGE);
        driver.findElement(TEST_RUNS_PAGE).click();
        return new TestRunsPage(driver);
    }
}
