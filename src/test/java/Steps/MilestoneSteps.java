package Steps;

import Pages.MilestoneModalPage;
import Pages.Projects.ProjectDetailsPage;
import Pages.Projects.ProjectsPage;
import Pages.milestones.AddMilestonePage;
import Pages.milestones.MilestonesPage;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MilestoneSteps {

    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    MilestonesPage milestonesPage;
    AddMilestonePage addMilestonePage;

    public MilestoneSteps(WebDriver driver){
        projectsPage = new ProjectsPage(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
    }

    public MilestoneSteps clickAddMilestone(){
        projectDetailsPage.clickAddNewMilestoneButton();
        return this;
    }

    public MilestoneSteps isMilestonePageOpened(){
        boolean isOpened = addMilestonePage.isPageOpened();
        Assert.assertTrue(isOpened,"Add milestone page didn't open");
        return this;
    }

    public MilestoneSteps createNewMilestone(Milestone milestone){
        addMilestonePage.createMilestone(milestone);
        return this;
    }

    public MilestoneSteps isCreatedMilestoneExist(Milestone milestone){
        milestonesPage.milestoneIsExist(milestone);
        return this;
    }
}
