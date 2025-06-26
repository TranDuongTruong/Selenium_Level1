package book_ticket;

import base.TestBase;
import com.Railway.constant.Constants;
import com.Railway.model.Ticket;
import com.Railway.pages.BasePage;
import com.Railway.pages.BookTicketPage;
import com.Railway.pages.LoginPage;
import com.Railway.pages.MyTicketPage;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14 extends TestBase {


    @Test
    public void  userCanBookOneTicketAtATime(){
//        1. Navigate to QA Railway Website
//        2. Login with a valid account
        BasePage.goToSpecificPage(Constants.TabName.LOGIN);
        LoginPage loginPage=new LoginPage();
        loginPage.loginWithValidAccount(Constants.AccountInfo.USERNAME,Constants.AccountInfo.PASSWORD);

//         get same ticket count in my ticket page
        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        MyTicketPage myTicketPage=new MyTicketPage();
        Ticket ticket=new Ticket(Constants.TicketInfo.DEPART_DATE,Constants.TicketInfo.DEPART_FROM,Constants.TicketInfo.ARRIVE_AT,Constants.TicketInfo.SEAT_TYPE,Constants.TicketInfo.TICKET_AMOUNT);

        int sameTicketCount=myTicketPage.getSameCountTicket(ticket);


//        3. Click on "Book ticket" tab
        BasePage.goToSpecificPage(Constants.TabName.BOOK_TICKET);

//        4. Select a "Depart date" from the list
//        5. Select "Sài Gòn" for "Depart from" and "Nha Trang" for "Arrive at".
//        6. Select "Soft bed with air conditioner" for "Seat type"
//        7. Select "1" for "Ticket amount"
//        8. Click on "Book ticket" button

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
        BasePage.goToSpecificPage(Constants.TabName.MY_TICKET);
        Assert.assertEquals(myTicketPage.getSameCountTicket(ticket),sameTicketCount+1);

    }

}
