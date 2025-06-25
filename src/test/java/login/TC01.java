package login;

import base.TestBase;
import com.Railway.constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.HomePage;
import com.Railway.pages.LoginPage;

public class TC01 extends TestBase {

    @Test
    public void userCanLogIntoRailwayWithValidUsernameAndPassword(){

//        1. Navigate to QA Railway Website
//        2. Click on "Login" tab
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();
//        3. Enter valid Email and Password
//        4. Click on "Login" button
        loginPage.loginWithValidAccount(Constants.AccountInfo.USERNAME,Constants.AccountInfo.PASSWORD);
        Assert.assertEquals(homePage.getWelcomeText(),Constants.Message.HOME_WELCOME_MESSAGE,"Check welcome text in home page");

    }
}
