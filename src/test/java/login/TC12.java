package login;

import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.driver.DriverManager;
import com.Railway.model.RegisterInfo;
import com.Railway.pages.*;
import com.Railway.report.ExtentTestManager;
import com.Railway.untilities.MailService;
import com.aventstack.extentreports.Status;
import com.mailslurp.models.InboxDto;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.untilities.Helpers;
import com.Railway.untilities.MailBoxManager;


import io.qameta.allure.*;

import java.util.Map;

@Epic("Login Function")
@Feature("Valid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC12 extends TestBase {
    @Test(description = "Errors display when password reset token is blank (Using UI)")
    public void errorsDisplayWhenPasswordResetTokenIsBlankUsingUI(){
        LogUtils.info("TC12: Errors display when password reset token is blank (Using UI)");

//        Step 1:Navigate to QA Railway Login page
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");

        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();

//        Step 2:Click on "Forgot Password page" link
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Forgot Password page\" link+");

        loginPage.goToForgotPasswordPage();

        PasswordResetForm passwordResetForm =new PasswordResetForm();
//        Step 3:Enter the email address of the created account in Pre-condition
//        Step 4:Click on "Send Instructions" button
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Enter the email address of the created account in Pre-condition");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Click on \"Send Instructions\" button");


        passwordResetForm.resetPassword(Constants.AccountInfo.RESET_PASSWORD_EMAIL);

//        Step 5:Open mailbox and click on reset password link
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 5:Open mailbox and click on reset password link");


        DriverManager.get_driver().get(Constants.MAILBOX_URL);
        MailBoxManager mailBoxPage=new MailBoxManager();
        mailBoxPage.goToResetPasswordLink(Helpers.splitString(Constants.AccountInfo.RESET_PASSWORD_EMAIL,"@")[0]);
        PasswordChangeForm passwordChangeForm=new PasswordChangeForm();

//        Step 6:Enter new passwords and remove the Password Reset Token
//        Step 7:Click "Reset Password" button
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 6:Enter new passwords and remove the Password Reset Token");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 7:Click \"Reset Password\" button");


        passwordChangeForm.resetPasswordWithEmptyToken(Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD);
        Assert.assertTrue(passwordChangeForm.isErrorMessageDisplayed(),"Check error message displays above the form.");
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isTokenFieldErrorMessageDisplayed(),"Check token field error message displays next to the 'Password Reset Token' field.");
        Assert.assertEquals(passwordChangeForm.getTokenFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);



    }



    @Test(description = "Errors display when password reset token is blank (using API)"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestData.class)
    public void errorsDisplayWhenPasswordResetTokenIsBlankUsingAPI(Map<String, Object> data) throws Exception {
        LogUtils.info("TC12: Errors display when password reset token is blank (using API)");

//      Pre-condition: Create and activate a new account
        ExtentTestManager.logMessageWithStep(Status.INFO,"Pre-condition: Create and activate a new account");


        BasePage.goToSpecificPage(Constants.TabName.REGISTER);
        MailService mailService =new MailService();
        InboxDto newEmail=mailService.createShortInbox();

        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(newEmail.getEmailAddress(),(String) data.get(Constants.DataProviderKey.PASSWORD_KEY),
                (String) data.get(Constants.DataProviderKey.CONFIRM_PASSWORD_KEY),(String) data.get(Constants.DataProviderKey.REGISTER_PIP_KEY));
        registerPage.registerAccount(registerInfo);

        String confirmEmail=mailService.getEmailContent(newEmail,Constants.MaiLService.TIME_OUT,Constants.MaiLService.ACTIVE_ACCOUNT_TITLE_PREFIX,Constants.MaiLService.SYSTEM_SENDER);
        String activeLink=mailService.extractLinkFromBody(confirmEmail);
        DriverManager.get_driver().get(activeLink);
        DriverManager.get_driver().get(Constants.BASE_URL);


//        Step 1:Navigate to QA Railway Login page
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


        passwordResetForm.resetPassword(newEmail.getEmailAddress());
//        Step 5:Open mailbox and click on reset password link
        LogUtils.info("Open mailbox and click on reset password link");
        ExtentTestManager.logMessageWithStep(Status.INFO," Step 5:Open mailbox and click on reset password link");


        String resetPasswordEmail=mailService.getEmailContent(newEmail,Constants.MaiLService.TIME_OUT,Constants.MaiLService.RESET_PASSWORD_TITLE_PREFIX,Constants.MaiLService.SYSTEM_SENDER);
        String changePasswordLink=mailService.extractLinkFromBody(resetPasswordEmail);
        DriverManager.get_driver().get(changePasswordLink);



//        Step 6:Enter new passwords and remove the Password Reset Token
//        Step 7:Click "Reset Password" button
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 6:Enter new passwords and remove the Password Reset Token");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 7:Click \"Reset Password\" button");


        PasswordChangeForm passwordChangeForm=new PasswordChangeForm();
        Assert.assertTrue(passwordChangeForm.getHeadingForm().equals(Constants.PageHeading.CHANGE_PASSWORD_FORM_HEADING));

        passwordChangeForm.resetPasswordWithEmptyToken( data.get(Constants.DataProviderKey.NEW_PASSWORD_KEY).toString(),data.get(Constants.DataProviderKey.CONFIRM_PASSWORD_KEY).toString());


        Assert.assertTrue(passwordChangeForm.isErrorMessageDisplayed(),"Check error message displays above the form.");
        Assert.assertEquals(passwordChangeForm.getErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_ERROR_MESSAGE);
        Assert.assertTrue(passwordChangeForm.isTokenFieldErrorMessageDisplayed(),"Check token field error message displays next to the 'Password Reset Token' field.");
        Assert.assertEquals(passwordChangeForm.getTokenFieldErrorMessage(),Constants.Message.CHANGE_PASSWORD_FORM_TOKEN_FIELD_ERROR_MESSAGE);



    }
}
