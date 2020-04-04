package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import co.pragra.learning.fullstackqa.b15framework.listeners.ScreenshotListener;
import co.pragra.learning.fullstackqa.b15framework.pages.RequestDemoPage;
import co.pragra.learning.fullstackqa.b15framework.pages.TopNavBar;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class TopNavBarTest {
    WebDriver driver;
    TopNavBar navBar;
    RequestDemoPage demoPage;

    @BeforeSuite
    public void setUp() {
        driver   = DriverManager.getDriver();
        driver.get("https://zoom.us/");
    }

    @Test
    public void testClickOnRequestDemo(){
        navBar = new TopNavBar(driver);
        demoPage = navBar.clickOnRequest();
        Assert.assertEquals("https://zoom.us/livedemo",driver.getCurrentUrl());
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
