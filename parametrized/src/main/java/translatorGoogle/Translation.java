package translatorGoogle;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.DriverClass;

public class Translation extends DriverClass {

    public Translation(AppiumDriver<WebElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.google.android.apps.translate:id/from_language_button")
    public AndroidElement fromLanguage;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/to_language_button")
    public AndroidElement toLanguage;

    public String language(String language) {
        return "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"" + language + "\"))";
    }

    @AndroidFindBy(id = "com.google.android.apps.translate:id/enter_text_button")
    public AndroidElement enterTextButton;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/text_input_field")
    public AndroidElement enterTextField;

    @AndroidFindBy(id = "com.google.android.apps.translate:id/text_output_field")
    public AndroidElement outputTextField;

    @AndroidFindBy(accessibility = "Clear")
    public AndroidElement clear;
}
