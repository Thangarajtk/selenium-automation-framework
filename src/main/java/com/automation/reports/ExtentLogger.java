package com.automation.reports;

import com.automation.enums.ConfigProperties;
import com.automation.utils.configloader.PropertyUtils;
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
		if (PropertyUtils.get(ConfigProperties.PASSED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build());
		} else {
			ExtentManager.getExtentTest().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		}
	}

	public static void fail(String message, Throwable t) {
		if (PropertyUtils.get(ConfigProperties.FAILED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {
			ExtentManager.getExtentTest().fail(MarkupHelper.createLabel(message, ExtentColor.RED))
					.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build())
					.fail(t);
		} else {
			ExtentManager.getExtentTest().fail(message).fail(t);
		}
	}

	public static void skip(String message) {
		if (PropertyUtils.get(ConfigProperties.SKIPPED_STEP_SCREENSHOTS).equalsIgnoreCase("yes")) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotService.getScreenshotAsBase64()).build());
		} else {
			ExtentManager.getExtentTest().log(Status.SKIP, message);
		}
	}
}
