package com.sda.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;

    private List<Account> accounts;

    private List<User> users;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
        this.users = new ArrayList<User>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
