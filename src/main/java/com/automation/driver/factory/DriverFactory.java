package com.automation.driver.factory;

import com.automation.driver.IDriver;
import com.automation.driver.LocalDriver;
import com.automation.driver.RemoteDriver;
import com.automation.enums.RunType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    private static final Map<RunType, Supplier<IDriver>> WEB = new EnumMap<>(RunType.class);

    static {
        WEB.put(RunType.LOCAL, LocalDriver::new);
        WEB.put(RunType.REMOTE, RemoteDriver::new);
    }

    public static IDriver getDriver(RunType runType) {

        return WEB.get(runType).get();
    }
}