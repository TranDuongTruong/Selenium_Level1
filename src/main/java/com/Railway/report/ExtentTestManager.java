package com.Railway.report;

import com.Railway.driver.DriverManager;
import com.Railway.log.LogUtils;
import com.aventstack.extentreports.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static final Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    private static final Map<Integer, ExtentTest> childTestMap = new HashMap<>();
    private static final ExtentReports extent = ExtentManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest saveToReport(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }


    public static void logMessageWithStep(Status status, String stepTitle) {
        logToLog4j(status, stepTitle);
        ExtentTest child = getTest().createNode(stepTitle);
        child.log(status, stepTitle); // log ngay vào node
        childTestMap.put((int) Thread.currentThread().getId(), child);
    }


    public static void logChildMessage(Status status, String message) {
        logToLog4j(status, message);
        ExtentTest child = childTestMap.get((int) Thread.currentThread().getId());
        if (child != null) {
            child.log(status, message);
        } else {
            getTest().log(Status.WARNING, "⛔ Missing child node: " + message);
        }
    }


    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        logToLog4j(status, message);
        getTest().log(status, message);
    }


    private static void logToLog4j(Status status, String message) {
        switch (status) {
            case FAIL : LogUtils.error(message);
            case PASS : LogUtils.info(message);
            case SKIP : LogUtils.warn(message);
            case INFO : LogUtils.info(message);
            default : LogUtils.info(message);
        }
    }

    public static void addScreenShot(String message) {
        String base64Image = captureScreenshot();
        getTest().log(Status.INFO, message,
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
    }
    public static void addScreenShot(Status status, String message) {
        String base64Image = captureScreenshot();

        ExtentTest child = childTestMap.get((int) Thread.currentThread().getId());
         child.log(status, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());

    }



    public static void addChildScreenshot(Status status, String message) {
        String base64Image = captureScreenshot();
        ExtentTest child = childTestMap.get((int) Thread.currentThread().getId());
        if (child != null) {
            child.log(status, message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        } else {
            getTest().log(status, "⚠ Screenshot fallback - no child step",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        }
    }


    private static String captureScreenshot() {
        return "data:image/png;base64," +
                ((TakesScreenshot) DriverManager.get_driver()).getScreenshotAs(OutputType.BASE64);
    }
}
