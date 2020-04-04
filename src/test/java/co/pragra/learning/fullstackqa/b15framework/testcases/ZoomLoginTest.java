package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class ZoomLoginTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver   = DriverManager.getDriver();
        driver.get("https://zoom.us/signin");
    }

    public void testLoginPositive(){
       Assert.assertEquals("Sign In - Zoom", driver.getTitle());
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("atin@pragra.co");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("*******");

    }

    public void negative(){
        Assert.assertEquals("Sign In - Zoom", driver.getTitle());
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("atin@pragra.co");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("*******");

    }

}
