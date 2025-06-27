package change_password;

import base.TestBase;
import com.Railway.constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;

import io.qameta.allure.*;

@Epic("Change Password Function")
@Feature("Valid Change Password")
@Severity(SeverityLevel.CRITICAL)
public class TC09 extends TestBase {

    @Test(description = "User can change password")
    public void userCanChangePassword(){

//        1. Navigate to QA Railway Website
//        2. Login with valid account
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginWithValidAccount(Constants.AccountInfo.USERNAME,Constants.AccountInfo.PASSWORD);
//        3. Click on "Change Password" tab
        BasePage.goToSpecificPage(Constants.TabName.CHANGE_PASSWORD);
        ChangePasswordPage changePasswordPage=new ChangePasswordPage();
//        4. Enter valid value into all fields.
//        5. Click on "Change Password" button
        changePasswordPage.changePassword(Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD);
        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(),Constants.Message.CHANGE_PASSWORD_SUCCESS_MESSAGE,"Check change password success message");

    }
}
