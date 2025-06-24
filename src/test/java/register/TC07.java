package register;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class TC07  extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Register");

        RegisterPage registerPage=new RegisterPage();
        registerPage.quickRegister(Constants.NEW_EMAIL);
        softAssert.assertTrue(registerPage.checkSuccessMessage("Thank you for registering your account"),"Check success message");

        softAssert.assertAll();

    }
}
