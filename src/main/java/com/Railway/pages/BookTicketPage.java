package com.Railway.pages;

import com.Railway.dataObject.ArriveStation;
import com.Railway.dataObject.DepartStation;
import com.Railway.dataObject.SeatType;
import com.Railway.element.Element;
import com.Railway.model.Ticket;
import com.Railway.report.ExtentTestManager;
import com.Railway.untilities.Helpers;
import com.aventstack.extentreports.Status;
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


    public String getkBookTicketSuccessMessage()
    {
       return Element.getText(bookTicketSuccessMessageBy);
    }


    public void bookTicket(Ticket ticket){
        ExtentTestManager.logChildMessage(Status.INFO,"Ticket info: "+ticket.getTicketInfo());

        Element.selectItemInDropdown(departDateDropDownBy,ticket.getDepartDate());
        Element.selectItemInDropdown(departFromDropDownBy,ticket.getDepartFrom().getStation());
        Helpers.waitDropdownValue(arriveAtDropDownBy,5);
        Element.selectItemInDropdown(arriveAtDropDownBy,ticket.getArriveAt().getStation());
        Element.selectItemInDropdown(seatTypeDropDownBy,ticket.getSeatType().getSeatType());
        Element.selectItemInDropdown(ticketAmountDropDownBy,String.valueOf(ticket.getTicketAmount()));

        Helpers.scrollDown();
        Element.click(bookTicketButtonBy);

    }


    public Ticket getBookedTicketInfo(Ticket ticket) {
        Ticket bookedTicket = new Ticket();
        Class<?> ticketClass = ticket.getClass();
        Field[] fields = ticketClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object fieldValue = field.get(ticket);

                String fieldText;
                if (fieldValue instanceof DepartStation) {
                    fieldText = ((DepartStation) fieldValue).getStation();
                } else if (fieldValue instanceof ArriveStation) {
                    fieldText = ((ArriveStation) fieldValue).getStation();
                } else if (fieldValue instanceof SeatType) {
                    fieldText = ((SeatType) fieldValue).getSeatType();
                } else {
                    fieldText = String.valueOf(fieldValue); // với String và int
                }
                String data = Element.getText(By.xpath(String.format(bookedTicketFieldXpath, fieldText)));
                Class<?> fieldType = field.getType();
                if (fieldType == int.class) {
                    field.set(bookedTicket, Integer.parseInt(data));
                } else if (fieldType == DepartStation.class) {
                    field.set(bookedTicket, DepartStation.getStation(data));
                } else if (fieldType == ArriveStation.class) {
                    field.set(bookedTicket,  ArriveStation.getStation(data));
                } else if (fieldType == SeatType.class) {
                    field.set(bookedTicket, SeatType.getSeatType(data));
                } else {
                    field.set(bookedTicket, data);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bookedTicket;
    }


    public String getDepartFrom(){
        Select select = new Select(Element.getElement(departFromDropDownBy));
        return select.getFirstSelectedOption().getText();
    }
    public String getArriveAt(){
        Select select = new Select(Element.getElement(arriveAtDropDownBy));
        return select.getFirstSelectedOption().getText();
    }





}
