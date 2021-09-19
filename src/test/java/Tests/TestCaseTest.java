package Tests;

import Steps.BaseSteps;
import Steps.LoginPageSteps;
import Steps.ProjectSteps;
import Steps.TestCaseSteps;
import config.UserConfig;
import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest{

    @Test(description = "Create new Test Case")
    public void createTestCase(){
        TestCase testCase = TestCaseFactory.get();
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
                createNewProject("Use a single repository","SomeName2").
                isProjectsPageOpened().
                getMessageAfterCreatedProject().
                checkProjectIsExistOnTheProjectsPage("SomeName2").
                openProjectDetailsPage("SomeName2");
        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.
                clickAdd().
                isAddTestCasePadeIsOpened().
                createNewTestCase(testCase);
    }

    @Test(description = "Delete Test Case")
    public void deleteTestCase(){
        TestCase testCase = TestCaseFactory.get();
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
                createNewProject("Use a single repository","ProjectForDeleteTestCase2").
                isProjectsPageOpened().
                getMessageAfterCreatedProject().
                checkProjectIsExistOnTheProjectsPage("ProjectForDeleteTestCase2").
                openProjectDetailsPage("ProjectForDeleteTestCase2");
        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.
                clickAdd().
                isAddTestCasePadeIsOpened().
                createNewTestCase(testCase).
                deleteTestCase(testCase);
    }
}
