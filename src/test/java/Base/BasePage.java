package Base;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


@Log4j2
public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver,this);
    }


    public abstract boolean isPageOpened();

public boolean isExist(By locator) {
    try {
        log.debug("Find element on the page by locator: {}", locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator);
        return true;
    } catch (NoSuchElementException exception) {
        log.fatal("Element was not found on the page by locator: {}", locator);
        System.out.println(exception.getMessage());
        return false;
    }
}
}
