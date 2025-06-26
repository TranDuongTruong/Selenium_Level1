package login;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.model.RegisterInfo;
import com.Railway.pages.*;
import com.Railway.untilities.MailService;
import com.mailslurp.models.InboxDto;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.untilities.Helpers;
import com.Railway.untilities.MailBoxManager;


import io.qameta.allure.*;

@Epic("Login Function")
@Feature("Valid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC12 extends TestBase {
    @Test(description = "Errors display when password reset token is blank (Using UI)")
    public void errorsDisplayWhenPasswordResetTokenIsBlankUsingUI(){
//        1. Navigate to QA Railway Login page
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        2. Click on "Forgot Password page" link

        loginPage.goToForgotPasswordPage();

        PasswordResetForm passwordResetForm =new PasswordResetForm();
//        3. Enter the email address of the created account in Pre-condition
//        4. Click on "Send Instructions" button
        passwordResetForm.resetPassword(Constants.AccountInfo.RESET_PASSWORD_EMAIL);
//        5. Open mailbox and click on reset password link
        DriverManager.get_driver().get(Constants.MAILBOX_URL);
        MailBoxManager mailBoxPage=new MailBoxManager();

        mailBoxPage.goToResetPasswordLink(Helpers.splitString(Constants.AccountInfo.RESET_PASSWORD_EMAIL,"@")[0]);

        PasswordChangeForm passwordChangeForm=new PasswordChangeForm();

//        6. Enter new passwords and remove the Password Reset Token
//        7. Click "Reset Password" button
        passwordChangeForm.resetPasswordWithEmptyToken(Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD);
        Assert.assertTrue(passwordChangeForm.isErrorMessageDisplayed(),"Check error message displays above the form.");
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isTokenFieldErrorMessageDisplayed(),"Check token field error message displays next to the 'Password Reset Token' field.");
        Assert.assertEquals(passwordChangeForm.getTokenFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);



    }



    @Test(description = "Errors display when password reset token is blank (using API)")
    public void errorsDisplayWhenPasswordResetTokenIsBlankUsingAPI() throws Exception {
//      Pre-condition: Create and activate a new account
        BasePage.goToSpecificPage(Constants.TabName.REGISTER);
        MailService mailService =new MailService();
        InboxDto newEmail=mailService.createShortInbox();

        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(newEmail.getEmailAddress(),Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PID);
        registerPage.registerAccount(registerInfo);

        String confirmEmail=mailService.getEmailContent(newEmail,Constants.MaiLService.TIME_OUT,Constants.MaiLService.ACTIVE_ACCOUNT_TITLE_PREFIX,Constants.MaiLService.SYSTEM_SENDER);
        String activeLink=mailService.extractLinkFromBody(confirmEmail);
        DriverManager.get_driver().get(activeLink);
        DriverManager.get_driver().get(Constants.BASE_URL);


//        1. Navigate to QA Railway Login page


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        2. Click on "Forgot Password page" link

        loginPage.goToForgotPasswordPage();

        PasswordResetForm passwordResetForm =new PasswordResetForm();
//        3. Enter the email address of the created account in Pre-condition
//        4. Click on "Send Instructions" button
        passwordResetForm.resetPassword(newEmail.getEmailAddress());
//        5. Open mailbox and click on reset password link
        /*DriverManager.get_driver().get(Constants.MAILBOX_URL);
        MailBoxManager mailBoxPage=new MailBoxManager();

        mailBoxPage.goToResetPasswordLink(Helpers.splitString(Constants.AccountInfo.RESET_PASSWORD_EMAIL,"@")[0]);
*/

        String resetPasswordEmail=mailService.getEmailContent(newEmail,Constants.MaiLService.TIME_OUT,Constants.MaiLService.RESET_PASSWORD_TITLE_PREFIX,Constants.MaiLService.SYSTEM_SENDER);
        String changePasswordLink=mailService.extractLinkFromBody(resetPasswordEmail);
        DriverManager.get_driver().get(changePasswordLink);



//        6. Enter new passwords and remove the Password Reset Token
//        7. Click "Reset Password" button
        PasswordChangeForm passwordChangeForm=new PasswordChangeForm();
        Assert.assertTrue(passwordChangeForm.getHeadingForm().equals(Constants.PageHeading.CHANGE_PASSWORD_FORM_HEADING));
        passwordChangeForm.resetPasswordWithEmptyToken(Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD);


        Assert.assertTrue(passwordChangeForm.isErrorMessageDisplayed(),"Check error message displays above the form.");
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isTokenFieldErrorMessageDisplayed(),"Check token field error message displays next to the 'Password Reset Token' field.");
        Assert.assertEquals(passwordChangeForm.getTokenFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_FIELD_ERROR_MESSAGE);



    }
}
