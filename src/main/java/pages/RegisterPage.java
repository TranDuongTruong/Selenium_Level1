package pages;

import constant.Constants;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {


    private final By emailTextBox=By.id("email");
    private final By passwordTextBox=By.id("password");
    private final By confirmPasswordTextBox=By.id("confirmPassword");
    private final By pidTextBox=By.id("pid");
    private final By registerButton=By.xpath("//input[@type='submit']");
    private final By successMessageTxt=By.xpath("//div[@id='content']//p");
    private final By errorMessageTxt=By.xpath("//p[@class='message error']");

    private final By passErrorMessageTxt=By.xpath("//label[@for='password' and @class='validation-error']");
    private final By pidErrorMessageTxt=By.xpath("//label[@for='pid' and @class='validation-error']");

    public RegisterPage() {
        super("Create account");
    }

/*
    private WebElement getEmailTextBox(){
        return DriverManager.get_driver().findElement(emailTextBox);
    }
    private WebElement getPasswordTextBox(){
        return DriverManager.get_driver().findElement(passwordTextBox);
    }
    private WebElement getConfirmPasswordTextBox(){
        return DriverManager.get_driver().findElement(confirmPasswordTextBox);
    }
    private WebElement getPidTextBox(){
        return DriverManager.get_driver().findElement(pidTextBox);
    }
    private WebElement getRegisterButton(){
        return DriverManager.get_driver().findElement(registerButton);
    }

    private WebElement getSuccessMessageTxt(){
        return DriverManager.get_driver().findElement(successMessageTxt);
    }*/



    public void register(String email,String password, String confirmPassword, String pid){
        getElement(emailTextBox).sendKeys(email);
        getElement(passwordTextBox).sendKeys(password);
        getElement(confirmPasswordTextBox).sendKeys(confirmPassword);
        getElement(pidTextBox).sendKeys(pid);
        BasePage.scrollDown();
        getElement(registerButton).click();
    }
    public void quickRegister(String email){
        getElement(emailTextBox).sendKeys(email);
        getElement(passwordTextBox).sendKeys(Constants.PASSWORD);
        getElement(confirmPasswordTextBox).sendKeys(Constants.PASSWORD);
        getElement(pidTextBox).sendKeys(Constants.PID);
        BasePage.scrollDown();
        getElement(registerButton).click();
    }

    public Boolean checkSuccessMessage(String message){
        return getElement(successMessageTxt).getText().equals(message);
    }
    public Boolean checkErrorMessage(String message){
        return getElement(errorMessageTxt).getText().equals(message);
    }

    public  Boolean checkPasswordFieldErrorMessage(String message){
        return  getElement(passErrorMessageTxt).getText().equals(message);
    }
    public Boolean checkPidFieldErrorMessage(String message){
        return getElement(pidErrorMessageTxt).getText().equals(message);
    }


}
