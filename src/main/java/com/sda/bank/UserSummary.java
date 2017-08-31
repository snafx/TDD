package com.sda.bank;

import java.util.List;
import java.util.Map;

public class UserSummary implements Comparable<UserSummary> {

    public static UserSummary convert(Map.Entry<Integer, List<Account>> entry) {
        UserSummary userSummary = new UserSummary();
        userSummary.setUserId(entry.getKey());
        userSummary.setTotalBalance(sum(entry.getValue()));
        return userSummary;
    }

    private static Integer sum(List<Account> accounts) {
        return accounts.stream()
                .mapToInt(e -> e.getBalance())
                .sum();
    }


    @Override
    public int compareTo(UserSummary o) {
        //porownuje tutaj SIEBIE do innego usera (o)
        return o.getTotalBalance() - this.getTotalBalance();
    }

    private Integer userId;

    private Integer totalBalance;

    public UserSummary() {
    }

    public UserSummary(Integer userId, Integer totalBalance) {
        this.userId = userId;
        this.totalBalance = totalBalance;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Integer totalBalance) {
        this.totalBalance = totalBalance;
    }

}
