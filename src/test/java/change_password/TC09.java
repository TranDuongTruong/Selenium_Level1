package change_password;

import base.TestBase;
import constant.Constants;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.ChangePasswordPage;
import pages.LoginPage;

public class TC09 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Login");
        LoginPage loginPage=new LoginPage();
        loginPage.login(Constants.USERNAME,Constants.PASSWORD);
        BasePage.goToSpecificPage("Change password");
        ChangePasswordPage changePasswordPage=new ChangePasswordPage();
        changePasswordPage.changePassword(Constants.PASSWORD,Constants.PASSWORD,Constants.PASSWORD);
        softAssert.assertTrue(changePasswordPage.checkSuccessMessage("Your password has been updated"),"Check success message");
        softAssert.assertAll();

    }
}
