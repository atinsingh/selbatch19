package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import co.pragra.learning.fullstackqa.b15framework.listeners.ScreenshotListener;
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

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class TopNavBarTest {
    WebDriver driver;
    TopNavBar navBar;
    RequestDemoPage demoPage;
    SupportPage supportPage;
    VideoTutorialPage vidPage;
    DownLoadPage downloadpage;
    LiveTrainingPage livetrainingpage;
    WebinarPage webinarpage;
    ZoomBlogPage zoomblogpage;
    Faq faq1;
    

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
   
    @Test(dataProvider="dummyDataProvider")
    public void signInTest(String email , String pass){
        driver.get("https://zoom.us/signin");
        SignInPage page = new SignInPage(driver);
            page
                .enterEmail(email)
                .enterPassword(pass)
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
    public void tearDown(){
        driver.quit();
    }
}
