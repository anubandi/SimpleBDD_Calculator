package stepdefinitions;

import calculator.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

public class StepDefs {

    private static final Logger log = LogManager.getLogger(StepDefs.class);
    private Calculator calc = new Calculator();
    private int b;

    private int a;
    private int result;

    @Given("I have the numbers {int} and {int}")
    public void givenMethod(Integer a, Integer b) {
        this.a = a;
        this.b = b;
        log.info("Initialized numbers: a = {}, b = {}", a, b);
    }

    @When("I add them")
    public void whenMethod() {
        result = calc.add(a,b);
        log.info("Added numbers to get result: {}", result);
    }

    @Then("the result is {int}")
    public void thenMethod(Integer sum) {
        log.info("Verifying expected sum: {} against actual result: {}", sum, result);
        Assert.assertEquals(result, sum.intValue());
    }
}
