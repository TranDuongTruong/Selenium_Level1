package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends BasePage {

    private final By currPasswordTextBox=By.id("currentPassword");
    private final By newPasswordTextBox=By.id("newPassword");
    private final By confirmNewPasswordTextBox=By.id("confirmPassword");
    private final By changePassButton=By.xpath("//input[@type='submit']");
    private final By successMessageTxt=By.xpath("//p[@class='message success']");


    public void changePassword(String currentPass, String newPass,String confirmNewPass){
        getElement(currPasswordTextBox).sendKeys(currentPass);
        getElement(newPasswordTextBox).sendKeys(newPass);
        getElement(confirmNewPasswordTextBox).sendKeys(confirmNewPass);
        BasePage.scrollDown();
        getElement(changePassButton).click();

    }

    public Boolean checkSuccessMessage(String message){

        return getElement(successMessageTxt).getText().equals(message);
    }

    public ChangePasswordPage() {
        super("Change password");
    }



}
