package co.pragra.learning.fullstackqa.b15framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ContactSalesPage {
    private WebDriver driver;


    private WebElement cntactsales;

    public ContactSalesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public DashbordPage clickContactSalesIn(){
        this.cntactsales.click();
        return new DashbordPage(driver);
    }
}
