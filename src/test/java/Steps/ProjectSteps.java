package Steps;

import Pages.Projects.AddProjectPage;
import Pages.HomePage;
import Pages.Projects.ProjectsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProjectSteps {

    HomePage homePage;
    AddProjectPage addProjectPage;
    ProjectsPage projectsPage;

    public ProjectSteps (WebDriver driver){
        homePage = new HomePage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
    }

    public ProjectSteps clickAddNewProjectButton(){
        homePage.clickButtonAddProject();
        return this;
    }

    public ProjectSteps isAddProjectPageOpened(){
        boolean isOpened = addProjectPage.isPageOpened();
        Assert.assertTrue(isOpened,"Add Project page doesn't open");
        return this;
    }

    public ProjectSteps createNewProject(String numOfRepository, String projectName){
        addProjectPage.addNewProject(numOfRepository,projectName);
        return this;
    }

    public ProjectSteps isProjectsPageOpened(){
        boolean isOpened = projectsPage.isPageOpened();
        Assert.assertTrue(isOpened,"Project Details Page doesn't open");
        return this;
    }

    public ProjectSteps getMessageAfterCreatedProject(){
        String actualMessage = projectsPage.getMessage();
        Assert.assertEquals(actualMessage,"Successfully added the new project.", "Project doesn't create");
        return this;
    }

    public ProjectSteps checkProjectIsExistOnTheProjectsPage(String projectName){
        boolean isExist = projectsPage.projectIsExist(projectName);
        Assert.assertTrue(isExist,"Project doesn't exist");
        return this;
    }

    public ProjectSteps deleteCreatedProject(String projectName){
        projectsPage.deleteProject(projectName);
        return this;
    }

    public ProjectSteps getMessageAfterDeletedProject(){
        String actualMessage = projectsPage.getMessage();
        Assert.assertEquals(actualMessage,"Successfully deleted the project.","Project doesn't delete");
        return this;
    }

    public ProjectSteps openProjectDetailsPage(String projectName){
        projectsPage.openProjectDetailsPega(projectName);
        return this;
}
}
