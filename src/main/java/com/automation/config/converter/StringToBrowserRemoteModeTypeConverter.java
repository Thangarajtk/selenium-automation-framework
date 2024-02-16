package com.automation.config.converter;

import com.automation.enums.BrowserRemoteModeType;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserRemoteModeTypeConverter implements Converter<BrowserRemoteModeType> {

    @Override
    public BrowserRemoteModeType convert(Method method, String browserRemoteModeType) {
        Map<String, BrowserRemoteModeType> stringBrowserRemoteModeTypeMap = Map.
                of("SELENOID", BrowserRemoteModeType.SELENOID,
                        "SELENIUMGRID", BrowserRemoteModeType.SELENIUMGRID);

        return stringBrowserRemoteModeTypeMap.getOrDefault(browserRemoteModeType.toUpperCase(),
                BrowserRemoteModeType.SELENOID);
    }
}
