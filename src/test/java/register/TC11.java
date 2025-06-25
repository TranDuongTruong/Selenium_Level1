package register;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.RegisterInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;

public class TC11 extends TestBase {

    @Test
    public void userCanNotCreateAccountWhenPasswordAndPidFieldsAreEmpty(){


//        1. Navigate to QA Railway Website
//        2. Click on "Register" tab
        BasePage.goToSpecificPage(Constants.TabName.REGISTER);
        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(Constants.AccountInfo.NEW_EMAIL,"","","");
//        3. Enter valid email address and leave other fields empty
//        4. Click on "Register" button
        registerPage.registerAccount(registerInfo);
        Assert.assertEquals(registerPage.getErrorMessage(),Constants.Message.REGISTER_ERROR_MESSAGE,"Check error message");
        Assert.assertEquals(registerPage.getPasswordFieldErrorMessage(),Constants.Message.REGISTER_PASSWORD_LENGTH_ERROR_MESSAGE,"Check password error message");
        Assert.assertEquals(registerPage.getPidFieldErrorMessage(),Constants.Message.REGISTER_PID_LENGTH_ERROR_MESSAGE,"Check pid error message");

    }
}
