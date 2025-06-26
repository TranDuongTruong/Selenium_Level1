package com.Railway.untilities;

import com.Railway.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helpers {
    public static void waitElementToBeClickable(By elementBy, int duration){
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    public static void waitDropdownValue(By dropdownBy, String expectedText, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(timeoutInSeconds));
        try {
            wait.until(driver -> {
                Select select = new Select(driver.findElement(dropdownBy));
                String selectedText = select.getFirstSelectedOption().getText();
                return selectedText.equals(expectedText);
            });
        } catch (TimeoutException e) {
        }
    }


    public static void waitPage(int duration){
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(duration));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
    public static String[] splitString(String str, String delimiter) {
        if (str == null) return new String[]{};
        return str.split(delimiter);
    }
    public  static  void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.get_driver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    public static void scrollToElement(WebElement element) {
        new Actions(DriverManager.get_driver())
                .scrollByAmount(0, element.getRect().y)
                .perform();
    }

}
