package login;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.LoginPage;

public class TC05 extends TestBase {

    @Test
    public void testCaseTC01(){
        BasePage.goToSpecificPage("Login");
        SoftAssert softAssert = new SoftAssert();
        LoginPage loginPage=new LoginPage();
        for(int i=0;i<4;i++){
            loginPage.login(Constants.USERNAME,"");
        }
        softAssert.assertTrue(loginPage.checkErrorMessage("You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes."),
                "Check error message");

        softAssert.assertAll();


    }
}
