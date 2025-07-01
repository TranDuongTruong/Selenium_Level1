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

import java.util.Map;

@Epic("Register Account")
@Feature("InValid Register")
@Severity(SeverityLevel.CRITICAL)
public class TC10 extends TestBase {

    @Test(description = "User can't create account with Confirm password is not the same with Password"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestBase.class)
    public void userCanNotCreateAccountWhenConfirmPasswordIsNotTheSameAsPassword(Map<String, Object> data){

//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Register" tab

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Register\" tab");


        BasePage.goToSpecificPage(Constants.TabName.REGISTER);

        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(
                Constants.AccountInfo.EMAIL_PREFIX+data.get(Constants.DataProviderKey.EMAIL_KEY).toString(),
                data.get(Constants.DataProviderKey.NEW_PASSWORD_KEY).toString(),
                data.get(Constants.DataProviderKey.CONFIRM_PASSWORD_KEY).toString(),
                data.get(Constants.DataProviderKey.REGISTER_PIP_KEY).toString());

//        Step 3:Enter valid information into all fields except "Confirm password" is not the same with "Password"
//        Step 4:Click on "Register" button

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Click on \"Register\" button");


        registerPage.registerAccount(registerInfo);
        Assert.assertEquals(registerPage.getErrorMessage(),Constants.Message.REGISTER_ERROR_MESSAGE,"Check error message");


    }
}
