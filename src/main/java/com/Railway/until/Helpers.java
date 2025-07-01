package com.Railway.until;

import com.Railway.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Helpers {
    public static void waitElementToBeClickable(By elementBy, int duration){
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public static void waitDropdownValue(By dropdownBy, int timeoutInSeconds) {

        fluentWait(dropdownBy);

        String currentId=((RemoteWebElement) DriverManager.get_driver().findElement(dropdownBy)).getId();
        WebDriverWait wait = new WebDriverWait(DriverManager.get_driver(), Duration.ofSeconds(timeoutInSeconds));

        try {
            wait.until(driver -> {
                String newId=((RemoteWebElement) DriverManager.get_driver().findElement(dropdownBy)).getId();
             /*   LogUtils.debug("newId"+newId);*/
                return !newId.equals(currentId);
            });
        } catch (TimeoutException e) {
            System.out.println("Drop down do not change");
        }
    }
    public static void fluentWait(By by) {
        FluentWait<WebDriver> wait = new FluentWait<>(DriverManager.get_driver())
                .withTimeout(Duration.ofSeconds(5))          // tổng thời gian chờ
                .pollingEvery(Duration.ofMillis(500))         // tần suất kiểm tra lại
                .ignoring(NoSuchElementException.class)       // bỏ qua nếu chưa thấy phần tử
                .ignoring(StaleElementReferenceException.class);
        try {
            wait.until(d -> {
                WebElement element = d.findElement(by);
                return (element.isDisplayed()) ? element : null;
            });
        } catch (TimeoutException e){
            System.out.println("No such elements during 5s");
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
    public static String getTimestamp(){
        return   new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

    }

}
