package login;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.ChangePasswordPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.MyTicketPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Epic("Login Function")
@Feature("Valid Login")
@Severity(SeverityLevel.CRITICAL)
public class TC06 extends TestBase {

    @Test(description = "Additional pages display once user logged in")
    public void additionalPagesDisplayOnceUserLoggedIn(){



//        1. Navigate to QA Railway Website
//        2. Click on "Login" tab
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
//        3. Login with valid account
        loginPage.loginWithValidAccount(Constants.AccountInfo.USERNAME,Constants.AccountInfo.PASSWORD);


        softAssert.assertTrue(BasePage.isMenuItemIsExist(Constants.TabName.MY_TICKET),"Check 'My ticket' item");
        softAssert.assertTrue(BasePage.isMenuItemIsExist(Constants.TabName.CHANGE_PASSWORD),"Check 'Change password' item");
        softAssert.assertTrue(BasePage.isMenuItemIsExist(Constants.TabName.LOGOUT),"Check 'Log out' item");

        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        MyTicketPage myTicketPage=new MyTicketPage();
        softAssert.assertTrue(myTicketPage.isPageDisplayed(Constants.PageHeading.MY_TICKET_HEADING_TEXT),"Check 'My ticket' page displays");
        BasePage.goToSpecificPage(Constants.TabName.CHANGE_PASSWORD);
        ChangePasswordPage changePasswordPage=new ChangePasswordPage();
        softAssert.assertTrue(changePasswordPage.isPageDisplayed(Constants.PageHeading.CHANGE_PASSWORD_HEADING_TEXT),"Check 'Change password' page displays");



    }
}
