package com.sda.bank;

public class UserFactory {

    private static Integer counter = 0;

    public static User createNewUser(String firstName, String lastName) {
        return new User(counter++, firstName, lastName);
    }

    public static void clearIndex() {
        counter = 0;
    }
}
