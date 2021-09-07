package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base extends DriverClass {

    public Base(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public static void setUp() throws IOException {
        Properties properties = new Properties();
        FileInputStream propertiesFile = new FileInputStream("variables.properties");
        properties.load(propertiesFile);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", properties.getProperty("deviceName"));
        cap.setCapability("udid", properties.getProperty("udid"));
        cap.setCapability("platformName", properties.getProperty("platformName"));
        cap.setCapability("platformVersion", properties.getProperty("platformVersion"));
        cap.setCapability("autoGrantPermissions", properties.getProperty("autoGrantPermissions"));
        cap.setCapability("appPackage", properties.getProperty("appPackage"));
        cap.setCapability("appActivity", properties.getProperty("appActivity"));

        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    public static void atStart() throws IOException {
        setUp();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Starting the test....");
    }

    public static void close() {
        System.out.println("End of the test.");
        driver.closeApp();
        driver.quit();
    }
}
