package com.automation.reports;

import com.automation.constants.FrameworkConstants;
import com.automation.driver.manager.DriverManager;
import com.automation.enums.Authors;
import com.automation.enums.CategoryType;
import com.automation.exceptions.ReportInitializationFailedException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentReport {

    private static ExtentReports extentReports;
    private static final ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFolderPath());

    public static void initReports() {
        try {
            if (Objects.isNull(extentReports)) {
                extentReports = new ExtentReports();
                extentReports.attachReporter(extentSparkReporter);
                InetAddress ip = InetAddress.getLocalHost();
                String hostname = ip.getHostName();
                extentReports.setSystemInfo("Host Name", hostname);
                extentReports.setSystemInfo("Environment", "Web Automation - Selenium");
                extentReports.setSystemInfo("User Name", System.getProperty("user.name"));
                extentSparkReporter.config().setDocumentTitle("HTML Report");
                extentSparkReporter.config().setReportName("Web Automation Testing");
                extentSparkReporter.config().setTheme(Theme.DARK);
            }
        } catch (Exception e) {
            throw new ReportInitializationFailedException("Failed to initialize extent report", e);
        }
    }

    public static void flushReports() {
        if (Objects.nonNull(extentReports)) {
            extentReports.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testName) {
        ExtentManager.setExtentTest(extentReports.createTest(testName));
    }

    public static void addAuthors(Authors[] authors) {
        for (Authors author : authors) {
            ExtentManager.getExtentTest().assignAuthor(author.toString());
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType categoryType : categories) {
            ExtentManager.getExtentTest().assignCategory(categoryType.toString());
        }
    }

    public static void addBrowsers() {
        ExtentManager.getExtentTest().assignDevice(getBrowserDetails(DriverManager.getDriver()));
    }

    public static String getBrowserDetails(WebDriver driver) {
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toUpperCase();
        String browserVersion = ((RemoteWebDriver) driver).getCapabilities().getBrowserVersion();

        return browserName + " - " + browserVersion;
    }
}
