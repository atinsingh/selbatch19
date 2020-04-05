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

    @FindBy(css = "#resourcesDropdown>li:nth-child(9)>a")
    private WebElement faq;

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
        return new DownLoadPage(driver);
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

    public WebElement getDownlodZoom() {
        return downlodZoom;
    }

    public VideoTutorialPage getVideoTuts() {
    	Actions action = new Actions(driver);
    	action.moveToElement(resources).pause(1000).moveToElement(videoTuts).
    	contextClick(videoTuts).click().build().perform();
        return new VideoTutorialPage(driver);
    }

    public WebElement getLiveTrainig() {
        return liveTrainig;
    }

    public WebElement getWebinar() {
        return webinar;
    }

    public WebElement getBlog() {
        return blog;
    }

    public WebElement getFaq() {
        return faq;
    }
}
