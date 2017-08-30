package com.sda.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {
    private String name;

    private List<Account> accounts;

    private List<User> users;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public Account getAccount(Integer id) {
        Account account = null;
        if (id < accounts.size() && id >= 0) {
            account = accounts.get(id);
        }
        return account;
    }

    public User getUser(Integer id) {
        User user = null;
        if (id < users.size() && id >= 0) {
            user = users.get(id);
        }
        return user;
    }

    public List<Account> getAccountsByUser(Integer userId) {
        return this.accounts.stream()
                .filter(e -> e.getOwnerId().equals(userId))
                .collect(Collectors.toList());
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
