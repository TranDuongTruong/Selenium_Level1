package com.Railway.element;

import com.Railway.driver.DriverManager;
import com.Railway.until.Helpers;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Element {

    public static WebElement getElement(By by){
        return DriverManager.get_driver().findElement(by);
    }
    public static List<WebElement> getElements(By by){
        return DriverManager.get_driver().findElements(by);
    }
    public static void click(By by) {
        Helpers.fluentWait(by);
        Element.scrollToElement(by);
        getElement(by).click();
    }
    public static void clickEmail(By by) {
        Helpers.fluentWait(by);
        getElement(by).click();
    }
    public static void clear(By by) {
        Helpers.fluentWait(by);


        getElement(by).clear();
    }



    public static void sendKeys(By by,String text) {
        Helpers.fluentWait(by);

        WebElement element = getElement(by);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By by) {
        Helpers.fluentWait(by);

        return getElement(by).getText();
    }

    public static boolean isDisplayed(By by) {
        Helpers.fluentWait(by);

        try {
            return getElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static String getAttribute(By by,String attr) {
        return getElement( by).getAttribute(attr);
    }
    public static  void selectItemInDropdown(By dropdownBy, String value){
        Select select = new Select(getElement(dropdownBy));
        select.selectByVisibleText(value);
    }
    public static void acceptPopup() {
        try {
            Alert alert = DriverManager.get_driver().switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            Actions actions = new Actions(DriverManager.get_driver());
            actions.sendKeys(Keys.ENTER).perform();
        }
    }
    public static void scrollToElement(By by) {
        Helpers.fluentWait(by);

        new Actions(DriverManager.get_driver())
                .scrollByAmount(0, getElement(by).getRect().y)
                .perform();
    }




}
