package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import translatorGoogle.Translation;

public class Utils {

    static WebDriverWait wait;

    /* WAITERS */

    public static void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForElementToBeVisible(WebDriver driver, AndroidElement element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /* METHODS */

    public static void selectLanguagesForParametrizedTests(AppiumDriver<WebElement> driver, Translation translation, String fromLanguage, String toLanguage) {
        translation.fromLanguage.click();
        driver.findElement(MobileBy.AndroidUIAutomator(translation.language(fromLanguage))).click();

        translation.toLanguage.click();
        driver.findElement(MobileBy.AndroidUIAutomator(translation.language(toLanguage))).click();
    }
}