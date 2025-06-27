package base;

import com.Railway.driver.DriverManager;
import com.Railway.untilities.ScreenshotHelper;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ScreenshotHelper.captureScreenshot(testName);
    }

}