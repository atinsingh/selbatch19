package co.pragra.learning.fullstackqa.b15framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinMeetingPage {
    private WebDriver driver;

    @FindBy(name = "join-confno")
    private WebElement text;

    @FindBy(css = "#btnSubmit ")
    private WebElement JoinIn;

    public JoinMeetingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public JoinMeetingPage enterText(String email){

        this.text.sendKeys(email);
        return this;
    }
    public DashbordPage clickJoinIn(){
        this.JoinIn.click();
        return new DashbordPage(driver);
    }


}
