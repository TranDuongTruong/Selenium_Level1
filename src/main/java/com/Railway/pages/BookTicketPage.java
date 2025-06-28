package com.Railway.pages;

import com.Railway.log.LogUtils;
import com.Railway.model.Ticket;
import com.Railway.untilities.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Field;

public class BookTicketPage extends BasePage  {
    private final By departDateDropDownBy =By.xpath("//select[@name='Date']");
    private final By departFromDropDownBy =By.xpath("//select[@name='DepartStation']");
    private final By arriveAtDropDownBy =By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeDropDownBy =By.xpath("//select[@name='SeatType']");
    private final By ticketAmountDropDownBy =By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButtonBy =By.xpath("//input[@type='submit']");
    private final By bookTicketSuccessMessageBy =By.xpath("//h1[@align='center']");
    private final String bookedTicketFieldXpath="//tr//td[text()='%s']";

    public  void selectItemInDropdown(By dropdownBy, String value){
        Select select = new Select(getElement(dropdownBy));
        select.selectByVisibleText(value);
    }
    public String getkBookTicketSuccessMessage()
    {
       return getElement(bookTicketSuccessMessageBy).getText();
    }


    public void bookTicket(Ticket ticket){
        LogUtils.info("Ticket info: "+ticket.getTicketInfo());

        selectItemInDropdown(departDateDropDownBy,ticket.getDepartDate());
        selectItemInDropdown(departFromDropDownBy,ticket.getDepartFrom());
        Helpers.waitDropdownValue(arriveAtDropDownBy,"",3);
        selectItemInDropdown(arriveAtDropDownBy,ticket.getArriveAt());
        selectItemInDropdown(seatTypeDropDownBy,ticket.getSeatType());
        selectItemInDropdown(ticketAmountDropDownBy,String.valueOf(ticket.getTicketAmount()));

        Helpers.scrollDown();
        getElement(bookTicketButtonBy).click();

    }


    public Ticket getBookedTicketInfo(Ticket ticket){
        Ticket bookedTicket=new Ticket();
        Class<?>  ticketClass = ticket.getClass();
        Field[] fields = ticketClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); //  truy cập vào các biến private
            try {
                String fieldName=field.get(ticket).toString();
                String data=getElement(By.xpath(String.format(bookedTicketFieldXpath,fieldName))).getText();
                if (field.getType() == int.class) {
                    field.set(bookedTicket, Integer.parseInt(data));
                } else {
                    field.set(bookedTicket, data);
                }
            } catch (IllegalAccessException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return  bookedTicket;

    }

    public String getDepartFrom(){
        Select select = new Select(getElement(departFromDropDownBy));
        return select.getFirstSelectedOption().getText();
    }
    public String getArriveAt(){
        Select select = new Select(getElement(arriveAtDropDownBy));
        return select.getFirstSelectedOption().getText();    }





}
