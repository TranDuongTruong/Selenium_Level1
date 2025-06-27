package register;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.RegisterInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;

import io.qameta.allure.*;

@Epic("Register Account")
@Feature("InValid Register")
@Severity(SeverityLevel.CRITICAL)
public class TC10 extends TestBase {

    @Test(description = "User can't create account with Confirm password is not the same with Password")
    public void userCanNotCreateAccountWhenConfirmPasswordIsNotTheSameAsPassword(){


//        1. Navigate to QA Railway Website
//        2. Click on "Register" tab
        BasePage.goToSpecificPage(Constants.TabName.REGISTER);

        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(Constants.AccountInfo.NEW_EMAIL,Constants.AccountInfo.PASSWORD,"",Constants.AccountInfo.PID);
//        3. Enter valid information into all fields except "Confirm password" is not the same with "Password"
//        4. Click on "Register" button
        registerPage.registerAccount(registerInfo);
        Assert.assertEquals(registerPage.getErrorMessage(),Constants.Message.REGISTER_ERROR_MESSAGE,"Check error message");


    }
}
