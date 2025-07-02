package login;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.PasswordChangeForm;
import com.Railway.pages.PasswordResetForm;
import com.Railway.report.ExtentTestManager;
import com.Railway.until.Helpers;
import com.Railway.until.MailBoxManager;
import com.aventstack.extentreports.Status;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.qameta.allure.*;

import java.util.Map;

@Epic("Login Function")
@Feature("Valid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC13 extends TestBase {


    @Test(description = "Errors display if password and confirm password don't match when resetting password"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestBase.class)
    public void errorsDisplayWhenPasswordAndConfirmDoNotMatchOnReset(Map<String, Object> data){

//    Step 1:Navigate to QA Railway Login page
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Login page");

        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();

//        Step 2:Click on "Forgot Password page" link
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Forgot Password page\" link");

        loginPage.goToForgotPasswordPage();
        PasswordResetForm passwordResetForm =new PasswordResetForm();

//        Step 3:Enter the email address of the created account in Pre-condition
//        Step 4:Click on "Send Instructions" button
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Enter the email address of the created account in Pre-condition");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Click on \"Send Instructions\" button");

        passwordResetForm.resetPassword(data.get(Constants.DataProviderKey.EMAIL_KEY).toString());

//        Step 5:Open mailbox and click on reset password link
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 5:Open mailbox and click on reset password link");

        DriverManager.get_driver().get(Constants.MAILBOX_URL);
        MailBoxManager mailBoxPage=new MailBoxManager();
        mailBoxPage.goToResetPasswordLink(Helpers.splitString(data.get(Constants.DataProviderKey.EMAIL_KEY).toString(),"@")[0]);

//    Step 6:Enter different values for password fields
//    Step 7:Click "Reset Password" button

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 6:Enter different values for password fields");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 7:Click \"Reset Password\" button");

        PasswordChangeForm passwordChangeForm=new PasswordChangeForm();
        Helpers.waitPage(3);
        Assert.assertEquals(passwordChangeForm.getHeadingForm(),Constants.PageHeading.CHANGE_PASSWORD_FORM_HEADING);
        passwordChangeForm.resetPassword(data.get(Constants.DataProviderKey.NEW_PASSWORD_KEY).toString(),data.get(Constants.DataProviderKey.CONFIRM_PASSWORD_KEY).toString());

        Assert.assertTrue(passwordChangeForm.isErrorMessageDisplayed(),"Check error message displays above the form.");
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_PASSWORD_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isConfirmPasswordFieldErrorMessageDisplayed(),"Check confirm password field error message displays next to the 'Confirm Password' field.");
        Assert.assertEquals(passwordChangeForm.getConfirmPasswordFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_CONFIRM_PASSWORD_FIELD_ERROR_MESSAGE);






    }


}
