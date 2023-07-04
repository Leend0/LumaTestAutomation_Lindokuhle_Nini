package com.digilink.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.digilink.application.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public  class ExtentReport {

    public static ExtentReports extent;
    private static ExtentSparkReporter spark;
    private static WebDriver driver = Test.driver;
    @BeforeSuite
    public static void initReports() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("C:/Users/digilink/Downloads/SeleniumRevision/LumaAssessment/src/test/java/extentReport/spark.html");
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Reports");
    }

    public static ExtentTest createTest(String testcasename) {
        ExtentTest test = extent.createTest(testcasename);
        return test;
    }

    public static String getScreenshot(String testCaseName) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String fileName = "image_" + testCaseName + "_" + timestamp + ".png";
        String path = System.getProperty("user.dir") + "src/test/java/extentReport/Screenshots/" + fileName;
        FileUtils.copyFile(source, new File(path));
        return path;
    }

    @AfterSuite
    public static void flushReports() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("C:/Users/digilink/Downloads/SeleniumRevision/LumaAssessment/src/test/java/extentReport/spark.html").toURI());
    }
}