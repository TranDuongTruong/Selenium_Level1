package com.Railway.pages;

import com.Railway.log.LogUtils;
import org.openqa.selenium.By;

public class PasswordResetForm extends BasePage {

    private final By emailTextBoxBy =By.id("email");
    private final By sendInstructionButtonBy =By.xpath("//input[@type='submit']");


    public void resetPassword(String email){
        LogUtils.info("Email: "+email);

        getElement(emailTextBoxBy).sendKeys(email);
        getElement(sendInstructionButtonBy).click();
    }



}
