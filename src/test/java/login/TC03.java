package login;

import base.TestBase;
import com.Railway.constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

public class TC03 extends TestBase {

    @Test
    public void userCanNotLogIntoRailwayWithInvalidPassword(){

//        1. Navigate to QA Railway Website
//        2. Click on "Login" tab
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        3. Enter valid Email and invalid Password
//        4. Click on "Login" button
        loginPage.loginWithValidAccount(Constants.AccountInfo.USERNAME, "111");
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_ERROR_MESSAGE,"Check error message");

    }

}
