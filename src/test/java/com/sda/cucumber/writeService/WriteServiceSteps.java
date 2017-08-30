package com.sda.cucumber.writeService;

import com.sda.service.WriteService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WriteServiceSteps {

    private WriteService writeService;

    private String givenName;

    @Given("^I create new write service$")
    public void i_create_new_write_service() {
        writeService = new WriteService();
    }

    @When("^i pass example name$")
    public void i_pass_example_name() {
        givenName = "Szymon";
    }

    @Then("^result is correct$")
    public void result_is_correct() {
        Assert.assertEquals("Expected value should be different", "Hello, Szymon", writeService.action(givenName));
    }

    @When("^i pass example names$")
    public void i_pass_example_names() {
        givenName = "Szymon,Marek,Helena";
    }

    @Then("^result for multiple names is correct$")
    public void result_for_multiple_names_is_correct() {
        Assert.assertEquals("Message is not good", "Hello, Szymon, Marek and Helena", writeService.action(givenName));
    }

    @When("^i pass name (.*)$")
    public void i_pass_name_$name(String name) {
        givenName = name;
    }

    @Then("^result for defined name (.*) is correct$")
    public void result_for_name_$name_is_correct(String name) {
        Assert.assertEquals("Expected value should be different", "Hello, " + name, writeService.action(givenName));
    }

    @Then("^result for name (.*) is (.*)$")
    public void result_for_name_$name_is_$expectedResult(String name, String expectedResult) {
        Assert.assertEquals("Expected value should be different", expectedResult, writeService.action(name));
    }
}
