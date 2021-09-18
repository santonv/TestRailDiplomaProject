package Pages.milestones;

import Base.BasePage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

@Log4j2
public class MilestonesPage extends BasePage {

    private static final By MILESTONES_PAGE_TITLE = By.xpath("//div[contains(text(),'Milestones')]");
    public static final String NAME_PROJECT = "//*[contains(@id,'milestone')]//*[contains(text(),'%s')]";

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check is Milestones page is open")
    @Override
    public boolean isPageOpened() {
        log.debug("Check Milestone page is opened by locator: {}", MILESTONES_PAGE_TITLE);
        return isExist(MILESTONES_PAGE_TITLE);
    }

    @Step("Check milestone is exist")
    public void milestoneIsExist(Milestone milestone) {
        boolean isExist = driver.findElement(By.xpath(String.format(NAME_PROJECT, milestone.getName()))).isDisplayed();
        log.info("Check milestone {} is exist", milestone.getName());
        assertTrue(isExist, "Milestone didn't create");
    }

}
