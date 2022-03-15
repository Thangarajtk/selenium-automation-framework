package com.automation.utils.screenshot;

import com.automation.constants.FrameworkConstants;
import com.automation.driver.manager.DriverManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScreenshotUtils {

    // This class is to handle the change in third party library
    @SneakyThrows
    public static void captureScreenshotAsFile(String testCaseName) {
        File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File(FrameworkConstants.getScreenshotPath() + File.separator + testCaseName + ".png");
        FileUtils.copyFile(source, destination);
    }

    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
