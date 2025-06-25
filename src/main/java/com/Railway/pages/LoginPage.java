package com.Railway.pages;

import com.Railway.driver.DriverManager;
import com.Railway.untilities.Helpers;
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


    public void loginWithValidAccount(String userName, String password){
        getElement(usernameTextBoxBy).sendKeys(userName);
        getElement(passwordTextBoxBy).sendKeys(password);
        Helpers.scrollDown();
        getElement(loginButtonBy).click();
    }

    public void loginMutipleTime(String userName, String password,int time){
        for(int i=0;i<time;i++){
            loginWithValidAccount(userName,password);
        }
    }

    public String getLoginErrorMessage(){
        return getElement(errorMessageLabelBy).getText();
    }
    public void goToForgotPasswordPage(){
        getElement(forgotPasswordLinkBy).click();
    }




}
