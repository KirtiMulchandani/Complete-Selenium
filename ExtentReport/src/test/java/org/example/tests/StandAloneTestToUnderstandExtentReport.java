package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StandAloneTestToUnderstandExtentReport {
    ExtentReports extent;

    @BeforeTest
    public void config(){
        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("WEB-UI Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("TesterName", "Kirti Mulchandani");
    }

    @Test
    public void initializeTest(){
        extent.createTest("initializeTest");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mvnrepository.com/");
        System.out.println(driver.getTitle());
        driver.close();
        extent.flush();
    }
}
