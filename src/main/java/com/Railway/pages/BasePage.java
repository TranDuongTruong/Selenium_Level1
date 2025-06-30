package com.Railway.pages;

import com.Railway.driver.DriverManager;
import com.Railway.element.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    @Step("Go to specific page")
    public  static  void goToSpecificPage(String pageName){
        DriverManager.get_driver().findElement(By.linkText(pageName)).click();

    }
    public  static Boolean isMenuItemIsExist(String itemName){
        return !DriverManager.get_driver().findElements(By.linkText(itemName)).isEmpty();
    }


    private final By headingPageTextBy =By.xpath("//h1[@align='center']");
    private final By headingFormTextBy =By.xpath("//legend");
    protected String expectedTitletxt;

    private WebElement getHeadingTextBy(){
        return DriverManager.get_driver().findElement(this.headingPageTextBy);
    }

    public Boolean isPageDisplayed(String headingText){
        return getHeadingTextBy().getText().equals(headingText);
    }
    public String getHeadingForm(){
        return Element.getElement(headingFormTextBy).getText();
    }




    public void clickPopup() {
        Alert alert = DriverManager.get_driver().switchTo().alert();
        alert.accept();
    }



}
