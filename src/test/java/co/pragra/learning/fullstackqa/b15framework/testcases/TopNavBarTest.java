package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import co.pragra.learning.fullstackqa.b15framework.listeners.ScreenshotListener;
import co.pragra.learning.fullstackqa.b15framework.pages.RequestDemoPage;
import co.pragra.learning.fullstackqa.b15framework.pages.TopNavBar;
import co.pragra.learning.fullstackqa.b15framework.pages.ZoomBlogPage;
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
    ZoomBlogPage zoomBlogPage;

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

    @Test
    public void testClickOnBlog() {
        navBar = new TopNavBar(driver);
        zoomBlogPage = navBar.clickOnBlog();
        Assert.assertEquals("Zoom Blog - The Video Communications Company",driver.getTitle());


    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
