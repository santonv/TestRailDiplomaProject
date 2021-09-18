package Tests;


import Steps.BaseSteps;
import Steps.LoginPageSteps;
import Steps.ProjectSteps;
import config.UserConfig;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest{

    @Test(description = "Create new Project")
    public void createNewProject(){
        BaseSteps baseSteps = new BaseSteps(driver);
     baseSteps.
             openLoginPage(UserConfig.getBaseUrl())
     .isLoginPageOpened();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
     loginPageSteps.
             inputEmailAndPassword(UserConfig.getEMAIL(),UserConfig.getPASSWORD())
             .clickLoginButton()
             .isHomePageOpened();
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.
                clickAddNewProjectButton().
                isAddProjectPageOpened().
                createNewProject("Use a single repository","SomeName").
                isProjectsPageOpened().
                getMessageAfterCreatedProject().
                checkProjectIsExistOnTheProjectsPage("SomeName");
    }

    @Test(description = "Delete project")
    public void deleteProject(){
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.
                openLoginPage(UserConfig.getBaseUrl())
                .isLoginPageOpened();
        LoginPageSteps loginPageSteps = new LoginPageSteps(driver);
        loginPageSteps.
                inputEmailAndPassword(UserConfig.getEMAIL(),UserConfig.getPASSWORD())
                .clickLoginButton()
                .isHomePageOpened();
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.
                clickAddNewProjectButton().
                isAddProjectPageOpened().
                createNewProject("Use a single repository","ForDelete").
                isProjectsPageOpened().
                getMessageAfterCreatedProject().
                checkProjectIsExistOnTheProjectsPage("ForDelete").
                deleteCreatedProject("ForDelete").
                getMessageAfterDeletedProject();
    }
}
