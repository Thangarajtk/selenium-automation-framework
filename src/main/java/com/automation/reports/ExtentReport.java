package com.automation.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;
import com.automation.constants.FrameworkConstants;
import com.automation.enums.CategoryType;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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
			e.printStackTrace();
		}
	}

	public static void flushReports() {
		if(Objects.nonNull(extentReports)) {
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
	
	public static void addAuthors(String[] authors) {
		for(String temp:authors) {
			ExtentManager.getExtentTest().assignAuthor(temp);
		}
	}
	
	public static void addCategories(CategoryType[] categories) {
		for(CategoryType temp:categories) {
			ExtentManager.getExtentTest().assignCategory(temp.toString());
		}
	}




}
