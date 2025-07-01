package com.Railway.model;

public class AccountModel {
    String userName;
    String password;

    public AccountModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
