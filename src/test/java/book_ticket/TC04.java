package book_ticket;

import base.TestBase;
import com.Railway.constant.Constants;
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

//        2. Click on "Book ticket" tab
        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);
        LoginPage loginPage=new LoginPage();
        softAssert.assertTrue(loginPage.isPageDisplayed(Constants.PageHeading.LOGIN_HEADING_TEXT),"Check Login page exist");

    }


}
