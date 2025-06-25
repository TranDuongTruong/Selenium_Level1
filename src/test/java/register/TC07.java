package register;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.RegisterInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.RegisterPage;

public class TC07  extends TestBase {

    @Test
    public void userCanCreateNewAccount(){



//        1. Navigate to QA Railway Website
//        2. Click on "Register" tab
        BasePage.goToSpecificPage(Constants.TabName.REGISTER);
        RegisterPage registerPage=new RegisterPage();
        RegisterInfo registerInfo=new RegisterInfo(Constants.AccountInfo.NEW_EMAIL,Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PASSWORD,Constants.AccountInfo.PID);
//        3. Enter valid information into all fields
//        4. Click on "Register" button
        registerPage.registerAccount(registerInfo);
        Assert.assertEquals(registerPage.getSuccessMessage(),Constants.Message.REGISTER_SUCCESS_MESSAGE,"Check success message");


    }
}
