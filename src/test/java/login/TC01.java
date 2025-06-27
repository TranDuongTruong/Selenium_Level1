package login;

import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.HomePage;
import com.Railway.pages.LoginPage;

import io.qameta.allure.*;

@Epic("Login Function")
@Feature("Valid Login")
@Severity(SeverityLevel.CRITICAL)

public class TC01 extends TestBase {


    @Test(description = "User can log into Railway with valid username and password")
    public void userCanLogIntoRailwayWithValidUsernameAndPassword(){
        LogUtils.info("TC1: User can log into Railway with valid username and password");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Login" tab
        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO," Step 2:Click on Login tab");

        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();

//        Step 3:Enter valid Email and Password
//        Step 4:Click on "Login" button
        LogUtils.info(" Enter valid Email and Password and  Click on \"Login\" button");
        ExtentTestManager.logMessage(Status.INFO," Step 3:Enter valid Email and Password");
        ExtentTestManager.logMessage(Status.INFO," Step 4:Click on \"Login\" button");
        loginPage.loginSuccess();
        Assert.assertEquals(homePage.getWelcomeText(),Constants.Message.HOME_WELCOME_MESSAGE,"Check welcome text in home page");

    }
}
