package com.Railway.untilities;

import com.Railway.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotHelper {
    @Attachment(value = "Screenshot on Failure", type = "image/png")
    public static byte[] attachScreenshotToAllure() {
        return ((TakesScreenshot) DriverManager.get_driver()).getScreenshotAs(OutputType.BYTES);
    }
    public static void saveScreenshotToFile (String testName) {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.get_driver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        String screenshotDir = "target/screenshots";
        String screenshotPath = screenshotDir + "/" + testName + "_" +  Helpers.getTimestamp() + ".png";

        try {
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs(); // tạo cả thư mục cha nếu cần
            }

            FileHandler.copy(source, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
    public static void captureScreenshot(String testName) {
        saveScreenshotToFile(testName);
        attachScreenshotToAllure();
    }
}
