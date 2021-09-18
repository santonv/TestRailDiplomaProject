package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Input {

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write (String someText){
        log.debug("Write {} into input field who has a label {}", someText, label);
        driver.findElement(By.id(label.toLowerCase())).sendKeys(someText);

    }
}
