package com.Railway.pages;

import com.Railway.element.Element;
import com.Railway.model.RegisterInfo;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
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
        ExtentTestManager.logChildMessage(Status.INFO,"Register info: "+registerInfo.getRegisterInfo());
        Element.sendKeys(emailTextBoxBy,registerInfo.getEmail());
        Element.sendKeys(passwordTextBoxBy,registerInfo.getPassword());
        Element.sendKeys(confirmPasswordTextBoxBy,registerInfo.getConfirmPassword());
        Element.sendKeys(pidTextBoxBy,registerInfo.getPidNumber());
        Element.scrollToElement(registerButtonBy);
        Element.click(registerButtonBy);
    }


    public String getSuccessMessage(){
        return Element.getText(successMessageTxtBy);
    }
    public String getErrorMessage(){
        return Element.getText(errorMessageTxtBy);
    }

    public  String getPasswordFieldErrorMessage(){
        return  Element.getText(passErrorMessageTxtBy);
    }
    public String getPidFieldErrorMessage(){
        return Element.getText(pidErrorMessageTxtBy);
    }


}
