package com.Railway.pages;

import org.openqa.selenium.By;

public class HomePage extends  BasePage {

    private static final By welcomeTextBy =By.xpath("//div/strong[contains(text(), 'Welcome')]");


    public  String getWelcomeText(){
       // DriverManager.get_driver().manage().window().setSize(new Dimension(1280, 800));
        return getElement(welcomeTextBy).getText();

    }

}
