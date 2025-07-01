package com.Railway.pages;

import com.Railway.element.Element;
import com.Railway.log.LogUtils;
import com.Railway.report.ExtentTestManager;
import com.Railway.untilities.Helpers;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;

public class TrainTimetablePage extends  BasePage{

    private final String bookTicketXpath="//tr[td[2][text()='%s'] and td[3][text()='%s']]//a[text()='book ticket']";

    public void clickBookTicketButton(String departStation,String arriveStation){
        ExtentTestManager.logChildMessage(Status.INFO,"Depart station: "+departStation+"\tArrive station: "+arriveStation);
        Helpers.scrollDown();
        Element.click(By.xpath(String.format(bookTicketXpath,departStation,arriveStation)));
    }

}
