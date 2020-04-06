package co.pragra.learning.fullstackqa.b15framework.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//#black-topbar ul>li:nth-child(1)>a
public class TopNavBar {

    private WebDriver driver;

    @FindBy(css = "#black-topbar ul>li:nth-child(1)>a")
    private WebElement reqDemo;

    @FindBy(css = "#black-topbar ul>li:nth-child(2)>a")
    private WebElement one800;

    @FindBy(css = "#black-topbar ul>li:nth-child(3)>a")
    private WebElement resources;

    @FindBy(css = "#black-topbar ul>li:nth-child(4)>a")
    private WebElement support;

    @FindBy(css = "#resourcesDropdown>li:nth-child(1)>a")
    private WebElement downlodZoom;

    @FindBy(css = "#resourcesDropdown>li:nth-child(3)>a")
    private WebElement videoTuts;

    @FindBy(css = "#resourcesDropdown>li:nth-child(5)>a")
    private WebElement liveTrainig;

    @FindBy(css = "#resourcesDropdown>li:nth-child(7)>a")
    private WebElement webinar;

    @FindBy(css = "#resourcesDropdown>li:nth-child(9)>a")
    private WebElement blog;

    @FindBy(css = "#resourcesDropdown>li:nth-child(11)>a")
    private WebElement faq;
<<<<<<< HEAD
    private WebElement PlanPricing;

=======
    
    
>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110
    public TopNavBar(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public RequestDemoPage  clickOnRequest(){
        this.reqDemo.click();
        return new RequestDemoPage(driver);
    }

    public DownLoadPage clickDownLoad(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources)
                .pause(1000)
                .moveToElement(downlodZoom)
                .click()
                .build()
                .perform();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Download Center - Zoom" );
        return new DownLoadPage(driver);
    }

    public VideoTutorialPage clickOnVideoTut(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources)
                .pause(1000)
                .moveToElement(videoTuts)
                .click()
                .build()
                .perform();
        return new VideoTutorialPage(driver);
    }

    public LiveTrainingPage clickOnLiveTra(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources)
                .pause(1000)
                .moveToElement(liveTrainig)
                .click()
                .build()
                .perform();
        return new LiveTrainingPage(driver);
    }

    public WebinarsEventsPage clickOnWebinarsEvents(){
        Actions actions = new Actions(driver);
        actions.moveToElement(resources)
                .pause(1000)
                .moveToElement(webinar)
                .click()
                .build()
                .perform();
        return new WebinarsEventsPage(driver);
    }
    public ZoomBlogPage clickOnBlog() {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources)
                .pause(1000)
                .moveToElement(blog)
                .click()
                .build()
                .perform();
        return new ZoomBlogPage(driver);
    }
    public ZoomFAQPage clickOnFaq() {
        Actions actions = new Actions(driver);
        actions.moveToElement(resources)
                .pause(1000)
                .moveToElement(faq)
                .click()
                .build()
                .perform();
        return new ZoomFAQPage(driver);
    }

    public SupportPage  clickOnSupport(){
        this.support.click();
        return new SupportPage(driver);
    }

    public WebElement getReqDemo() {
        return reqDemo;
    }

    public WebElement getOne800() {
        return one800;
    }

    public WebElement getResources() {
        return resources;
    }
    public WebElement getPlanPricingPage(){ return PlanPricing; }

<<<<<<< HEAD
   public WebElement getSupport() {return support; }
=======
    public SupportPage getSupport() {
    	this.support.click();
    	Set<String> sup = driver.getWindowHandles();
    	Iterator<String> it=sup.iterator();
    	String parentid= it.next();
    	String childid=it.next();
    	if(!parentid.equalsIgnoreCase(childid))
    	{
    		driver.switchTo().window(childid);
    		System.out.println(driver.getTitle());
    		Assert.assertEquals(driver.getTitle(), "Zoom Help Center");
    	}
    	driver.switchTo().window(parentid);
        return new SupportPage(driver);
    }
>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110

    public WebElement getDownlodZoom() {
        return downlodZoom;
    }

    public VideoTutorialPage getVideoTuts() {
    	Actions action = new Actions(driver);
    	action.moveToElement(resources).pause(1000).moveToElement(videoTuts).
    	contextClick(videoTuts).click().build().perform();
        return new VideoTutorialPage(driver);
    }

    public LiveTrainingPage getLiveTrainig() {
    	Actions action = new Actions(driver);
    	action.moveToElement(resources).pause(1000).moveToElement(liveTrainig).click().build().perform();
    	System.out.println(driver.getTitle());
    	Assert.assertEquals(driver.getTitle(),"Live Training Webinars – Zoom Help Center");
    	System.out.println(driver.getCurrentUrl());
    	driver.navigate().back();
        return new LiveTrainingPage(driver);
    }

    public WebinarPage getWebinar() {
    	Actions action=new Actions(driver);
    	action.moveToElement(resources).pause(1000).moveToElement(webinar).click().build().perform();
    	System.out.println(driver.getCurrentUrl());
    	System.out.println(driver.getTitle());
    	Assert.assertEquals(driver.getTitle(),"Events - Zoom");
        return new WebinarPage(driver);
    }
    public WebElement getBlog() {return blog;}
   public WebElement getFaq() {return faq;}

<<<<<<< HEAD
=======
    public ZoomBlogPage getBlog() {
    	Actions action = new Actions(driver);
    	action.moveToElement(resources).pause(1000).moveToElement(blog).click().build().perform();
    	System.out.println(driver.getTitle());
    	Assert.assertEquals(driver.getTitle(), "Zoom Blog - The Video Communications Company");
    	driver.navigate().back();
    	
        return new ZoomBlogPage(driver);
    }

    public Faq getFaq() {
    	Actions action =new Actions(driver);
    	action.moveToElement(resources).pause(2000).moveToElement(faq).pause(1000).click().build().perform();
    	System.out.println(driver.getTitle());
    	Assert.assertEquals(driver.getTitle(),"Frequently Asked Questions – Zoom Help Center");
    	
    	driver.navigate().back();
        return new Faq(driver);
    }
    
>>>>>>> a8649402476a66fc0d68eea3732b299dcbf37110
}
