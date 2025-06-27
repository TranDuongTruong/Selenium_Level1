package com.Railway.driver;

import io.opentelemetry.sdk.metrics.internal.state.ObjectPool;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;

import java.time.Duration;

public class DriverManager {
    private static ThreadLocal<WebDriver> _driver = new ThreadLocal<>();

    public static void createDriver(){
        if(_driver.get()==null){
            ChromiumNetworkConditions networkConditions = new ChromiumNetworkConditions();
            networkConditions.setOffline(false);
            networkConditions.setLatency(Duration.ofMillis(20)); // 20 ms of latency
            networkConditions.setDownloadThroughput(1000 * 1024 / 8); // 2000 kbps
            networkConditions.setUploadThroughput(1000 * 1024 / 8);   // 2000 kbps

            ChromeOptions options=new ChromeOptions();
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-web-security");

            //options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            WebDriver driver = new ChromeDriver(options);
            //((ChromiumDriver) driver).setNetworkConditions(networkConditions);
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
