package co.pragra.learning.fullstackqa.b15framework.listeners;

import co.pragra.learning.fullstackqa.b15framework.utils.CaptureType;
import co.pragra.learning.fullstackqa.b15framework.utils.FrameWorkUtls;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        FrameWorkUtls.captureScreen(iTestResult.getName(), CaptureType.PASS);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        FrameWorkUtls.captureScreen(iTestResult.getName(), CaptureType.FAIL);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
