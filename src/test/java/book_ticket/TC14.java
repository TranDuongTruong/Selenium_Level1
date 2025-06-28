package book_ticket;

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

@Epic("Book Ticket Function")
@Feature("Valid Book Ticket")
@Severity(SeverityLevel.CRITICAL)
public class TC14 extends TestBase {


    @Test(description = "User can book 1 ticket at a time")
    public void  userCanBookOneTicketAtATime(){
        LogUtils.info("TC14: User can book 1 ticket at a time");
//        Step 1:Navigate to QA Railway Website
//        Step 2:Login with a valid account

        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO,"Step 2:Click on \"Login\" tab");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginSuccess();

//        2.Step 1:get same ticket count in my ticket page
        ExtentTestManager.logMessage(Status.INFO,"2.Step 1:get same ticket count in my ticket page");


        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        MyTicketPage myTicketPage=new MyTicketPage();
        Ticket ticket= TicketJsonReader.getRandomTicket();

        int sameTicketCount=myTicketPage.getSameCountTicket(ticket);


//        Step 3:Click on "Book ticket" tab
        ExtentTestManager.logMessage(Status.INFO,"Step 3:Click on \"Book ticket\" tab");


        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);

//        Step 4:Select a "Depart date" from the list
//        Step 5:Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
//        Step 6:Select "Soft bed with air conditioner" for "Seat type"
//        Step 7:Select "1" for "Ticket amount"
//        Step 8:Click on "Book ticket" button

        ExtentTestManager.logMessage(Status.INFO,"Step 4:Select a \"Depart date\" from the list");
        ExtentTestManager.logMessage(Status.INFO,"Step 5:Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        ExtentTestManager.logMessage(Status.INFO,"Step 6:Select \"Soft bed with air conditioner\" for \"Seat type\"");
        ExtentTestManager.logMessage(Status.INFO,"Step 7:Select \"1\" for \"Ticket amount\"");
        ExtentTestManager.logMessage(Status.INFO,"Step 8:Click on \"Book ticket\" button");



        BookTicketPage bookTicketPage =new BookTicketPage();
        bookTicketPage.bookTicket(ticket);

        Assert.assertEquals(bookTicketPage.getkBookTicketSuccessMessage(),Constants.Message.BOOK_TICKET_SUCCESS_MESSAGE);

        Ticket actualTicket=bookTicketPage.getBookedTicketInfo(ticket);
        Assert.assertEquals(actualTicket.getArriveAt(),ticket.getArriveAt());
        Assert.assertEquals(actualTicket.getDepartDate(),ticket.getDepartDate());
        Assert.assertEquals(actualTicket.getDepartFrom(),ticket.getDepartFrom());
        Assert.assertEquals(actualTicket.getTicketAmount(),ticket.getTicketAmount());
        Assert.assertEquals(actualTicket.getSeatType(),ticket.getSeatType());

        // check ticket in my ticket page
        ExtentTestManager.logMessage(Status.INFO," Check ticket in my ticket page");


        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        Assert.assertEquals(myTicketPage.getSameCountTicket(ticket),sameTicketCount+1);

    }

}
