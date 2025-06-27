package train_timetable;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.pages.BasePage;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.TrainTimetablePage;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("Book Ticket")
@Feature("Book ticket from train timetable page")
@Severity(SeverityLevel.CRITICAL)
public class TC15 extends TestBase {

    @Test(description = "User can open Book ticket page by clicking on Book ticket link in Train timetable page")
    public  void userCanOpenBookTicketPageFromTrainTimetablePage(){


//        1. Navigate to QA Railway Website
//        2. Login with a valid account
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginWithValidAccount(Constants.AccountInfo.USERNAME,Constants.AccountInfo.PASSWORD);

//        3. Click on "Timetable" tab
        BasePage.goToSpecificPage(Constants.TabName.TIMETABLE);
//        4. Click on "book ticket" link of the route from "Huế" to "Sài Gòn"
        TrainTimetablePage trainTimetablePage=new TrainTimetablePage();
        trainTimetablePage.clickBookTicketButton(Constants.TicketInfo.DEPART_FROM_TIMETABLE,Constants.TicketInfo.ARRIVE_AT_TIMETABLE);

        BookTicketPage bookTicketPage =new BookTicketPage();
        softAssert.assertTrue(bookTicketPage.isPageDisplayed(Constants.PageHeading.BOOK_TICKET_HEADING_TEXT));

        softAssert.assertEquals(bookTicketPage.getDepartFrom(),Constants.TicketInfo.DEPART_FROM_TIMETABLE);
        softAssert.assertEquals(bookTicketPage.getArriveAt(),Constants.TicketInfo.ARRIVE_AT_TIMETABLE);

    }

}
