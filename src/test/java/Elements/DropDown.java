package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class DropDown {

    private WebDriver driver;
    private String label;
    private String locator = "//label[contains(text(),'%s')]//following-sibling::div";
    private String locatorWithOption = "//li[contains(text(),'%s')]";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectValue(String value){
        log.debug("Select {} option in {} dropdown",value,label);
        WebElement element = driver.findElement(By.xpath(String.format(locator,label)));
        element.click();
        element = driver.findElement(By.xpath(String.format(locatorWithOption,value)));
        element.click();

    }
}
