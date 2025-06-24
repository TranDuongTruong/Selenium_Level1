package login;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;

public class TC03 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();
        BasePage.goToSpecificPage("Login");
        LoginPage loginPage=new LoginPage();
        loginPage.login(Constants.USERNAME, "111");
        softAssert.assertTrue(loginPage.checkErrorMessage("There was a problem with your login and/or errors exist in your form."),"Check error message");
        softAssert.assertAll();

    }

}
