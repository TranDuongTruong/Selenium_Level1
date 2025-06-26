package com.Railway.pages;

import com.Railway.untilities.Helpers;
import org.openqa.selenium.By;

public class TrainTimetablePage extends  BasePage{

    private final String bookTicketXpath="//tr[td[2][text()='%s'] and td[3][text()='%s']]//a[text()='book ticket']";

    public void clickBookTicketButton(String departStation,String arriveStation){
        Helpers.scrollDown();
        getElement(By.xpath(String.format(bookTicketXpath,departStation,arriveStation))).click();
    }

}
