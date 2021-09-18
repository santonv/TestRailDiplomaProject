package Pages;

import Base.BasePage;
import org.openqa.selenium.WebDriver;

public class MilestoneModalPage extends BasePage {


    public MilestoneModalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }
}