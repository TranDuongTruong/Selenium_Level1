package login;

import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.AccountModel;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import data.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;

import java.util.Map;

@Epic("Login Function")
@Feature("InValid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC05 extends TestBase {

    @Test(description = "System shows message when user enters wrong password several times"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestData.class)
    public void systemShowsMessageWhenUserEntersWrongPasswordSeveralTimes(Map<String, Object> data){
        LogUtils.info("TC5: System shows message when user enters wrong password several times");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Login" tab

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Login\" tab");

        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        Step 3:Enter valid information into "Username" textbox except "Password" textbox.
//        Step 4:Click on "Login" button
//        Step 5:Repeat step 3 three more times.

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Click on \"Login\" button");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 5:Repeat step 3 three more times.");


        AccountModel account=new AccountModel((String) data.get(Constants.DataProviderKey.USERNAME_KEY),(String) data.get(Constants.DataProviderKey.PASSWORD_KEY));
        loginPage.loginMultipleTime(account,4);
        Assert.assertEquals(loginPage.getLoginErrorMessage(),Constants.Message.LOGIN_SEVERAL_TIME_ERROR_MESSAGE,
                "Check error message");



    }
}
