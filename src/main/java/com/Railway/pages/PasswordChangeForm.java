package com.Railway.pages;

import com.Railway.element.Element;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import com.Railway.until.Helpers;

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
        Element.clear(resetTokenTextBoxBy);
        Element.click(resetPassButtonBy);
    }
    public void resetPassword(String newPassword,String confirmPassword){
        fillInResetPasswordForm(newPassword,confirmPassword);
        Element.click(resetPassButtonBy);

    }

    public void fillInResetPasswordForm(String newPassword,String confirmPassword){
        ExtentTestManager.logChildMessage(Status.INFO,"New password: "+newPassword+"\tConfirm password: "+newPassword);
        Helpers.waitElementToBeClickable(newPasswordTextBoxBy,30);
        Element.sendKeys(newPasswordTextBoxBy,newPassword);
        Element.sendKeys(confirmNewPasswordTextBoxBy,confirmPassword);


    }



    public Boolean isErrorMessageDisplayed(){
        return !Element.getElements(resetErrorMessageBy).isEmpty();
    }
    public String getErrorMessage(){
        return Element.getText(resetErrorMessageBy);
    }

    public Boolean isTokenFieldErrorMessageDisplayed(){
        return !Element.getElements(resetTokenFieldErrorMessageBy).isEmpty();
    }
    public String getTokenFieldErrorMessage(){
        return Element.getText(resetTokenFieldErrorMessageBy);
    }

    public Boolean isConfirmPasswordFieldErrorMessageDisplayed(){
        return !Element.getElements(resetConfirmPasswordFieldErrorMessageBy).isEmpty();
    }
    public String getConfirmPasswordFieldErrorMessage(){
        return Element.getText(resetConfirmPasswordFieldErrorMessageBy);
    }





}
