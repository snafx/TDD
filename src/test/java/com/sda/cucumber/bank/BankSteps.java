package com.sda.cucumber.bank;

import com.sda.bank.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class BankSteps {

    private Bank bank;

    private User user;

    private Account account;

    @Given("^I create new bank$")
    public void i_create_new_bank() {
        this.bank = new Bank("SDA");
    }

    @When("^I create new user$")
    public void i_create_new_user() {
        this.user = UserFactory.createNewUser("Johnny", "Parufka");
    }

    @And("^I add new user to bank$")
    public void i_add_new_user_to_bank() {
        bank.addUser(user);
    }

    @Then("^User is present in bank database$")
    public void user_is_present_in_bank_database() {
        boolean result = bank.getUsers().contains(user);
        Assert.assertTrue("User is not present in bank", result);
    }

    @And("^I create new account$")
    public void i_create_new_account() {
        this.account = AccountFactory.createAccount();
    }

    @And("^I add new user to account$")
    public void i_add_new_user_to_account() {
        this.account.setOwnerId(user.getId());
    }

    @And("^I add account to bank$")
    public void i_add_account_to_bank() {
        bank.addAccount(account);
    }

    @And("^Account is present in bank database$")
    public void account_is_present_in_bank_database() {
        boolean result = bank.getAccounts().contains(account);
        Assert.assertTrue("Account is not present in bank", result);
    }

    @And("^User is attached to account in bank database$")
    public void user_is_attached_to_account_in_bank_database() {
        Account accountFromDatabase = bank.getAccount(this.account.getId());
        User userFromDatabase = bank.getUser(this.user.getId());
        boolean result = accountFromDatabase.getOwnerId().equals(userFromDatabase.getId());
        Assert.assertTrue("Attached user is not correct", result);
    }

    @After
    public void clearFactories() {
        UserFactory.clearIndex();
        AccountFactory.clearIndex();
    }

    @When("^I create new user with firstName (.*) and lastName (.*) and add it to bank$")
    public void i_create_new_user_with_firstName_$firstName_and_lastName_$lastName_and_add_it_to_bank(String firstName, String lastName) {
        this.user = UserFactory.createNewUser(firstName, lastName);
        i_add_new_user_to_bank();
    }

    @And("^I create new account for user (.*) and add it to bank$")
    public void i_create_new_account_for_user_$user_and_add_it_to_bank(Integer id) {
        this.account = AccountFactory.createAccount(id);
        i_add_account_to_bank();
    }

    @Then("^User with id (.*) is present in bank database$")
    public void user_with_id_$id_is_present_in_bank_database(Integer id) {
        boolean result = bank.getUser(id) != null; //pobieramy uzytkownika i jezeli jest rozny od null to jest true
        Assert.assertTrue("User with id " + id + " is not present in database", result);
    }

    @And("^User with id (\\d+) has (.*) accounts$")
    public void user_with_id_$id_has_$number_accounts(Integer id, Integer expectedSize) {
        List<Account> accountsByUser = bank.getAccountsByUser(id);
        Assert.assertEquals("User should have " + expectedSize + " accounts", expectedSize, Integer.valueOf(accountsByUser.size()));
    }

    @And("^I deposit (-?.*) amount of money to account$")
    public void i_deposit_$amount_amount_of_money_to_account(Integer amount) {
        bank.depositFor(amount, this.account.getId());
    }

    @And("^Amount of money (.*) is present in bank database$")
    public void amount_of_money_$amount_is_present_in_bank_database(Integer amount) {
        Account accountFromBank = bank.getAccount(this.account.getId());
        Assert.assertEquals("Account ballance is not correct", amount, accountFromBank.getBalance());
    }


}
