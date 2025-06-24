package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {

    private final By usernameTextBox=By.id("username");
    private final By passwordTextBox=By.id("password");
    private final By loginButton=By.xpath("//input[@type='submit']");
    private final By errorMessageLabel=By.xpath("//p[@class='message error LoginForm']");

    public LoginPage() {
        super("Login page");
    }


    private WebElement getUsernameTextBox(){
        return DriverManager.get_driver().findElement(usernameTextBox);
    }

    private WebElement getPasswordTextBox(){
        return DriverManager.get_driver().findElement(passwordTextBox);
    }

    private WebElement getLoginButton(){
        return DriverManager.get_driver().findElement(loginButton);
    }

    private List<WebElement> getErrorMessages(){
        return DriverManager.get_driver().findElements(errorMessageLabel);
    }


    public void login(String userName, String password){
        getUsernameTextBox().sendKeys(userName);
        getPasswordTextBox().sendKeys(password);
        BasePage.scrollDown();
        getLoginButton().click();
    }

    public boolean checkErrorMessage(String message){
        if(getErrorMessages().size()>0)
        {
            return getErrorMessages().get(0).getText().equals(message);
        }
        return false;
    }




}
