package com.automation.constants;

import com.automation.enums.ConfigProperties;
import com.automation.utils.configloader.PropertyUtils;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;

/**
 * Holds all the constant values used within the framework. If some value needs to be changed often, then it should be stored in the property files
 *
 * @author Administrator
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FrameworkConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");

    @Getter
    private static final int explicitWait = 10;
    @Getter
    private static final String resourcesPath = PROJECT_PATH + "/src/test/resources";
    @Getter
    private static final String chromeDriverPath = getResourcesPath() + "/executables/chromedriver.exe";
    @Getter
    private static final String propertiesFilePath = getResourcesPath() + File.separator + "config/config.properties";
    @Getter
    private static final String jsonConfigFilePath = getResourcesPath() + File.separator + "config/config.json";
    @Getter
    private static final String extentReportFolderPath = PROJECT_PATH + File.separator + "extent-test-output/";
    @Getter
    private static final String excelPath = getResourcesPath() + File.separator + "excel" + File.separator + "testdata.xlsx";
    @Getter
    private static final String runManagerSheet = "RUNMANAGER";
    @Getter
    private static final String iterationDataSheet = "DATA";
    @Getter
    private static final String screenshotPath = PROJECT_PATH + File.separator + "screenshots";

    private static String extentReportFilePath = "";

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if (PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return getExtentReportFolderPath() + File.separator + System.currentTimeMillis() + File.separator + "index.html";
        } else {
            return getExtentReportFolderPath() + File.separator + "index.html";
        }
    }
}
