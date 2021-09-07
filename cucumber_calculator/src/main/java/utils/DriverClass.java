package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class DriverClass {

    protected static AppiumDriver<WebElement> driver;

    public DriverClass(AppiumDriver<WebElement> driver) {
        this.driver = driver;
    }

}