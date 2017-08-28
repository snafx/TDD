package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WriteServiceTest {

    private WriteService writeService;

    @Before
    public void init() {
        writeService = new WriteService();
    }

    @Test
    public void shouldReturnMessageWithGivenName() {
        String givenName = "Krzysio";
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, " + givenName;
        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void clientTest() {
        Assert.assertEquals("Hello, Bob", writeService.action("Bob"));
        Assert.assertEquals("Hello, my friend", writeService.action(null));
        Assert.assertEquals("Hello, my friend", writeService.action(""));
        Assert.assertEquals("Message for given values is invalid","HELLO, JON, MARTIN and ELA!", writeService.action("JON,MARTIN,ELA"));

    }

    @Test
    public void shouldReturnShoutMessageWithGivenCapitalName() {
        //        "ANNA" -> "HELLO, ANNA!"
        String givenName = "ANNA";
        String actualValue = writeService.action(givenName);
        String expectedValue = "HELLO, ANNA!";
        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithNameAsNull() {
        String givenName = null;
        String actualValue = writeService.action(givenName);
        String expectedValue = "Hello, my friend";
        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithGivenEmptyName() {
        String givenValue = "";
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, my friend";
        Assert.assertEquals("Messages are not the same", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageWithGivenNameFilledWithSpaces() {
        String givenValue = "     ";
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, my friend";
        Assert.assertEquals("Message is not correct", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnCorrectMessageForGivenMultipleNames() {
        //name = "Jon, Martin, Ela" -> "Hello, Jon, Martin and Ela"
        String givenValue = "Jon,Martin,Ela";
        String actualValue = writeService.action(givenValue);
        String expectedValue = "Hello, Jon, Martin and Ela";
        Assert.assertEquals("Message for given value is invalid", expectedValue, actualValue);
    }

    @Test
    public void shouldReturnShoutMessageForGivenCapitalNames() {
        String givenValue = "JON,MARTIN,ELA";
        String expectedValue = "HELLO, JON, MARTIN and ELA!";
        String actualValue = writeService.action(givenValue);
        Assert.assertEquals("No shout or incorrect message", expectedValue, actualValue);
    }

}
