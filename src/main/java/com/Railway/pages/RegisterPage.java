package com.Railway.pages;

import com.Railway.log.LogUtils;
import com.Railway.model.RegisterInfo;
import com.Railway.untilities.Helpers;
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {


    private final By emailTextBoxBy =By.id("email");
    private final By passwordTextBoxBy =By.id("password");
    private final By confirmPasswordTextBoxBy =By.id("confirmPassword");
    private final By pidTextBoxBy =By.id("pid");
    private final By registerButtonBy =By.xpath("//input[@type='submit']");
    private final By successMessageTxtBy =By.xpath("//div[@id='content']//p");
    private final By errorMessageTxtBy =By.xpath("//p[@class='message error']");

    private final By passErrorMessageTxtBy =By.xpath("//label[@for='password' and @class='validation-error']");
    private final By pidErrorMessageTxtBy =By.xpath("//label[@for='pid' and @class='validation-error']");






    public void registerAccount(RegisterInfo registerInfo){
        LogUtils.info("Register info: "+registerInfo.getRegisterInfo());
        getElement(emailTextBoxBy).sendKeys(registerInfo.getEmail());
        getElement(passwordTextBoxBy).sendKeys(registerInfo.getPassword());
        getElement(confirmPasswordTextBoxBy).sendKeys(registerInfo.getConfirmPassword());
        getElement(pidTextBoxBy).sendKeys(registerInfo.getPidNumber());
        Helpers.scrollDown();
        getElement(registerButtonBy).click();
    }


    public String getSuccessMessage(){
        return getElement(successMessageTxtBy).getText();
    }
    public String getErrorMessage(){
        return getElement(errorMessageTxtBy).getText();
    }

    public  String getPasswordFieldErrorMessage(){
        return  getElement(passErrorMessageTxtBy).getText();
    }
    public String getPidFieldErrorMessage(){
        return getElement(pidErrorMessageTxtBy).getText();
    }


}
