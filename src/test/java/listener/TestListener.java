package listener;

import com.Railway.driver.DriverManager;
import com.Railway.log.LogUtils;
import com.Railway.report.ExtentManager;
import com.Railway.report.ExtentTestManager;
import com.Railway.untilities.ScreenshotHelper;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult iTestResult) {

        ScreenshotHelper.saveScreenshotToFile(getTestName(iTestResult));
        Throwable error = iTestResult.getThrowable();
        LogUtils.error("Test FAILED: "+getTestName(iTestResult));
        LogUtils.error(error.getMessage());

        LogUtils.error(getTestName(iTestResult) + " test is failed.");
        ExtentTestManager.addScreenShot(Status.FAIL, getTestName(iTestResult));
       ExtentTestManager.logMessageWithStep(Status.FAIL, iTestResult.getThrowable().toString());
        ExtentTestManager.logMessageWithStep(Status.FAIL, iTestResult.getName() + " is failed.");

    }

    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName()
                : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        DriverManager.createDriver();
        LogUtils.info("Start testing " + iTestContext.getName());
        WebDriver driver=DriverManager.get_driver();
        iTestContext.setAttribute("WebDriver", driver);

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LogUtils.info("End testing " + iTestContext.getName());
        ExtentManager.getExtentReports().flush();
        DriverManager.quitDriver();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtils.info(getTestName(iTestResult) + " test is starting...");
        ExtentTestManager.saveToReport(iTestResult.getName(), iTestResult.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LogUtils.info(getTestName(iTestResult) + " test is passed.");
        ExtentTestManager.logMessageWithStep(Status.PASS, getTestDescription(iTestResult));
    }


    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LogUtils.warn(getTestName(iTestResult) + " test is skipped.");
        ExtentTestManager.logMessageWithStep(Status.SKIP, getTestName(iTestResult) + " test is skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LogUtils.error("Test failed but it is in defined success ratio " + getTestName(iTestResult));
        ExtentTestManager.logMessageWithStep(Status.INFO,"Test failed but it is in defined success ratio " + getTestName(iTestResult));
    }



}