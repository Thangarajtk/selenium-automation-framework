package com.automation.constants;

import com.automation.config.ConfigFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * Holds all the constant values used within the framework.
 * If some value needs to be changed often, then it should be stored in the property files
 *
 * @author Administrator
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");

    public static final int EXPLICIT_WAIT = 10;
    public static final String RESOURCES_PATH = PROJECT_PATH + File.separator + "src/test/resources";
    public static final String CONFIG_PROPERTIES_FILE_PATH = RESOURCES_PATH + File.separator + "config/config.properties";
    public static final String JSON_CONFIG_FILE_PATH = RESOURCES_PATH + File.separator + "config" + File.separator + "config.json";
    public static final String EXTENT_REPORTS_FOLDER_PATH = PROJECT_PATH + File.separator + "extent-test-output/";
    public static final String TEST_DATA_EXCEL_PATH = RESOURCES_PATH + File.separator + "data" + File.separator + "testdata.xlsx";
    public static final String RUN_MANAGER_SHEET = "RUNMANAGER";
    public static final String DATA_SHEET = "DATA";
    public static final String SCREENSHOT_PATH = PROJECT_PATH + File.separator + "screenshots";

    private static String extentReportFilePath = "";

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if (ConfigFactory.getConfig().override_report().equalsIgnoreCase("no")) {
            return EXTENT_REPORTS_FOLDER_PATH + File.separator + System.currentTimeMillis() + File.separator + "index.html";
        } else {
            return EXTENT_REPORTS_FOLDER_PATH + File.separator + "index.html";
        }
    }
}
