package login;

import com.Railway.dataObject.Account;
import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

import io.qameta.allure.*;

@Epic("Login Function")
@Feature("InValid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC08 extends TestBase {

    @Test(description = "User can't login with an account hasn't been activated")
    public void userCanNotLoginWithAccountHasNotBeenActivated(){
        LogUtils.info("TC8: User can't login with an account hasn't been activated");


//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Login" tab

        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO,"Step 2:Click on \"Login\" tab");

        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();

//        Step 3:Enter username and password of account hasn't been activated.
//        Step 4:Click on "Login" button
        ExtentTestManager.logMessage(Status.INFO,"Step 3:Enter username and password of account hasn't been activated.");
        ExtentTestManager.logMessage(Status.INFO,"Step 4:Click on \"Login\" button");


        loginPage.loginWithValidAccount(Account.INACTIVE_ACCOUNT);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_INVALID_USERNAME_PASSWORD_ERROR_MESSAGE,"Check error message");
        softAssert.assertTrue(!BasePage.isMenuItemIsExist(Constants.TabName.LOGOUT),"Check User can't login ");


    }
}
