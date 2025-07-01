package my_ticket;

import com.Railway.dataObject.ArriveStation;
import com.Railway.dataObject.DepartStation;
import com.Railway.dataObject.SeatType;
import com.Railway.log.LogUtils;
import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.data.TicketJsonReader;
import com.Railway.model.Ticket;
import com.Railway.pages.BasePage;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.MyTicketPage;
import com.Railway.report.ExtentTestManager;
import com.aventstack.extentreports.Status;
import data.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;


import io.qameta.allure.*;

import java.util.Map;

@Epic("My Tịcket Function")
@Feature("Cancel Ticket")
@Severity(SeverityLevel.CRITICAL)
public class TC16 extends TestBase {

    @Test(description = "User can cancel a ticket"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestData.class)
    public  void userCanCancelTicket(Map<String, Object> data){

        LogUtils.info("TC16: User can cancel a ticket");

//        Step 1:Navigate to QA Railway Website
//        Step 2:Login with a valid account

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Login with a valid account");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginSuccess();

//        Step 3:Book a ticket
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Book a ticket");


        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);
        Ticket ticket= new Ticket(data.get(Constants.DataProviderKey.TICKET_DEPART_DATE_KEY).toString()
                        , DepartStation.getStation(data.get(Constants.DataProviderKey.TICKET_DEPART_STATION_KEY).toString())
                        , ArriveStation.getStation(data.get(Constants.DataProviderKey.TICKET_ARRIVE_STATION_KEY).toString())
                        , SeatType.getSeatType(data.get(Constants.DataProviderKey.TICKET_SEAT_TYPE_KEY).toString())
                        ,Integer.parseInt(data.get(Constants.DataProviderKey.TICKET_AMOUNT_KEY).toString()));

        BookTicketPage bookTicketPage =new BookTicketPage();
        bookTicketPage.bookTicket(ticket);

//        Step 4:Click on "My ticket" tab
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Click on \"My ticket\" tab");


        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);

//        Step 5:Click on "Cancel" button of ticket which user want to cancel.
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 5:Click on \"Cancel\" button of ticket which user want to cancel.");


        MyTicketPage myTicketPage=new MyTicketPage();
        int sameTicketCount= myTicketPage.getSameCountTicket(ticket);
        myTicketPage.cancelTicket(ticket);

//        Step 6:Click on "OK" button on Confirmation message "Are you sure?"
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 6:Click on \"OK\" button on Confirmation message \"Are you sure?\"");


        myTicketPage.clickPopup();
        Assert.assertEquals(myTicketPage.getSameCountTicket(ticket),sameTicketCount-1);
    }



}
