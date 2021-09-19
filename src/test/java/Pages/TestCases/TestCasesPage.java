package Pages.TestCases;

import Base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class TestCasesPage extends BasePage {

    private static final By TEST_CASES_TITLE = By.xpath("//div[contains(text(),'Test Cases')]");

    @FindBy(xpath = "//span[contains(text(),'Add Test Case')]")
    private WebElement addTestCaseButton;

    private String deleteIcon = "//span[contains(text(),'%s')]//preceding::input[@type='checkbox'][2]";

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Test cases page is opened")
    @Override
    public boolean isPageOpened() {
        log.debug("Check Test cases page is opened by locator: {}",TEST_CASES_TITLE);
        return isExist(TEST_CASES_TITLE);
    }

    @Step("Click on the Add Test Case button")
    public AddTestCasePage clickAddTestCaseButton(){
        log.info("Click on the Add Test Case button");
        addTestCaseButton.click();
        return new AddTestCasePage(driver);
    }

    @Step("Delete Test Case")
    public TestCasesPage deleteTestCase(String testCaseName){
        log.info("Delete test case {}", testCaseName);
        driver.findElement(By.xpath(String.format(deleteIcon,testCaseName))).click();
        WebElement element1 = driver.findElement(By.xpath("//a[@id='deleteCases']"));
        wait.until(ExpectedConditions.elementToBeClickable(element1)).click();
        return this;
    }
}
