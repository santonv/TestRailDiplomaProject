package Steps;

import Pages.Projects.ProjectDetailsPage;
import Pages.testRuns.AddTestRunPage;
import Pages.testRuns.TestRunDetailsPage;
import Pages.testRuns.TestRunsPage;
import models.TestRun;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class TestRunsSteps {

    ProjectDetailsPage projectDetailsPage;
    AddTestRunPage addTestRunPage;
    TestRunDetailsPage testRunDetailsPage;
    TestRunsPage testRunsPage;

    public TestRunsSteps(WebDriver driver) {
        projectDetailsPage = new ProjectDetailsPage(driver);
        addTestRunPage = new AddTestRunPage(driver);
        testRunDetailsPage = new TestRunDetailsPage(driver);
        testRunsPage = new TestRunsPage(driver);
    }

    public TestRunsSteps clickAddTestRunButton() {
        projectDetailsPage.clickAddNewTestRunButton();
        return this;
    }

    public TestRunsSteps isTestRunDetailsPageIsOpened() {
        boolean isOpened = addTestRunPage.isPageOpened();
        assertTrue(isOpened, "Test Run Details page doesn't open");
        return this;
    }

    public TestRunsSteps createNewTestRun(TestRun testRun) {
        addTestRunPage.createTestRun(testRun);
        return this;
    }

    public TestRunsSteps validateMessageAfterAdditionOfTestRun() {
        testRunDetailsPage
                .validateMessageAfterAdditionOfTestRun();
        return this;
    }

    public TestRunsSteps openTestRunsPage() {
        testRunDetailsPage
                .openTestRunsPage();
        boolean isOpened = testRunsPage.isPageOpened();
        assertTrue(isOpened, "Test Runs Page doesn't open");
        return this;
    }

    public TestRunsSteps createdTestRunIsExist(TestRun testRun){
        testRunsPage.testRunIsExist(testRun);
        return this;
    }
}
