package register;

import base.TestBase;
import constant.Constants;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.RegisterPage;

public class TC11 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Register");

        RegisterPage registerPage=new RegisterPage();
        registerPage.register(Constants.NEW_EMAIL,"","","");
        softAssert.assertTrue(registerPage.checkErrorMessage("There're errors in the form. Please correct the errors and try again."),"Check error message");
        softAssert.assertTrue(registerPage.checkPasswordFieldErrorMessage("Invalid password length."),"Check password error message");
        softAssert.assertTrue(registerPage.checkPidFieldErrorMessage("Invalid ID length."),"Check pid error message");
        softAssert.assertAll();

    }
}
