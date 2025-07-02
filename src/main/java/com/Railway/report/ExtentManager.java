package com.Railway.report;

import com.Railway.until.Helpers;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {
    private static ExtentReports extentReports;
    private static ExtentSparkReporter reporter;

    public synchronized static ExtentReports getExtentReports() {//synchronized: dùng chung khi  nhiều thread gọi getExtentReports() cùng lúc khi run nhiều case cùng lúc
        if (extentReports == null) {
            extentReports = new ExtentReports();

            String reportPath = "./ExtentReports/ExtentReport_" + Helpers.getTimestamp() + ".html";
            reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Railway Report");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Framework Name", "Selenium Java Framework | Truong");
            extentReports.setSystemInfo("Author", "Truong");
        }

        return extentReports;
    }
}
