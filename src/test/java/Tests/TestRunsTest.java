package Tests;

import Steps.BaseSteps;
import Steps.LoginPageSteps;
import Steps.ProjectSteps;
import Steps.TestRunsSteps;
import config.UserConfig;
import models.TestRun;
import models.TestRunFactory;
import org.testng.annotations.Test;

public class TestRunsTest extends BaseTest{

    @Test(description = "Create Test Run")
    public void testRunShouldBeCreated() {
        TestRun testRun = TestRunFactory.get();
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.openLoginPage(UserConfig.getBaseUrl()).
                isLoginPageOpened();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.inputEmailAndPassword(UserConfig.getEMAIL(),UserConfig.getPASSWORD()).
                clickLoginButton().
                isHomePageOpened();
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.
                clickAddNewProjectButton().
                isAddProjectPageOpened().
                createNewProject("Use a single repository","ProjectForTestRun1").
                isProjectsPageOpened().
                getMessageAfterCreatedProject().
                checkProjectIsExistOnTheProjectsPage("ProjectForTestRun1").
                openProjectDetailsPage("ProjectForTestRun1");
        TestRunsSteps testRunsSteps = new TestRunsSteps(driver);
        testRunsSteps.
                clickAddTestRunButton().
                isTestRunDetailsPageIsOpened().
                createNewTestRun(testRun).
                validateMessageAfterAdditionOfTestRun().
                openTestRunsPage().
                createdTestRunIsExist(testRun);
    }
    }
