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

    private String deleteIcon = "//span[contains(text(),'%s')]//following::div[@class='icon-small-delete hidden action-hover']";

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
        WebElement element = driver.findElement(By.xpath(String.format(deleteIcon,testCaseName)));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // ArrayList<WebElement> deletePermanently = new ArrayList(driver.findElements(By.xpath("//a[contains(text(),'Mark as Deleted')]")));
        WebElement element1 = driver.findElement(By.xpath("//a[contains(text(),'Mark as Deleted')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element1);
        return this;
    }
}
