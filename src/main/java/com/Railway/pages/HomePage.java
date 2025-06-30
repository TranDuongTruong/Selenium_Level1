package com.Railway.pages;

import com.Railway.element.Element;
import org.openqa.selenium.By;

public class HomePage extends  BasePage {

    private static final By welcomeTextBy =By.xpath("//div/strong[contains(text(), 'Welcome')]");


    public  String getWelcomeText(){
        return Element.getText(welcomeTextBy);

    }

}
