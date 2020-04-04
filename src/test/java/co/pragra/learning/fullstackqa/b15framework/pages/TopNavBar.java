package co.pragra.learning.fullstackqa.b15framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



    public WebElement getReqDemo() {
        return reqDemo;
    }

    public WebElement getOne800() {
        return one800;
    }

    public WebElement getResources() {
        return resources;
    }

    public WebElement getSupport() {
        return support;
    }

    public WebElement getDownlodZoom() {
        return downlodZoom;
    }

    public WebElement getVideoTuts() {
        return videoTuts;
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
