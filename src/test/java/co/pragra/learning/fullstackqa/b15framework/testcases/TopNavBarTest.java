package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import co.pragra.learning.fullstackqa.b15framework.listeners.ScreenshotListener;
<<<<<<< HEAD
import co.pragra.learning.fullstackqa.b15framework.pages.*;
=======
import co.pragra.learning.fullstackqa.b15framework.pages.DownLoadPage;
import co.pragra.learning.fullstackqa.b15framework.pages.Faq;
import co.pragra.learning.fullstackqa.b15framework.pages.LiveTrainingPage;
import co.pragra.learning.fullstackqa.b15framework.pages.RequestDemoPage;
import co.pragra.learning.fullstackqa.b15framework.pages.SignInPage;
import co.pragra.learning.fullstackqa.b15framework.pages.SupportPage;
import co.pragra.learning.fullstackqa.b15framework.pages.TopNavBar;
import co.pragra.learning.fullstackqa.b15framework.pages.VideoTutorialPage;
import co.pragra.learning.fullstackqa.b15framework.pages.WebinarPage;
import co.pragra.learning.fullstackqa.b15framework.pages.ZoomBlogPage;

>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
<<<<<<< HEAD
import org.testng.annotations.*;
=======
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110

@Listeners(ScreenshotListener.class)
public class TopNavBarTest {
    WebDriver driver;
    TopNavBar navBar;
    RequestDemoPage demoPage;
<<<<<<< HEAD
    VideoTutorialPage videoTutorialPage;
    WebinarsEventsPage webinarsEventsPage;
    ZoomBlogPage zoomBlogPage;
    SupportPage supportPage;
    ZoomFAQPage zoomFaqPage;
    LiveTrainingPage liveTrainingPage;
    PlanPricingPage PlanPricingPage;


=======
    SupportPage supportPage;
    VideoTutorialPage vidPage;
    DownLoadPage downloadpage;
    LiveTrainingPage livetrainingpage;
    WebinarPage webinarpage;
    ZoomBlogPage zoomblogpage;
    Faq faq1;
    
>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110

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
<<<<<<< HEAD

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
=======
   
    @Test(dataProvider="dummyDataProvider")
    public void signInTest(String email , String pass){
        driver.get("https://zoom.us/signin");
        SignInPage page = new SignInPage(driver);
            page
                .enterEmail(email)
                .enterPassword(pass)
>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110
                .clickSignIn();
    }
    @Test
    public void clickOnDownloadZoom() {
    	navBar=new TopNavBar(driver);
    	downloadpage=navBar.clickDownLoad();
    	
    }
    @Test(dependsOnMethods="testClickOnRequestDemo")
    public void clickSupportPage()
    {
    	navBar = new TopNavBar(driver);
    	supportPage=navBar.getSupport();
    	
    }
    @Test(dependsOnMethods="clickSupportPage")
    public void clickOnVideoTutorial()
    {
    	navBar = new TopNavBar(driver);
    	vidPage=navBar.getVideoTuts();
    }
    @Test
    public void clickOnLiveTraining() {
    	navBar = new TopNavBar(driver);
    	livetrainingpage = navBar.getLiveTrainig();
    }
    @Test
    public void clickOnWebinarEvents() {
    	navBar = new TopNavBar(driver);
    	webinarpage= navBar.getWebinar();
    	
    }
    @Test
    public void clickOnZoomBlog() {
    	navBar = new TopNavBar(driver);
    	zoomblogpage = navBar.getBlog();
    	
    }
    @Test
    public void clickOnFaq() {
    	navBar = new TopNavBar(driver);
    	faq1 = navBar.getFaq();
    	
    }
    	
    
    @DataProvider
    public Object[][] dummyDataProvider(){
        return new Object[][] {
                                    {"Atin@pragra.co","112345"} ,
                                    {"Vivek@pragra.co","16432"} ,
                                    {"harman123@gmail.com","9878675"}
                               };
    }
    



    @AfterSuite
    public void tearDown()
    {
        driver.quit();
    }
}
