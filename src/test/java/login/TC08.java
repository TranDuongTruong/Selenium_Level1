package login;

import base.TestBase;
import com.Railway.constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

public class TC08 extends TestBase {

    @Test
    public void userCanNotLoginWithAccountHasNotBeenActivated(){


//        1. Navigate to QA Railway Website
//        2. Click on "Login" tab
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        3. Enter username and password of account hasn't been activated.
//        4. Click on "Login" button
        loginPage.loginWithValidAccount(Constants.AccountInfo.EMAIL_INACTIVE,Constants.AccountInfo.PASSWORD);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_INVALID_USERNAME_PASSWORD_ERROR_MESSAGE,"Check error message");
        softAssert.assertTrue(!BasePage.isMenuItemIsExist(Constants.TabName.LOGOUT),"Check User can't login ");


    }
}
