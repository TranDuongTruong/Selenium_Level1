package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class HomePage {

    private static final By welcomeText=By.xpath("//div/strong[contains(text(), 'Welcome')]");

    private static WebElement getWelcomeText(){
        return DriverManager.get_driver().findElement(welcomeText);
    }

    public static Boolean checkWelcomeText(String username){
       // DriverManager.get_driver().manage().window().setSize(new Dimension(1280, 800));
        if(getWelcomeText().getText().equals("Welcome "+username)) return true;
        return false;

    }

}
