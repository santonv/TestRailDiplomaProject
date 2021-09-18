package Pages.TestCases;

import Base.BasePage;
import Elements.DropDown;
import Elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class AddTestCasePage extends BasePage {

    private static final By ADD_TEST_CASE_TITLE = By.xpath("//div[contains(text(),'Add Test Case')]");
    public static final By ADD_TEST_CASE_BUTTON = By.id("accept");

    @FindBy(xpath = "//a[contains(text(),'Test Cases') and @id='navigation-suites']")
    private WebElement testCasesTap;

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Add Test Case page is opened")
    @Override
    public boolean isPageOpened() {
        log.debug("Check Add Test Case page is opened by locator {}",ADD_TEST_CASE_TITLE);
        return isExist(ADD_TEST_CASE_TITLE);
    }

    @Step("Create new test case")
    public AddTestCasePage createTestCase(TestCase testCase){
        log.info("Create new test case {}",testCase.getTitle());
        new Input(driver,"Title").write(testCase.getTitle());
        new DropDown(driver,"Section").selectValue(testCase.getSection());
        new DropDown(driver,"Template").selectValue(testCase.getTemplate());
        new DropDown(driver,"Type").selectValue(testCase.getType());
        new DropDown(driver,"Priority").selectValue(testCase.getPriority());
        new Input(driver, "Estimate").write(testCase.getEstimate());
        new DropDown(driver, "Automation Type").selectValue(testCase.getAutomationType());
        driver.findElement(ADD_TEST_CASE_BUTTON).click();
        return this;
    }

    @Step("Open Test Cases page")
    public TestCasesPage openTestCasesPage(){
        testCasesTap.click();
        return new TestCasesPage(driver);
    }
}
