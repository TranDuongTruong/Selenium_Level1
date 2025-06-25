package login;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.PasswordChangeForm;
import com.Railway.pages.PasswordResetForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.untilities.Helpers;
import com.Railway.untilities.MailBoxManager;

public class TC12 extends TestBase {
    @Test
    public void errorsDisplayWhenPasswordResetTokenIsBlank(){
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
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isTokenFieldErrorMessageDisplayed(),"Check token field error message displays next to the 'Password Reset Token' field.");
        Assert.assertEquals(passwordChangeForm.getTokenFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);



    }
}
