package co.pragra.learning.fullstackqa.b15framework.pages;

import org.apache.commons.math3.analysis.function.Sin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class SignInPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement pass;
    @FindBy(css = "#login-form .signin>a")
    private WebElement singin;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public SignInPage enterEmail(String email){
        this.email.sendKeys(email);
        return this;
    }

    public SignInPage enterPassword(String pass){
        this.pass.sendKeys(pass);
        return this;
    }

    public DashbordPage clickSignIn(){
        this.singin.click();
        return new DashbordPage(driver);
    }



}
