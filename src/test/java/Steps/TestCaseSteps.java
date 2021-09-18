package Steps;

import Pages.Projects.ProjectDetailsPage;
import Pages.Projects.ProjectsPage;
import Pages.TestCases.AddTestCasePage;
import Pages.TestCases.TestCasesPage;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestCaseSteps {

    ProjectsPage projectsPage;
    ProjectDetailsPage projectDetailsPage;
    AddTestCasePage addTestCasePage;
    TestCasesPage testCasesPage;

    public TestCaseSteps(WebDriver driver) {
        projectsPage = new ProjectsPage(driver);
        projectDetailsPage = new ProjectDetailsPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        testCasesPage = new TestCasesPage(driver);
    }

    public TestCaseSteps clickAdd(){
        projectDetailsPage.clickAddNewTestCaseButton();
        return this;
    }

    public TestCaseSteps isAddTestCasePadeIsOpened(){
        boolean isOpen = addTestCasePage.isPageOpened();
        Assert.assertTrue(isOpen,"Add Test Case page doesn't open");
        return this;
    }

    public TestCaseSteps createNewTestCase(TestCase testCase){
        addTestCasePage.createTestCase(testCase);
        return this;
    }

    public TestCaseSteps deleteTestCase(TestCase testCase){
        addTestCasePage.openTestCasesPage();
        testCasesPage.deleteTestCase(testCase.getTitle());
        return this;
    }
}
