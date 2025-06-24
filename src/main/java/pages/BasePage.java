package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {



    public  static  void goToSpecificPage(String pageName){
        DriverManager.get_driver().findElement(By.linkText(pageName)).click();

    }
    public  static Boolean itemIsExist(String itemName){
        return !DriverManager.get_driver().findElements(By.linkText(itemName)).isEmpty();
    }
    public  static  void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.get_driver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }



    private final By titleTxt=By.xpath("//h1[@align='center']");
    protected String expectedTitletxt;

    private WebElement getTitleTxt(){
        return DriverManager.get_driver().findElement(this.titleTxt);
    }

    public Boolean pageIsExist(){
        return getTitleTxt().getText().equals(expectedTitletxt);
    }

    public BasePage(String expectedTitleTxt) {
        this.expectedTitletxt = expectedTitleTxt;
    }
    protected WebElement getElement(By by){
        return DriverManager.get_driver().findElement(by);
    }




}
