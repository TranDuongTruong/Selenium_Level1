package com.Railway.until;

import com.Railway.driver.DriverManager;
import com.Railway.element.Element;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import com.Railway.pages.BasePage;
import org.openqa.selenium.WebDriverException;

public class MailBoxManager extends BasePage {
    private final By editEmailTextBoxBy =By.xpath("//span[@title='Click to Edit']/input");
    private final By saveEditButtonBy =By.xpath("//button[@class='save button small']");
    private final By editEmailButtonBy =By.xpath("//span[@title='Click to Edit']");
    private final By emailLinkBy =By.xpath("//td[text()='thanhletraining03@gmail.com ']");
    private  final  By resetPasswordLinkBy =By.xpath("//div[@class='email_body']/a");




    public  void goToResetPasswordLink(String email){
        Element.click(editEmailButtonBy);
        Element.sendKeys(editEmailTextBoxBy,email);
        Element.click(saveEditButtonBy);
        Helpers.waitElementToBeClickable(emailLinkBy, 120);

        Element.clickEmail(emailLinkBy);
        Helpers.waitElementToBeClickable(resetPasswordLinkBy, 120);

        try {
            DriverManager.get_driver().get(Element.getText(resetPasswordLinkBy));
        } catch (WebDriverException e){
            ExtentTestManager.logChildMessage(Status.INFO,"WebDriverException occurred: " + e.getMessage());
        }
    }
}
