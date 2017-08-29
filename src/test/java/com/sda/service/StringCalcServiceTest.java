package com.sda.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalcServiceTest {

    private StringCalcService stringCalcService;

    @Before
    public void init() {
        stringCalcService = new StringCalcService();
    }

    @Test
    public void shouldSumDigitsInGivenString() {
        String givenValue = "5;3";
        int actualValue = stringCalcService.calc(givenValue);
        int expected = 8;
        Assert.assertEquals("Numbers are not equal", expected, actualValue);
    }

    @Test
    public void shouldSumNumbersForGivenString() {
        String givenValue = "23;333";
        int expected = 356;
        int actualValue = stringCalcService.calc(givenValue);
        Assert.assertEquals("Numbers are not equal", expected, actualValue);
    }

    @Test
    public void shouldSumManynumbersInGivenString() {
        String givenValue = "22;32;2;6;8";
        int expected = 70;
        int actualValue = stringCalcService.calc(givenValue);
        Assert.assertEquals("Numbers are not equal", expected, actualValue);
    }
}
