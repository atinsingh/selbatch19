package co.pragra.learning.fullstackqa.b15framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PlanPricingPage {
    private WebDriver driver;


    private WebElement pricing;

    public PlanPricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public DashbordPage clickPlanPricingIn(){
        this.pricing.click();
        return new DashbordPage(driver);
    }
}
