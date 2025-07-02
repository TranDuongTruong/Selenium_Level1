package change_password;

import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;

import io.qameta.allure.*;

import java.util.Map;

@Epic("Change Password Function")
@Feature("Valid Change Password")
@Severity(SeverityLevel.CRITICAL)
public class TC09 extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(TC09.class);

    @Test(description = "User can change password"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestBase.class)
    public void userCanChangePassword(Map<String, Object> data){
        LogUtils.info("TC9: User can change password");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Login with valid account
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Login\" tab");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();

        loginPage.loginSuccess();
//        Step 3:Click on "Change Password" tab
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Click on \"Change Password\" tab");


        BasePage.goToSpecificPage(Constants.TabName.CHANGE_PASSWORD);
        ChangePasswordPage changePasswordPage=new ChangePasswordPage();
//        Step 4:Enter valid value into all fields.
//        Step 5:Click on "Change Password" button

        ExtentTestManager.logMessageWithStep(Status.INFO,"4.Enter valid value into all fields.");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 5:Click on \"Change Password\" button");


        changePasswordPage.changePassword(data.get(Constants.DataProviderKey.CURRENT_PASSWORD_KEY).toString()
                                            ,data.get(Constants.DataProviderKey.NEW_PASSWORD_KEY).toString()
                                                ,data.get(Constants.DataProviderKey.CONFIRM_PASSWORD_KEY).toString());

        Assert.assertEquals(changePasswordPage.getChangePasswordSuccessMessage(),Constants.Message.CHANGE_PASSWORD_SUCCESS_MESSAGE,"Check change password success message");

    }

}
