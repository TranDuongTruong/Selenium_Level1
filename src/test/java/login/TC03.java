package login;

import base.TestBase;
import com.Railway.constant.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

@Epic("Login Function")
@Feature("InValid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC03 extends TestBase {

    @Test(description = "User cannot log into Railway with invalid password")
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
