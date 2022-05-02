package com.automation.driver.entity;

import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import lombok.Builder;
import lombok.Getter;

/**
 * Builder pattern helps in creating immutable classes with a large set of state attributes
 *
 */
@Builder
@Getter
public class DriverData {

    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
}
