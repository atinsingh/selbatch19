package co.pragra.learning.fullstackqa.b15framework.drivermanage;

import java.util.HashMap;
import java.util.Map;

public class BrowserTypes {
    /********** BROWER TYPE**********/
    public static final String CHROME       = "chrome";
    public static final String FIREFOX      = "firefox";
    public static final String SAFARI       = "safari";
    public static final String OPERA        = "opera";
    public static final String EDGE         = "edge";
    public static final String IE           = "ie";

    private static Map<String,String> driverPropertyName = new HashMap<>();

    public static String getDriverProperty(String broswer){
            init();
            return driverPropertyName.get(broswer);
    }

    private static void init(){
        driverPropertyName.put(CHROME, "webdriver.chrome.driver");
        driverPropertyName.put(FIREFOX, "webdriver.gecko.driver");
        driverPropertyName.put(OPERA, "webdriver.opera.driver");


    }
}
