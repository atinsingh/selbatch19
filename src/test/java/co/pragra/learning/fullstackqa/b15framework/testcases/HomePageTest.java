package co.pragra.learning.fullstackqa.b15framework.testcases;

import co.pragra.learning.fullstackqa.b15framework.config.Config;
import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest {

    @Test
    public void testBrosweProperty(){
        System.out.println(Config.getProperty("browser.type"));
        Assert.assertEquals("chrome", Config.getProperty("browser.type"));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void nonExitenceKeytest(){
        Config.getProperty("bac");
    }

    @Test
    public void testBroser() throws InterruptedException {
        WebDriver driver = DriverManager.getDriver();
        driver.get(Config.getProperty("app.url"));
        Thread.sleep(5000);
        driver.quit();
    }
}
