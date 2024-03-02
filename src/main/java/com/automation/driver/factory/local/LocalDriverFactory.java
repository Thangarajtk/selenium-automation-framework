package com.automation.driver.factory.local;

import com.automation.driver.manager.local.ChromeManager;
import com.automation.driver.manager.local.EdgeManager;
import com.automation.driver.manager.local.FirefoxManager;
import com.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalDriverFactory {

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
        MAP.put(BrowserType.EDGE, EdgeManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }
}
