package com.automation.reports;

import com.automation.config.ConfigFactory;
import com.automation.utils.screenshot.ScreenshotService;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExtentLogger {

    public static void pass(String message) {
        if (ConfigFactory.getConfig().passed_step_screenshots()) {
            ExtentManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build());
        } else {
            ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
        }
    }

    public static void fail(String message, Throwable t) {
        if (ConfigFactory.getConfig().failed_step_screenshots()) {
            ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED))
                    .fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build())
                    .fail(t);
        } else {
            ExtentManager.getExtentTest().fail(message).fail(t);
        }
    }

    public static void skip(String message) {
        if (ConfigFactory.getConfig().skipped_step_screenshots()) {
            ExtentManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build());
        } else {
            ExtentManager.getExtentTest().log(Status.SKIP, message);
        }
    }

    public static void info(String message) {

        ExtentManager.getExtentTest().info("<b>" + message + "</b>");
    }
}
