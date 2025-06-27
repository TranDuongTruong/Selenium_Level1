package my_ticket;

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

@Epic("My Tịcket Function")
@Feature("Cancel Ticket")
@Severity(SeverityLevel.CRITICAL)
public class TC16 extends TestBase {

    @Test(description = "User can cancel a ticket")
    public  void userCanCancelTicket(){

        LogUtils.info("TC16: User can cancel a ticket");

//        Step 1:Navigate to QA Railway Website
//        Step 2:Login with a valid account

        ExtentTestManager.logMessage(Status.INFO,"Step 1:Navigate to QA Railway Website");
        ExtentTestManager.logMessage(Status.INFO,"Step 2:Login with a valid account");


        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginSuccess();

//        Step 3:Book a ticket
        ExtentTestManager.logMessage(Status.INFO,"Step 3:Book a ticket");


        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);
        Ticket ticket= TicketJsonReader.getRandomTicket();
        BookTicketPage bookTicketPage =new BookTicketPage();
        bookTicketPage.bookTicket(ticket);

//        Step 4:Click on "My ticket" tab
        ExtentTestManager.logMessage(Status.INFO,"Step 4:Click on \"My ticket\" tab");


        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);

//        Step 5:Click on "Cancel" button of ticket which user want to cancel.
        ExtentTestManager.logMessage(Status.INFO,"Step 5:Click on \"Cancel\" button of ticket which user want to cancel.");


        MyTicketPage myTicketPage=new MyTicketPage();
        int sameTicketCount= myTicketPage.getSameCountTicket(ticket);
        myTicketPage.cancelTicket(ticket);

//        Step 6:Click on "OK" button on Confirmation message "Are you sure?"
        ExtentTestManager.logMessage(Status.INFO,"Step 6:Click on \"OK\" button on Confirmation message \"Are you sure?\"");


        myTicketPage.clickPopup();
        Assert.assertEquals(myTicketPage.getSameCountTicket(ticket),sameTicketCount-1);
    }



}
