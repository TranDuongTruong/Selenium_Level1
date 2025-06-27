package com.Railway.report;

import com.Railway.driver.DriverManager;
import com.Railway.log.LogUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
//    extentTestMap lưu giữ thông tin của id luồng và các cá thể ExtentTest.
//    Phiên bản ExtentReports được tạo bằng cách gọi phương thức createExtentReports () từ ExtentManager.
//    Tại phương thức saveToReport(), một phiên bản của ExtentTest đã được tạo và đưa vào extentTestMap với id luồng hiện tại.
//    Tại phương thức getTest(), trả về cá thể ExtentTest trong scopeTestMap bằng cách sử dụng id luồng hiện tại.

    private static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    private static ExtentReports extent = ExtentManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest saveToReport(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
    public static void logMessage(String message) {

        getTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        switch (status) {
            case FAIL: LogUtils.error(message);
            case PASS: LogUtils.info(message);
            case SKIP: LogUtils.warn(message);
            default: LogUtils.info(message);
        }
        getTest().log(status, message);
    }
    public static void addScreenShot(String message) {
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) DriverManager.get_driver()).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.INFO, message,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }

    public static void addScreenShot(Status status, String message) {

        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) DriverManager.get_driver()).getScreenshotAs(OutputType.BASE64);
        getTest().log(status, message,MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }
}
