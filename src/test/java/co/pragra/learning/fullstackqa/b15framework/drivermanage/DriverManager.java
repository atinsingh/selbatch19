package co.pragra.learning.fullstackqa.b15framework.drivermanage;

import co.pragra.learning.fullstackqa.b15framework.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Main class which will create WebDriver and return the intance;
 */
public class DriverManager {
    private WebDriver driver;
    private static DriverManager manager;

    private DriverManager(){
        if(Config.getProperty("browser.type").equals(BrowserTypes.CHROME)){
            System.setProperty(BrowserTypes.getDriverProperty(BrowserTypes.CHROME), Config.getProperty("chrome.location"));
            driver = new ChromeDriver();
        }else if(Config.getProperty("browser.type").equals(BrowserTypes.FIREFOX)){
            System.setProperty(BrowserTypes.getDriverProperty(BrowserTypes.FIREFOX), Config.getProperty("firefox.location"));
            driver = new FirefoxDriver();
        }else {
            System.setProperty(BrowserTypes.getDriverProperty(BrowserTypes.CHROME), Config.getProperty("chrome.location"));
            driver = new ChromeDriver();
        }

    }

    /**
     *
     * @return
     */
    // added synchronization to avoid multi browser
    public  static WebDriver getDriver(){

            if(manager==null){
                manager = new DriverManager();
            }

        return manager.driver;
    }
}
