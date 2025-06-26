package login;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.PasswordChangeForm;
import com.Railway.pages.PasswordResetForm;
import com.Railway.untilities.Helpers;
import com.Railway.untilities.MailBoxManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13 extends TestBase {


    @Test
    public void errorsDisplayWhenPasswordAndConfirmDoNotMatchOnReset(){

//    1. Navigate to QA Railway Login page

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

//    6. Enter different values for password fields
//    7. Click "Reset Password" button
        PasswordChangeForm passwordChangeForm=new PasswordChangeForm();
        passwordChangeForm.resetPassword(Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD+" ");

        Assert.assertTrue(passwordChangeForm.isErrorMessageDisplayed(),"Check error message displays above the form.");
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_PASSWORD_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isConfirmPasswordFieldErrorMessageDisplayed(),"Check confirm password field error message displays next to the 'Confirm Password' field.");
        Assert.assertEquals(passwordChangeForm.getConfirmPasswordFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_CONFIRM_PASSWORD_FIELD_ERROR_MESSAGE);






    }


}
