package com.Railway.dataObject;

import com.Railway.constant.Constants;

public enum Account {
    VALID_ACCOUNT(Constants.AccountInfo.USERNAME, Constants.AccountInfo.PASSWORD),
    INVALID_USERNAME_ACCOUNT("", Constants.AccountInfo.PASSWORD),
    INACTIVE_ACCOUNT(Constants.AccountInfo.EMAIL_INACTIVE, Constants.AccountInfo.PASSWORD),
    INVALID_PASSWORD_ACCOUNT(Constants.AccountInfo.USERNAME, "");

    private String username;
    private String password;
    Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
