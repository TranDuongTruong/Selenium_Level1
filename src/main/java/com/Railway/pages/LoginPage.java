package com.Railway.pages;

import com.Railway.dataObject.Account;
import com.Railway.driver.DriverManager;
import com.Railway.element.Element;
import com.Railway.model.AccountModel;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
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

    public void login(String username, String password){
        //LogUtils.info("Email: "+username+" and Password: "+password);
        ExtentTestManager.logChildMessage(Status.INFO,"Email: "+username+" and Password: "+password);
        Element.sendKeys(usernameTextBoxBy,username);
        Element.sendKeys(passwordTextBoxBy,password);
        Element.scrollToElement(loginButtonBy);
        Element.click(loginButtonBy);
    }

    public void loginWithValidAccount(AccountModel account) {
        ExtentTestManager.logChildMessage(Status.INFO,"Login with valid account");
        login(account.getUserName(),account.getPassword());
    }

    public void loginWithValidAccount(Account account) {
        ExtentTestManager.logChildMessage(Status.INFO,"Login with valid account");
        login(account.getUsername(),account.getPassword());

    }
    public void loginSuccess(){
        loginWithValidAccount(Account.VALID_ACCOUNT);
    }



    public void loginMultipleTime(AccountModel accountModel, int time){
        ExtentTestManager.logMessageWithStep(Status.INFO,"Login Multiple time");

        for(int i=0;i<time;i++){
            loginWithValidAccount(accountModel);
        }
    }

    public String getLoginErrorMessage(){
        return Element.getText(errorMessageLabelBy);
    }
    public void goToForgotPasswordPage(){
        Element.click(forgotPasswordLinkBy);
    }




}
