package utils;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base extends DriverClass {

    public Base(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private static void setupAndroid() throws Exception {
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

        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    }

    @BeforeAll
    static void setUp() throws Exception {
        setupAndroid();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Starting the test....");
    }

    @AfterAll
    static void close() {
        System.out.println("End of the test.");
        driver.closeApp();
        driver.quit();
    }
}
