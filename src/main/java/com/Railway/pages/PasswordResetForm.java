package com.Railway.pages;

import com.Railway.element.Element;
import com.Railway.log.LogUtils;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class PasswordResetForm extends BasePage {

    private final By emailTextBoxBy =By.id("email");
    private final By sendInstructionButtonBy =By.xpath("//input[@type='submit']");


    public void resetPassword(String email){
        ExtentTestManager.logChildMessage(Status.INFO,"Email: "+email);

        Element.sendKeys(emailTextBoxBy,email);
        Element.click(sendInstructionButtonBy);
    }



}
