package com.Railway.pages;

import org.openqa.selenium.By;

public class PasswordResetForm extends BasePage {

    private final By emailTextBoxBy =By.id("email");
    private final By sendInstructionButtonBy =By.xpath("//input[@type='submit']");


    public void resetPassword(String email){
        getElement(emailTextBoxBy).sendKeys(email);
        getElement(sendInstructionButtonBy).click();
    }



}
