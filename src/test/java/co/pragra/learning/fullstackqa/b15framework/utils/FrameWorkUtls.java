package co.pragra.learning.fullstackqa.b15framework.utils;

import co.pragra.learning.fullstackqa.b15framework.config.Config;
import co.pragra.learning.fullstackqa.b15framework.drivermanage.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FrameWorkUtls {

    private static Map<String, String> testcaseScreenShotMap = new HashMap<>();

    private static void createDirs(String type){
       try {
           if (type.equals("screenshot")) {
               Files.createDirectories(
                       Paths.get(Config.getProperty("screenshot.pass.dir")));
               Files.createDirectories(
                       Paths.get(Config.getProperty("screenshot.fail.dir")));

           }
           if(type.equals("report")){
               Files.createDirectories(
                       Paths.get(Config.getProperty("report.dir")));

           }
       }catch (IOException ex){

       }
    }

    private static String generateScreenShotFileName(String testCaseName){
        SimpleDateFormat format = new SimpleDateFormat(Config.getProperty("screenshot.file.pattern"));
        return  testCaseName+"_"+format.format(new Date())+Config.getProperty("screenshot.file.extension");
    }

    public static String captureScreen(String testCase, CaptureType type){
        createDirs("screenshot");
        String fileName = generateScreenShotFileName(testCase);
        final File screenCapture = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        Path path;
        if(type==CaptureType.PASS) {
             path = Paths.get(Config.getProperty("screenshot.pass.dir"), fileName);
        }else {
            path = Paths.get(Config.getProperty("screenshot.fail.dir"), fileName);
        }
            try {
                Files.copy(screenCapture.toPath(),path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        testcaseScreenShotMap.put(testCase,path.toString());
        return path.toString();
    }

    public static File getReportFile(){
        createDirs("report");
        SimpleDateFormat format = new SimpleDateFormat(Config.getProperty("screenshot.file.pattern"));
        String fileName = Config.getProperty("report.filename") +".html";

        Path path = Paths.get( Config.getProperty("report.dir") , fileName);

        System.out.println(path.toString());
       return  new File(path.toString());

    }
}
