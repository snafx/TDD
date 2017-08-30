package com.sda.bank;

public class Account {
    private Integer id;

    private Integer balance;

    private Integer ownerId;

    public Account() {
    }

    public Account(Integer id, Integer balance) {
        this.balance = balance;
        this.id = id;
    }

    public Account(Integer id, Integer balance, Integer ownerId) {
        this.id = id;
        this.balance = balance;
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}
