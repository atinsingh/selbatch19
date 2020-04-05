package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import co.pragra.learning.fullstackqa.b15framework.listeners.ScreenshotListener;
import co.pragra.learning.fullstackqa.b15framework.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ScreenshotListener.class)
public class TopNavBarTest {
    WebDriver driver;
    TopNavBar navBar;
    RequestDemoPage demoPage;
    VideoTutorialPage videoTutorialPage;
    WebinarsEventsPage webinarsEventsPage;
    ZoomBlogPage zoomBlogPage;
    SupportPage supportPage;
    ZoomFAQPage zoomFaqPage;
    LiveTrainingPage liveTrainingPage;
    PlanPricingPage PlanPricingPage;



    @BeforeSuite
    public void setUp() {
//        driver   = DriverManager.getDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://zoom.us/");
    }

    @Test
    public void testClickOnRequestDemo(){
        navBar = new TopNavBar(driver);
        demoPage = navBar.clickOnRequest();
        Assert.assertEquals("https://zoom.us/livedemo",driver.getCurrentUrl());
    }

    @Test
    public void testClickOnVideoTutorial()
    {
        navBar = new TopNavBar(driver);
        videoTutorialPage = navBar.clickOnVideoTut();
        Assert.assertEquals("Video Tutorial - The Video Communications Company",driver.getTitle());
    }
    @Test
    public void testClickOnLiveTraining()
    {
        navBar = new TopNavBar(driver);
        liveTrainingPage = navBar.clickOnLiveTra();
        Assert.assertEquals("Live Training",driver.getTitle());
    }
    @Test
    public void testClickOnWebinarsEvents()
    {
        navBar = new TopNavBar(driver);
        webinarsEventsPage = navBar.clickOnWebinarsEvents();
        Assert.assertEquals("Webinars and Events",driver.getTitle());
    }
    @Test
    public void testClickOnBlog()
    {
        navBar = new TopNavBar(driver);
        zoomBlogPage = navBar.clickOnBlog();
        Assert.assertEquals("Zoom Blog - The Video Communications Company",driver.getTitle());
    }
    @Test
    public void testClickOnFaq()
    {
        navBar =new TopNavBar(driver);
        zoomFaqPage = navBar.clickOnFaq();
        Assert.assertEquals("Frequently asked questions", driver.getTitle());
    }


    @Test
    public void testClickOnSupport()
    {
        navBar =new TopNavBar(driver);
        supportPage = navBar.clickOnSupport();
        Assert.assertEquals("https://support.zoom.us/hc/en-us", driver.getTitle());
    }

    @Test
    public void PlanPricing()
    {

        driver.get("https://zoom.us/pricing");
        PlanPricingPage page =new PlanPricingPage(driver);
        page.clickPlanPricingIn();

    }
    @Test
    public void ContactSales()
    {
        driver.get("https://zoom.us/contactsales");
        ContactSalesPage page =new ContactSalesPage(driver);
        page.clickContactSalesIn();
    }

    @Test
    public void JoinMeeting(){

        driver.get("https://zoom.us/join");
        JoinMeetingPage page = new JoinMeetingPage(driver);
        page
                .enterText("poonamkhokher@gmail.com")
                .clickJoinIn();
    }
    @Test
    public void signInTest(){

        driver.get("https://zoom.us/signin");
        SignInPage page = new SignInPage(driver);
            page
                .enterEmail("poonamkhokher@gmail.com")
                .enterPassword("password")
                .clickSignIn();
    }



    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
