package addition_exe;

import com.Railway.driver.DriverManager;
import com.Railway.element.Element;
import com.Railway.until.Helpers;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class test1 {
    @Test
    public  void  test(){
        DriverManager.createDriver();
        DriverManager.get_driver().get("https://www.selenium.dev/selenium/web/dynamic.html");
        Element.click(By.xpath("//input[@id='reveal']"));
        Helpers.fluentWait(By.xpath("//input[@id='revealed']"));
        Element.sendKeys(By.xpath("//input[@id='revealed']"),"ACCC");
        DriverManager.quitDriver();
    }
    @Test
    public  void  test12(){
        DriverManager.createDriver();
        DriverManager.get_driver().get("https://www.selenium.dev/selenium/web/dynamic.html");
        Element.click(By.xpath("//input[@id='reveal']"));
        Helpers.fluentWait(By.xpath("//input[@id='revealed']"));
        Element.sendKeys(By.xpath("//input[@id='revealed']"),"ACCC");
        DriverManager.quitDriver();
    }
    @Test
    public  void  test13(){
        DriverManager.createDriver();
        DriverManager.get_driver().get("https://www.selenium.dev/selenium/web/dynamic.html");
        Element.click(By.xpath("//input[@id='reveal']"));
        Helpers.fluentWait(By.xpath("//input[@id='revealed']"));
        Element.sendKeys(By.xpath("//input[@id='revealed']"),"ACCC");
        DriverManager.quitDriver();
    }
    @Test
    public  void  test14(){
        DriverManager.createDriver();
        DriverManager.get_driver().get("https://www.selenium.dev/selenium/web/dynamic.html");
        Element.click(By.xpath("//input[@id='reveal']"));
        Helpers.fluentWait(By.xpath("//input[@id='revealed']"));
        Element.sendKeys(By.xpath("//input[@id='revealed']"),"ACCC");
        DriverManager.quitDriver();
    }
}
