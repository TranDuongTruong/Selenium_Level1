package login;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;

public class TC02 extends TestBase {

    @Test
    public void testCaseTC02(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Login");
        LoginPage loginPage=new LoginPage();
        loginPage.login("",Constants.PASSWORD);
        softAssert.assertTrue(loginPage.checkErrorMessage("There was a problem with your login and/or errors exist in your form."),"Check error message");
        softAssert.assertAll();

    }
}
