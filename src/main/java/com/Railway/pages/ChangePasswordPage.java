package com.Railway.pages;

import com.Railway.element.Element;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class ChangePasswordPage extends BasePage {

    private final By currPasswordTextBoxBy =By.id("currentPassword");
    private final By newPasswordTextBoxBy =By.id("newPassword");
    private final By confirmNewPasswordTextBoxBy =By.id("confirmPassword");
    private final By changePassButtonBy =By.xpath("//input[@type='submit']");
    private final By successMessageTextBy =By.xpath("//p[@class='message success']");


    public void changePassword(String currentPass, String newPass,String confirmNewPass){
        ExtentTestManager.logChildMessage(Status.INFO,"Current password: "+currentPass+"\t New password: "+newPass+"\tConfirm new password: "+confirmNewPass);

        Element.sendKeys(currPasswordTextBoxBy,currentPass);
        Element.sendKeys(newPasswordTextBoxBy,newPass);
        Element.sendKeys(confirmNewPasswordTextBoxBy,confirmNewPass);
        Element.scrollToElement(changePassButtonBy);
        Element.click(changePassButtonBy);

    }

    public String getChangePasswordSuccessMessage(){

        return Element.getText(successMessageTextBy);
    }





}
