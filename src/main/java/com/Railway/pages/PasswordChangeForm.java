package com.Railway.pages;

import com.Railway.log.LogUtils;
import org.openqa.selenium.By;
import com.Railway.untilities.Helpers;

public class PasswordChangeForm extends BasePage{
    private final By newPasswordTextBoxBy =By.xpath("//input[@id='newPassword']");
    private final By confirmNewPasswordTextBoxBy =By.xpath("//input[@id='confirmPassword']");
    private final By resetTokenTextBoxBy =By.xpath("//input[@id='resetToken']");
    private final By resetPassButtonBy =By.xpath("//input[@type='submit']");
    private final By resetErrorMessageBy =By.xpath("//p[@class='message error']");
    private final By resetTokenFieldErrorMessageBy =By.xpath("//label[@for='resetToken' and @class='validation-error']");
    private final By resetConfirmPasswordFieldErrorMessageBy =By.xpath("//label[@for='confirmPassword' and @class='validation-error']");




    public void resetPasswordWithEmptyToken(String newPassword,String confirmPassword){
        fillInResetPasswordForm(newPassword,confirmPassword);
        getElement(resetTokenTextBoxBy).clear();
        getElement(resetPassButtonBy).click();
    }
    public void resetPassword(String newPassword,String confirmPassword){
        fillInResetPasswordForm(newPassword,confirmPassword);
        getElement(resetPassButtonBy).click();

    }

    public void fillInResetPasswordForm(String newPassword,String confirmPassword){
        LogUtils.info("New password: "+newPassword+"\tConfirm password: "+newPassword);
        Helpers.waitElementToBeClickable(newPasswordTextBoxBy,30);
        getElement(newPasswordTextBoxBy).sendKeys(newPassword);
        getElement(confirmNewPasswordTextBoxBy).sendKeys(confirmPassword);


    }



    public Boolean isErrorMessageDisplayed(){
        return !getElements(resetErrorMessageBy).isEmpty();
    }
    public String getErrorMessage(){
        return getElement(resetErrorMessageBy).getText();
    }

    public Boolean isTokenFieldErrorMessageDisplayed(){
        return !getElements(resetTokenFieldErrorMessageBy).isEmpty();
    }
    public String getTokenFieldErrorMessage(){
        return getElement(resetTokenFieldErrorMessageBy).getText();
    }

    public Boolean isConfirmPasswordFieldErrorMessageDisplayed(){
        return !getElements(resetConfirmPasswordFieldErrorMessageBy).isEmpty();
    }
    public String getConfirmPasswordFieldErrorMessage(){
        return getElement(resetConfirmPasswordFieldErrorMessageBy).getText();
    }





}
