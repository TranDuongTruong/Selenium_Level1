package login;

import base.TestBase;
import constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class TC01 extends TestBase {

    @Test
    public void testCaseTC01(){
        SoftAssert softAssert = new SoftAssert();

        BasePage.goToSpecificPage("Login");
        LoginPage loginPage=new LoginPage();
        loginPage.login(Constants.USERNAME,Constants.PASSWORD);
        Assert.assertTrue(HomePage.checkWelcomeText(Constants.USERNAME),"Check welcome text in home page");
        softAssert.assertAll();

    }
}
