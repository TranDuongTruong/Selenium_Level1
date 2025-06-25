package com.Railway.untilities;

import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import com.Railway.pages.BasePage;

public class MailBoxManager extends BasePage {
    private final By editEmailTextBoxBy =By.xpath("//span[@title='Click to Edit']/input");
    private final By saveEditButtonBy =By.xpath("//button[@class='save button small']");
    private final By editEmailButtonBy =By.xpath("//span[@title='Click to Edit']");
    private final By emailLinkBy =By.xpath("//td[text()='thanhletraining03@gmail.com ']");
    private  final  By resetPasswordLinkBy =By.xpath("//div[@class='email_body']/a");




    public  void goToResetPasswordLink(String email){
        getElement(editEmailButtonBy).click();
        getElement(editEmailTextBoxBy).clear();
        getElement(editEmailTextBoxBy).sendKeys(email);
        getElement(saveEditButtonBy).click();
        Helpers.waitElement(emailLinkBy, 120);

        getElement(emailLinkBy).click();
        Helpers.waitElement(resetPasswordLinkBy, 120);

        DriverManager.get_driver().get(getElement(resetPasswordLinkBy).getText());
    }
}
