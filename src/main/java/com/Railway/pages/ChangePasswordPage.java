package com.Railway.pages;

import com.Railway.log.LogUtils;
import com.Railway.untilities.Helpers;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {

    private final By currPasswordTextBoxBy =By.id("currentPassword");
    private final By newPasswordTextBoxBy =By.id("newPassword");
    private final By confirmNewPasswordTextBoxBy =By.id("confirmPassword");
    private final By changePassButtonBy =By.xpath("//input[@type='submit']");
    private final By successMessageTextBy =By.xpath("//p[@class='message success']");


    public void changePassword(String currentPass, String newPass,String confirmNewPass){
        LogUtils.info("Current password: "+currentPass+"\t New password: "+newPass+"\tConfirm new password: "+confirmNewPass);

        getElement(currPasswordTextBoxBy).sendKeys(currentPass);
        getElement(newPasswordTextBoxBy).sendKeys(newPass);
        getElement(confirmNewPasswordTextBoxBy).sendKeys(confirmNewPass);
        Helpers.scrollDown();
        getElement(changePassButtonBy).click();

    }

    public String getChangePasswordSuccessMessage(){

        return getElement(successMessageTextBy).getText();
    }





}
