package com.sda.util;

import org.apache.commons.lang3.StringUtils;

public class MyStringUtils {

    public static boolean isUppercase(String value) {
        return StringUtils.isNotBlank(value) && value.equals(value.toUpperCase());
    }

    public static boolean isArray(String value) {
        return StringUtils.isNotBlank(value) && StringUtils.contains(value, ",");
    }

    public static String convertToString(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
            if (isPenultimate(array, i)) {
                stringBuilder.append(" and ");
            } else if (!isLast(array, i)) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    private static boolean isPenultimate(String[] array, int i) {
        return i == array.length - 2;
    }

    private static boolean isLast(String[] array, int i) {
        return i == array.length - 1;
    }
}
