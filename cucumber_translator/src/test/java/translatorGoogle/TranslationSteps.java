package translatorGoogle;

import io.cucumber.java8.En;
import utils.Base;

import static org.junit.Assert.assertEquals;


public class TranslationSteps extends Base implements En {

    Translation transl = new Translation(driver);

    public TranslationSteps() {
        super(driver);

        Before(Base::setUp);

        Given("languages {string} and {string}", (String fromLanguage, String toLanguage) -> {
            System.out.println("Starting the test scenario for " + fromLanguage + " and " + toLanguage);

            transl.fromLanguage().click();
            transl.language(fromLanguage).click();
            transl.toLanguage().click();
            transl.language(toLanguage).click();
        });

        When("I type {string}", (String text) -> {
            transl.enterTextButton().click(); // This element displays only before the first translation
            transl.enterTextField().sendKeys(text);
            System.out.println(text);
        });

        Then("I should receive {string}", (String translation) -> {
            assertEquals(transl.outputTextField().getText(), translation);
            transl.clear().click();
            System.out.println(translation);
        });

        After(Base::close);
    }
}