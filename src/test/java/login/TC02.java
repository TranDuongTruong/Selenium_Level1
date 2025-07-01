package login;

import com.Railway.dataObject.Account;
import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.AccountModel;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

import java.util.Map;

@Epic("Login Function")
@Feature("InValid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC02 extends TestBase {


    @Test(description = "User can't login with blank Username textbox"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestBase.class)
    public void userCanNotLoginWithBlankUsernameTextbox(Map<String, Object> data){

//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Login" tab

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Login\" tab");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();

//        Step 3:User doesn't type any words into "Username" textbox but enter valid information into "Password" textbox
//        Step 4:Click on "Login" button

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Click on \"Login\" button");


        AccountModel account=new AccountModel((String) data.get(Constants.DataProviderKey.USERNAME_KEY),(String) data.get(Constants.DataProviderKey.PASSWORD_KEY));
        loginPage.loginWithValidAccount(account);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_ERROR_MESSAGE,"Check error message");

    }
}
