package com.sda.service;

import org.apache.commons.lang3.StringUtils;

import static com.sda.util.MyStringUtils.convertToString;
import static com.sda.util.MyStringUtils.isArray;
import static com.sda.util.MyStringUtils.isUppercase;

public class WriteService {

    public String action(String name) {
        String prefix = initPrefix(name);
        String value = initName(name);
        String suffix = initSuffix(name);
        return prefix + value + suffix;
    }

    private String initPrefix(String name) {
        return isUppercase(name) ? "HELLO, " : "Hello, ";
    }

    private String initSuffix(String name) {
        return isUppercase(name) ? "!" : "";
    }

    private String initName(String name) {
        String returnValue = null;
        if (isArray(name)) {
            returnValue = convertToString(name.split(","));
        }
        return returnValue != null ? returnValue :
                (StringUtils.isBlank(name) ? "my friend" : name);
    }

}
