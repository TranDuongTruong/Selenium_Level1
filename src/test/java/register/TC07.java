package register;

import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.RegisterInfo;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;

import io.qameta.allure.*;

@Epic("Register Account")
@Feature("Valid Register")
@Severity(SeverityLevel.CRITICAL)
public class TC07  extends TestBase {

    @Test(description = "User can create new account")
    public void userCanCreateNewAccount(){
        LogUtils.info("TC7: User can create new account");


//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Register" tab
        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO,"Step 2:Click on \"Register\" tab");


        BasePage.goToSpecificPage(Constants.TabName.REGISTER);
        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(Constants.AccountInfo.NEW_EMAIL,Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PID);

//        Step 3:Enter valid information into all fields
//        Step 4:Click on "Register" button
        ExtentTestManager.logMessage(Status.INFO,"Step 3:Enter valid information into all fields");
        ExtentTestManager.logMessage(Status.INFO,"Step 4:Click on \"Register\" button");

        registerPage.registerAccount(registerInfo);
        Assert.assertEquals(registerPage.getSuccessMessage(),Constants.Message.REGISTER_SUCCESS_MESSAGE,"Check success message");


    }
}
