package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.config.Config;
import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import co.pragra.learning.fullstackqa.b15framework.listeners.ScreenshotListener;
import co.pragra.learning.fullstackqa.b15framework.reports.HtmlReports;
import co.pragra.learning.fullstackqa.b15framework.utils.CaptureType;
import co.pragra.learning.fullstackqa.b15framework.utils.FrameWorkUtls;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({ScreenshotListener.class})
public class HomePageTest {

    ExtentTest test = HtmlReports.getReport().createTest("HomePageTest");
    @Test(enabled = false)
    public void testBrosweProperty(){
        System.out.println(Config.getProperty("browser.type"));
        Assert.assertEquals("chrome", Config.getProperty("browser.type"));
    }

    @Test(enabled = false, expectedExceptions = IllegalArgumentException.class)
    public void nonExitenceKeytest(){
        Config.getProperty("bac");
    }

    @Test()
    public void testBroser() throws InterruptedException, IOException {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Config.getProperty("app.url"));
        test.log(Status.PASS, "APP URL OPENED SUCCEFFULLY");
        test.addScreenCaptureFromPath(FrameWorkUtls.captureScreen("testBroser", CaptureType.PASS));
        Thread.sleep(5000);
        driver.quit();
        HtmlReports.getReport().flush();
    }


}
