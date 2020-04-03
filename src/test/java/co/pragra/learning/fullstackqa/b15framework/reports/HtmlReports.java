package co.pragra.learning.fullstackqa.b15framework.reports;

import co.pragra.learning.fullstackqa.b15framework.utils.FrameWorkUtls;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class HtmlReports {
    private ExtentReports reports;
    private static HtmlReports instance;

    private HtmlReports() {
        reports = new ExtentReports();
        reports.attachReporter(new ExtentHtmlReporter(FrameWorkUtls.getReportFile()));
    }

    public static ExtentReports getReport(){
        if(instance==null){
            instance = new HtmlReports();
        }
        return instance.reports;

    }


}
