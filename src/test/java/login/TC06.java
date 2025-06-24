package login;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class TC06 extends TestBase {

    @Test
    public void testCaseTC01(){
        BasePage.goToSpecificPage("Login");
        LoginPage loginPage=new LoginPage();
        loginPage.login(Constants.USERNAME,Constants.PASSWORD);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(BasePage.itemIsExist("My ticket"),"Check 'My ticket' item");
        softAssert.assertTrue(BasePage.itemIsExist("Change password"),"Check 'Change password' item");
        softAssert.assertTrue(BasePage.itemIsExist("Log out"),"Check 'Log out' item");

        BasePage.goToSpecificPage("My ticket");
        MyTicketPage myTicketPage=new MyTicketPage();
        softAssert.assertTrue(myTicketPage.pageIsExist(),"Check 'My ticket' page displays");
        BasePage.goToSpecificPage("Change password");
        ChangePasswordPage changePasswordPage=new ChangePasswordPage();
        softAssert.assertTrue(changePasswordPage.pageIsExist(),"Check 'Change password' page displays");


        softAssert.assertAll();

    }
}
