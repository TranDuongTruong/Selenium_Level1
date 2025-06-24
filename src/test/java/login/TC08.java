package login;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class TC08 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Login");
        LoginPage loginPage=new LoginPage();
        loginPage.login(Constants.EMAIL_INACTIVE,Constants.PASSWORD);
        softAssert.assertTrue(loginPage.checkErrorMessage("Invalid username or password. Please try again."),"Check error message");
        softAssert.assertTrue(!BasePage.itemIsExist("Log out"),"Check User can't login ");

        softAssert.assertAll();

    }
}
