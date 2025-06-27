package login;

import com.Railway.dataObject.Account;
import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
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
        LogUtils.info("TC3: User cannot log into Railway with invalid password");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Login" tab

        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO,"Step 2:Click on \"Login\" tab");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        Step 3:Enter valid Email and invalid Password
//        Step 4:Click on "Login" button

        ExtentTestManager.logMessage(Status.INFO,"Step 3:Enter valid Email and invalid Password");
        ExtentTestManager.logMessage(Status.INFO,"Step 4:Click on \"Login\" button");


        loginPage.loginWithValidAccount(Account.INVALID_PASSWORD_ACCOUNT);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_ERROR_MESSAGE,"Check error message");

    }

}
