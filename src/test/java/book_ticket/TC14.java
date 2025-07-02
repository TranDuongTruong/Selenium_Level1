package book_ticket;

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

import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.*;

import java.util.Map;

@Epic("Book Ticket Function")
@Feature("Valid Book Ticket")
@Severity(SeverityLevel.CRITICAL)
public class TC14 extends TestBase {


    @Test(description = "User can book 1 ticket at a time"
            ,dataProvider = "jsonDataProvider", dataProviderClass = TestBase.class)
    public void  userCanBookOneTicketAtATime(Map<String, Object> data){
        LogUtils.info("TC14: User can book 1 ticket at a time");

//        Step 1:Navigate to QA Railway Website
//        Step 2:Login with a valid account

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 2:Click on \"Login\" tab");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginSuccess();

//        2.Step 1:get same ticket count in my ticket page
        ExtentTestManager.logMessageWithStep(Status.INFO,"2.Step 1:get same ticket count in my ticket page");


        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        MyTicketPage myTicketPage=new MyTicketPage();

        Ticket ticket= new Ticket(data.get(Constants.DataProviderKey.TICKET_DEPART_DATE_KEY).toString()
                , DepartStation.getStation(data.get(Constants.DataProviderKey.TICKET_DEPART_STATION_KEY).toString())
                , ArriveStation.getStation(data.get(Constants.DataProviderKey.TICKET_ARRIVE_STATION_KEY).toString())
                , SeatType.getSeatType(data.get(Constants.DataProviderKey.TICKET_SEAT_TYPE_KEY).toString())
                ,Integer.parseInt(data.get(Constants.DataProviderKey.TICKET_AMOUNT_KEY).toString()));


        int sameTicketCount=myTicketPage.getSameCountTicket(ticket);


//        Step 3:Click on "Book ticket" tab
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 3:Click on \"Book ticket\" tab");


        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);

//        Step 4:Select a "Depart date" from the list
//        Step 5:Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
//        Step 6:Select "Soft bed with air conditioner" for "Seat type"
//        Step 7:Select "1" for "Ticket amount"
//        Step 8:Click on "Book ticket" button

        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 4:Select a \"Depart date\" from the list");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 5:Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 6:Select \"Soft bed with air conditioner\" for \"Seat type\"");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 7:Select \"1\" for \"Ticket amount\"");
        ExtentTestManager.logMessageWithStep(Status.INFO,"Step 8:Click on \"Book ticket\" button");



        BookTicketPage bookTicketPage =new BookTicketPage();
        bookTicketPage.bookTicket(ticket);

        Assert.assertEquals(bookTicketPage.getkBookTicketSuccessMessage(),Constants.Message.BOOK_TICKET_SUCCESS_MESSAGE);

        Ticket actualTicket=bookTicketPage.getBookedTicketInfo(ticket);

        Assert.assertEquals(actualTicket.getArriveAt().getStation(),ticket.getArriveAt().getStation());
        Assert.assertEquals(actualTicket.getDepartDate(),ticket.getDepartDate());
        Assert.assertEquals(actualTicket.getDepartFrom().getStation(),ticket.getDepartFrom().getStation());
        Assert.assertEquals(actualTicket.getTicketAmount(),ticket.getTicketAmount());
        Assert.assertEquals(actualTicket.getSeatType().getSeatType(),ticket.getSeatType().getSeatType());

        // check ticket in my ticket page
        ExtentTestManager.logMessageWithStep(Status.INFO," Check ticket in my ticket page");


        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        Assert.assertEquals(myTicketPage.getSameCountTicket(ticket),sameTicketCount+1);

        //post-condition steps: clean data
        int sameTicketCount2= myTicketPage.getSameCountTicket(ticket);
        myTicketPage.cancelTicket(ticket);
        myTicketPage.clickPopup();
        Assert.assertEquals(myTicketPage.getSameCountTicket(ticket),sameTicketCount2-1);

    }

}
