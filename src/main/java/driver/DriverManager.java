package driver;

import io.opentelemetry.sdk.metrics.internal.state.ObjectPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static WebDriver _driver;

    public static void createDriver(){
        if(_driver==null){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-web-security");
            _driver =new ChromeDriver(options);
            _driver.manage().window().maximize();
        }
    }

    public static void quitDriver(){
        _driver.quit();
        _driver=null;

    }
    public static WebDriver get_driver()
    {
        return _driver;
    }
}
