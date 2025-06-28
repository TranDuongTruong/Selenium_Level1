package com.Railway.pages;

import com.Railway.dataObject.Account;
import com.Railway.driver.DriverManager;
import com.Railway.log.LogUtils;
import com.Railway.untilities.Helpers;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    private final By usernameTextBoxBy =By.id("username");
    private final By passwordTextBoxBy =By.id("password");
    private final By loginButtonBy =By.xpath("//input[@type='submit']");
    private final By errorMessageLabelBy =By.xpath("//p[@class='message error LoginForm']");
    private final By forgotPasswordLinkBy =By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");




    private List<WebElement> getErrorMessages(){
        return DriverManager.get_driver().findElements(errorMessageLabelBy);
    }


    public void loginWithValidAccount(Account account) {
        LogUtils.info("Email: "+account.getUsername()+" and Password: "+account.getPassword());
        getElement(passwordTextBoxBy).clear();
        getElement(usernameTextBoxBy).sendKeys(account.getUsername());
        getElement(passwordTextBoxBy).clear();
        getElement(passwordTextBoxBy).sendKeys(account.getPassword());
        Helpers.scrollDown();
        getElement(loginButtonBy).click();
    }
    public void loginSuccess(){
        loginWithValidAccount(Account.VALID_ACCOUNT);
    }



    public void loginMutipleTime(int time){
        LogUtils.info("Email: "+Account.INVALID_PASSWORD_ACCOUNT.getUsername()+" and Password: "+Account.INVALID_PASSWORD_ACCOUNT.getPassword());

        for(int i=0;i<time;i++){
            loginWithValidAccount(Account.INVALID_PASSWORD_ACCOUNT);
        }
    }

    public String getLoginErrorMessage(){
        return getElement(errorMessageLabelBy).getText();
    }
    public void goToForgotPasswordPage(){
        getElement(forgotPasswordLinkBy).click();
    }




}
