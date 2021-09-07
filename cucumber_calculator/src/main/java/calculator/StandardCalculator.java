package calculator;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;

import java.time.Duration;

public class StandardCalculator extends DriverClass {

    public StandardCalculator(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public WebElement numberKey(int number) { // 0-9
        return driver.findElementByAccessibilityId(String.valueOf(number));
        }

    public WebElement nonNumericKey(String operation) { // Division, Multiplication, Minus, Plus, Equal, Clear
        return driver.findElementByAccessibilityId(operation);
    }
}
