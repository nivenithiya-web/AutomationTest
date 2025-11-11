package Frameworklearning.Testcomponents;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import FrameworkLearning.Abstarctcomponents.ExtentReportsNG;

public class Listerners extends BaseTest implements ITestListener {

    ExtentReports extent = ExtentReportsNG.getExtendReports();
    ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
    	
        System.out.println("Starting test: " + result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	Reporter.log("inside fail");
        extentTest.get().fail(result.getThrowable());

        WebDriver driver = null;
        String path = null;

        try {
        	
        	//Field field = result.getTestClass().getRealClass().getDeclaredField("driver");
           // field.setAccessible(true);
           // driver = (WebDriver) field.get(result.getInstance());
           driver = (WebDriver) result.getTestClass().getRealClass()
                   .getField("driver")
                  .get(result.getInstance());
            path = getScreenshot(result.getMethod().getMethodName(), driver);
            System.out.println("Starting path : " + path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (path != null) {
            extentTest.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
            System.out.println("Starting path : " + result.getMethod().getMethodName());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional - rarely used
    }

    @Override
    public void onStart(ITestContext context) {
        // This is required by ITestListener (TestNG 7+)
        // You can initialize reports or log info here
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
