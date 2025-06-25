package login;

import base.TestBase;
import com.Railway.constant.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

public class TC05 extends TestBase {

    @Test
    public void systemShowsMessageWhenUserEntersWrongPasswordSeveralTimes(){

//        1. Navigate to QA Railway Website
//        2. Click on "Login" tab
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        3. Enter valid information into "Username" textbox except "Password" textbox.
//        4. Click on "Login" button
//        5. Repeat step 3 three more times.
        loginPage.loginMutipleTime(Constants.AccountInfo.USERNAME,"",4);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_SEVERAL_TIME_ERROR_MESSAGE,
                "Check error message");



    }
}
