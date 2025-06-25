package com.Railway.pages;

import org.openqa.selenium.By;
import com.Railway.untilities.Helpers;

public class PasswordChangeForm extends BasePage{
    private final By newPasswordTextBoxBy =By.xpath("//input[@id='newPassword']");
    private final By confirmNewPasswordTextBoxBy =By.xpath("//input[@id='confirmPassword']");
    private final By resetTokenTextBoxBy =By.xpath("//input[@id='resetToken']");
    private final By resetPassButtonBy =By.xpath("//input[@type='submit']");
    private final By resetErrorMessageBy =By.xpath("//p[@class='message error']");
    private final By resetTokenFieldErrorMessageBy =By.xpath("//label[@for='resetToken' and @class='validation-error']");




    public void resetPasswordWithEmptyToken(String newPassword,String confirmPassword){
        Helpers.waitElement(newPasswordTextBoxBy,30);
        getElement(newPasswordTextBoxBy).sendKeys(newPassword);
        getElement(confirmNewPasswordTextBoxBy).sendKeys(confirmPassword);
        getElement(resetTokenTextBoxBy).clear();
        getElement(resetPassButtonBy).click();
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





}
