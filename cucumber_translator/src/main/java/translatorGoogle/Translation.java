package translatorGoogle;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;

import java.time.Duration;

public class Translation extends DriverClass {

    public Translation(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }


    public WebElement fromLanguage() {
        return driver.findElement(By.id("com.google.android.apps.translate:id/from_language_button"));
    }

    public WebElement toLanguage() {
        return driver.findElement(By.id("com.google.android.apps.translate:id/to_language_button"));
    }

    public String swipeToLanguage(String language) {
        return "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"" + language + "\"))";
    }

    public WebElement language(String tapLanguage) {
        return driver.findElement(MobileBy.AndroidUIAutomator(swipeToLanguage(tapLanguage)));
    }


    public WebElement enterTextButton() {
        return driver.findElement(By.id("com.google.android.apps.translate:id/enter_text_button"));
    }

    public WebElement enterTextField() {
        return driver.findElement(By.id("com.google.android.apps.translate:id/text_input_field"));
    }

    public WebElement outputTextField() {
        return driver.findElement(By.id("com.google.android.apps.translate:id/text_output_field"));
    }

    public WebElement clear() {
        return driver.findElementByAccessibilityId("Clear");
    }
}
