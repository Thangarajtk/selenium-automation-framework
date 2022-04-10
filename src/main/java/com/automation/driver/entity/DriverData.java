package com.automation.driver.entity;

import com.automation.enums.BrowserRemoteModeType;
import com.automation.enums.BrowserType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DriverData {

    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
}
