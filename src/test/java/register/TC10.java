package register;

import base.TestBase;
import constant.Constants;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.RegisterPage;

public class TC10 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Register");

        RegisterPage registerPage=new RegisterPage();
        registerPage.register("sss1623@gmail.com",Constants.PASSWORD,"",Constants.PID);
        softAssert.assertTrue(registerPage.checkErrorMessage("There're errors in the form. Please correct the errors and try again."),"Check error message");

        softAssert.assertAll();

    }
}
