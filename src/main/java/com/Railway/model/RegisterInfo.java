package com.Railway.model;

import com.Railway.constant.Constants;

public class RegisterInfo {
    String email;
    String password;
    String confirmPassword;
    String pidNumber;

    public RegisterInfo(String email, String password, String confirmPassword, String pidNumber) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.pidNumber = pidNumber;
    }
    public RegisterInfo() {
        this.email = "";
        this.password = Constants.AccountInfo.PASSWORD;
        this.confirmPassword = Constants.AccountInfo.PASSWORD;
        this.pidNumber = Constants.AccountInfo.PID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setPidNumber(String pidNumber) {
        this.pidNumber = pidNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPidNumber() {
        return pidNumber;
    }
}
