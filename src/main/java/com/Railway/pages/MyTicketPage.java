package com.Railway.pages;

import com.Railway.driver.DriverManager;
import com.Railway.log.LogUtils;
import com.Railway.model.Ticket;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyTicketPage extends BasePage {


    //arrive at - depart from -arrive at-seat type - arrive at -depart date
    String ticketRowXpath="//tr[td[text()='%s']/preceding-sibling::td[text()='%s']   and  td[text()='%s']/following-sibling::td[text()='%s']    and  td[text()='%s']/following-sibling::td[text()='%s']] ";
    String cancelTicketButtomXpath=ticketRowXpath+"//input";

    //tr[td[text()='Nha Trang']/preceding-sibling::td[text()='Sài Gòn']   and  td[text()='Nha Trang']/following-sibling::td[text()='Soft bed with air conditioner']    and  td[text()='Nha Trang']/following-sibling::td[text()='6/28/2025']]//input


    public int getSameCountTicket( Ticket ticket){
        List<WebElement> tickets=getElements(By.xpath(String.format(ticketRowXpath,ticket.getArriveAt(),
                ticket.getDepartFrom(),ticket.getArriveAt(),ticket.getSeatType(),ticket.getArriveAt(),ticket.getDepartDate())));

        if(!tickets.isEmpty()) return tickets.size();
        return 0;
    }

    public void cancelTicket(Ticket ticket){
        LogUtils.info("Ticker info: "+ticket.getTicketInfo());
        getElement(By.xpath(String.format(cancelTicketButtomXpath,ticket.getArriveAt(),ticket.getDepartFrom(),ticket.getArriveAt(),ticket.getSeatType(),ticket.getArriveAt(),ticket.getDepartDate()))).click();
    }




}
