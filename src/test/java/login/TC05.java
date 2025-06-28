package login;

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
public class TC05 extends TestBase {

    @Test(description = "System shows message when user enters wrong password several times")
    public void systemShowsMessageWhenUserEntersWrongPasswordSeveralTimes(){
        LogUtils.info("TC5: System shows message when user enters wrong password several times");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Login" tab

        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO,"Step 2:Click on \"Login\" tab");

        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        Step 3:Enter valid information into "Username" textbox except "Password" textbox.
//        Step 4:Click on "Login" button
//        Step 5:Repeat step 3 three more times.

        ExtentTestManager.logMessage(Status.INFO,"Step 3:Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        ExtentTestManager.logMessage(Status.INFO,"Step 4:Click on \"Login\" button");
        ExtentTestManager.logMessage(Status.INFO,"Step 5:Repeat step 3 three more times.");



        loginPage.loginMutipleTime(4);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_SEVERAL_TIME_ERROR_MESSAGE,
                "Check error message");



    }
}
