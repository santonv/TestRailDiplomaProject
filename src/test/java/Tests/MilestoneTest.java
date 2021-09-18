package Tests;

import Base.BasePage;
import Steps.BaseSteps;
import Steps.LoginPageSteps;
import Steps.MilestoneSteps;
import Steps.ProjectSteps;
import config.UserConfig;
import models.Milestone;
import models.MilestoneFactory;
import org.testng.annotations.Test;

public class MilestoneTest extends BaseTest {

    @Test(description = "Create new Milestone")
    public void createNewMilestone(){
        Milestone milestone = MilestoneFactory.get();
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
                createNewProject("Use a single repository","ProjectForMilestone1").
                isProjectsPageOpened().
                getMessageAfterCreatedProject().
                checkProjectIsExistOnTheProjectsPage("ProjectForMilestone1").
                openProjectDetailsPage("ProjectForMilestone1");
        MilestoneSteps milestoneSteps = new MilestoneSteps(driver);
        milestoneSteps.
                clickAddMilestone().
                isMilestonePageOpened().
                createNewMilestone(milestone).
                isCreatedMilestoneExist(milestone);
    }
}
