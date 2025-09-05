package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListeners implements ITestListener {
	private static ExtentReports extent = ExtentManager.getReporter();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		// When test method starts
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		System.out.println(result.getMethod().getMethodName() + " started!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
		System.out.println(result.getMethod().getMethodName() + " passed!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
		System.out.println(result.getMethod().getMethodName() + " failed!");
		
		String screenshotPath =ScreenshotUtil.takeScreenshot(utils.DriverFactory.getDriver(), result.getMethod().getMethodName());
		
		test.get().addScreenCaptureFromPath(screenshotPath);
	}

	@Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
        System.out.println(result.getMethod().getMethodName() + " skipped!");
	
	}
	@Override
        public void onFinish(ITestContext context) {
            extent.flush();
        }

}

