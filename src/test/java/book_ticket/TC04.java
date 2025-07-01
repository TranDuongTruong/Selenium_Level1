package book_ticket;

import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import com.Railway.pages.BasePage;
import com.Railway.pages.LoginPage;
import io.qameta.allure.*;

@Epic("Book Ticket Function")
@Feature("InValid Access")
@Severity(SeverityLevel.CRITICAL)
public class TC04 extends TestBase {

    @Test(description = "Login page displays when un-logged User clicks on Book ticket tab")
    public void loginPageDisplaysWhenUnloggedUserClicksOnBookTicketTab(){
        LogUtils.info("TC4: Login page displays when un-logged User clicks on Book ticket tab");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Click on "Book ticket" tab

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Book ticket\" tab");


        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);
        LoginPage loginPage=new LoginPage();
        softAssert.assertTrue(loginPage.isPageDisplayed(Constants.PageHeading.LOGIN_HEADING_TEXT),"Check Login page exist");

    }


}
