package com.Railway.driver;

import io.opentelemetry.sdk.metrics.internal.state.ObjectPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
    private static ThreadLocal<WebDriver> _driver = new ThreadLocal<>();

    public static void createDriver(){
        if(_driver.get()==null){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-web-security");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            _driver.set(driver);
        }
    }

    public static void quitDriver(){
        if (_driver.get() != null) {
            _driver.get().quit();
            _driver.remove();
        }

    }
    public static WebDriver get_driver()
    {
        return _driver.get();
    }
}
