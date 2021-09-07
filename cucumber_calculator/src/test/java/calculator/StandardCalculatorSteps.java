package calculator;

import io.cucumber.java8.En;
import org.junit.Assert;
import utils.Base;

public class StandardCalculatorSteps extends Base implements En {

    StandardCalculator standardCalculator = new StandardCalculator(driver);

    public StandardCalculatorSteps() {
        super(driver);

        Given("launched Calculator", () -> {
            setUp();
            System.out.println("Starting the test scenario");
        });

        When("I'm doing {string} on {int} and {int}", (String operation, Integer int1, Integer int2) -> {
            standardCalculator.numberKey(int1).click();
            standardCalculator.nonNumericKey(operation).click();
            standardCalculator.numberKey(int2).click();
            standardCalculator.nonNumericKey("Equal").click();
            System.out.println(operation+ ": " + int1 +", "+ int2);
        });

        Then("I should receive {}", (String resultStr) -> {
            double resDouble = Double.parseDouble(resultStr);
            if (resDouble % 1 == 0) {
                int resInt = (int)resDouble;
                Assert.assertEquals(standardCalculator.nonNumericKey(resInt + " Calculation result").getText(), resultStr);
            } else {
                Assert.assertEquals(standardCalculator.nonNumericKey(resDouble + " Calculation result").getText(), resultStr);
            }
            System.out.println("= " + resultStr);
        });

        After(Base::close);
    }
}