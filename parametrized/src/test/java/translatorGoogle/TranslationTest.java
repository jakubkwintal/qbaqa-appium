package translatorGoogle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import utils.Base;
import utils.Utils;

public class TranslationTest extends Base {

    public TranslationTest() {
        super(driver);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/translationData.csv", numLinesToSkip = 1)
    public void translate(String fromLanguage, String toLanguage, String text, String translation) {
        Translation transl = new Translation(driver);
        Utils.selectLanguagesForParametrizedTests(driver, transl, fromLanguage, toLanguage);

        try {
            transl.enterTextButton.click(); // This element displays only before the first translation
        } catch (Exception ignored) {
        } finally {
            transl.enterTextField.sendKeys(text);
        }
        Assertions.assertEquals(transl.outputTextField.getText(), translation);
        transl.clear.click();
    }
}