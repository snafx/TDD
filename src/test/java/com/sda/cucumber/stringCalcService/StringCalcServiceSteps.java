package com.sda.cucumber.stringCalcService;

import com.sda.service.StringCalcService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StringCalcServiceSteps {

    public static final String EXAMPLE_STRING_VALUE = "5;3";

    public static final int EXAMPLE_EXPECTED_VALUE = 8;

    private StringCalcService stringCalcService;

    private String value;

    private int expectedResult;

    @Given("^I initialize String Calc Service$")
    public void i_initialize_string_calc_service() {
        this.stringCalcService = new StringCalcService();
    }

    @When("^I pass example string$")
    public void i_pass_example_string() {
        this.value = EXAMPLE_STRING_VALUE;
    }

    @Then("^Value for example string is correct$")
    public void value_for_example_string_is_correct() {
        Assert.assertEquals("Values is not correct", EXAMPLE_EXPECTED_VALUE, stringCalcService.calc(value));
    }

    @When("^I pass value (.*)$")
    public void i_pass_value_$value(String value) {
        this.value = value;
    }

    @And("^I pass expected result (.*)$")
    public void i_pass_expected_result_$result(int result) {
        this.expectedResult = result;
    }

    @Then("^The sum is correct$")
    public void sum_is_correct() {
        Assert.assertEquals("Sum are not same", expectedResult, stringCalcService.calc(value));
    }
}
