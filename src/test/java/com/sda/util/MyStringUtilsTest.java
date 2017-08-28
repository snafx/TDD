package com.sda.util;

import org.junit.Assert;
import org.junit.Test;

import static com.sda.util.MyStringUtils.isUppercase;

public class MyStringUtilsTest {

    @Test
    public void shouldReturnValueWithCapitalLetters() {
        String givenValue = "ALA MA KOTA";
        boolean result = isUppercase(givenValue);
        Assert.assertTrue("Expected value contains lower cases", result);
    }

    @Test
    public void shouldReturnFalseForValueWithLowerCases() {
        String givenValue = "ala ma kota";
        boolean result = isUppercase(givenValue);
        Assert.assertFalse("Result is true", result);
    }
}
